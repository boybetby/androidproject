package com.example.project;

import static com.example.lib.RetrofitClient.getRetrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.lib.Model.CartListModel;
import com.example.lib.Model.ProductsModel;
import com.example.lib.interfaceRepository.Methods;
import com.example.project.Fragments.ChatFragment;
import com.example.project.Fragments.CartFragment;
import com.example.project.Fragments.HomeFragment;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.microsoft.signalr.HubConnection;
import com.microsoft.signalr.HubConnectionBuilder;

import java.io.Serializable;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity{

    MeowBottomNavigation bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        bottomNavigation = findViewById(R.id.bottom_navigation);

        bottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.ic_home));
        bottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.ic_cart));
        bottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.ic_chat));

        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                Fragment fragment = null;

                switch (item.getId()){
                    case 1:
                        fragment = new HomeFragment();
                        break;
                    case 2:
                        Bundle bundle = new Bundle();
                        if(cartlist.isEmpty()){
                            fragment = new CartFragment();
                        }
                        else{
                            bundle.putSerializable("cartlist", cartlist);
                            fragment= new CartFragment();
                            fragment.setArguments(bundle);
//                            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, nextFrag, "findThisFragment").commit();
                        }
                        break;
                    case 3:
                        fragment = new ChatFragment();
//                        startSignalR();
                        break;
                }

                loadFragment(fragment);
            }
        });

        bottomNavigation.setCount(2,"0");
        bottomNavigation.show(1,true);

        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {

            }
        });

        //an lai lan nua
        bottomNavigation.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {
                Fragment fragment = null;

                switch (item.getId()){
                    case 1:
                        fragment = new HomeFragment();
                        break;
                    case 2:
                        Bundle bundle = new Bundle();
                        if(cartlist.isEmpty()){
                            fragment = new CartFragment();
                        }
                        else{
                            bundle.putSerializable("cartlist", cartlist);
                            fragment= new CartFragment();
                            fragment.setArguments(bundle);
//                            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, nextFrag, "findThisFragment").commit();
                        }
                        break;
                    case 3:
                        fragment = new ChatFragment();
//                        startSignalR();
                        break;
                }

                loadFragment(fragment);
            }
        });

    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout, fragment)
                .commit();
    }

    ElegantNumberButton numberButton;
    int cartCount = 0;
    TextView txtProductName, txtProductID;
    ArrayList<CartListModel> cartlist = new ArrayList<>();

    public void addtoCart(View view) {
        numberButton = findViewById(R.id.amountButton);
        cartCount += Integer.parseInt(numberButton.getNumber());
        bottomNavigation.setCount(2,Integer.toString(cartCount));

        txtProductID = findViewById(R.id.detailID);
        txtProductName = findViewById(R.id.detailName);

        String Name = txtProductName.getText().toString();
        displayMessage(view, Name, numberButton.getNumber());

        findProduct(txtProductID.getText().toString(), Integer.parseInt(numberButton.getNumber()));
    }

    public void findProduct(String id, int amount){
        Methods methods = getRetrofit().create(Methods.class);
        Call<ProductsModel> call = methods.getDetail(id);
        call.enqueue(new Callback<ProductsModel>() {
            @Override
            public void onResponse(Call<ProductsModel> call, Response<ProductsModel> response) {
                ProductsModel data = response.body();
                cartlist.add(new CartListModel(data, amount));
            }
            @Override
            public void onFailure(Call<ProductsModel> call, Throwable t) {
                Log.v("log:", t.getMessage());
            }
        });
    }

    public void displayMessage(View view,String productName, String amount){
        Context context = getApplicationContext();
        CharSequence text ="Đã thêm " + amount + " " + productName + " vào giỏ hàng!";
        int duration = BaseTransientBottomBar.LENGTH_SHORT;

        Snackbar mySnackbar = Snackbar.make(view, text, duration);

        View snackbarView = mySnackbar.getView();
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        lp.setMargins(0, 1600, 0, 0);
        snackbarView.setLayoutParams(lp);

        mySnackbar.show();
    }

    public void displayEmpty(View view,String text){
        Context context = getApplicationContext();
        int duration = BaseTransientBottomBar.LENGTH_SHORT;

        Snackbar mySnackbar = Snackbar.make(view, text, duration);
        View snackbarView = mySnackbar.getView();
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        lp.setMargins(0, 1500, 0, 0);
        snackbarView.setLayoutParams(lp);

        mySnackbar.show();
    }

    public void CheckOut(View view) {
        Intent newActivity = new Intent(MainActivity.this, OrderActivity.class );
        if(cartlist.size()==0){
            String message = "Bạn chưa thêm sản phẩm vào giỏ hàng";
            displayEmpty(view, message);
        }
        else{
            newActivity.putExtra("cartlist", (Serializable) cartlist);
            startActivity(newActivity);
        }
    }

    private HubConnection hubConnection;
    ArrayAdapter<String> messageArrayAdapter;
    EditText txtMessage;
    ListView lvMessage;

    public void startSignalR() {
        LayoutInflater inflater = getLayoutInflater();
        View chatView = inflater.inflate(R.layout.fragment_chat, null);
        lvMessage = chatView.findViewById(R.id.lvMessage);

        messageArrayAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1);

        hubConnection = HubConnectionBuilder.create("http://10.0.2.2:8089/chatHub")
                .build();
        hubConnection.on("ReceiveMessage", (user, message) -> {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Log.v("Log", user + ":" + message);
                    messageArrayAdapter.add(user + ":" + message);
                    messageArrayAdapter.notifyDataSetChanged();
                }
            });
        }, String.class, String.class);
        hubConnection.start();
    }
//    public interface IGetValue{
//        String getEditTextValue();
//    }
//
//    public void Send(View view) {
//        LayoutInflater inflater = getLayoutInflater();
//        View chatView = inflater.inflate(R.layout.fragment_chat, null);
//
//        String message = txtMessage.getText().toString();
//
//        txtMessage.setText("");
//        String name = "Minh";
//        try {
//            hubConnection.send("SendMessage", name, message);
//        }
//        catch (Exception exception){
//            Log.v("error: ", exception.getMessage());
//        }
//    }

}
