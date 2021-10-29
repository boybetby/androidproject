package com.example.project;

import static com.example.lib.RetrofitClient.getRetrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.lib.Model.CartListModel;
import com.example.lib.Model.ProductsModel;
import com.example.lib.interfaceRepository.Methods;
import com.example.project.Fragments.AboutFragment;
import com.example.project.Fragments.CartFragment;
import com.example.project.Fragments.HomeFragment;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

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

        bottomNavigation = findViewById(R.id.bottom_navigation);

        bottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.ic_home));
        bottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.ic_cart));
        bottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.ic_about));

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
                        fragment = new AboutFragment();
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
                        fragment = new AboutFragment();
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


    public void setCartCount(int count){
        bottomNavigation.setCount(2,String.valueOf(count));
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

        getProduct(txtProductID.getText().toString(), Integer.parseInt(numberButton.getNumber()));

        Log.v("log", Integer.toString(cartlist.size()));
//        cartlist.add();
    }

    public void getProduct(String id, int amount){
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
}
