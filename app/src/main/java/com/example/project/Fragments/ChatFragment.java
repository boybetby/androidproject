package com.example.project.Fragments;

import static com.example.lib.RetrofitClient.getRetrofit;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;


import com.example.lib.Model.Customer;
import com.example.lib.Model.CustomerResponse;
import com.example.lib.interfaceRepository.Methods;
import com.example.project.MainActivity;
import com.example.project.R;
import com.google.zxing.WriterException;
import com.microsoft.signalr.HubConnection;
import com.microsoft.signalr.HubConnectionBuilder;
import com.microsoft.signalr.HubConnectionState;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChatFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChatFragment extends Fragment{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ChatFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AboutFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ChatFragment newInstance(String param1, String param2) {
        ChatFragment fragment = new ChatFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private HubConnection hubConnection;
    ArrayAdapter<String> messageArrayAdapter;
    EditText txtUsername, txtPassword;
    Dialog dialog;
    Button btnLogin, processLoginBtn;
    ImageView qrImage;
    Bitmap bitmap;
    QRGEncoder qrgEncoder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_chat, container, false);

        qrImage = rootView.findViewById(R.id.qrImage);
        btnLogin = rootView.findViewById(R.id.btnLogin);

        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getContext());
        settings.edit().clear().commit();
        String ret = settings.getString("jwt", "0");
        if(ret != "0") {
            WindowManager manager = (WindowManager) getActivity().getSystemService(Context.WINDOW_SERVICE);

            // initializing a variable for default display.
            Display display = manager.getDefaultDisplay();

            // creating a variable for point which
            // is to be displayed in QR Code.
            Point point = new Point();
            display.getSize(point);

            // getting width and
            // height of a point
            int width = point.x;
            int height = point.y;

            // generating dimension from width and height.
            int dimen = width < height ? width : height;
            dimen = dimen * 3 / 4;
            qrgEncoder = new QRGEncoder(ret, null, QRGContents.Type.TEXT, dimen);
            try {
                bitmap = qrgEncoder.encodeAsBitmap();

                qrImage.setImageBitmap(bitmap);
            } catch (WriterException e) {

                Log.e("Tag", e.toString());
            }
            btnLogin.setText("Logout");
        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = new Dialog(getContext());
                dialog.setContentView(R.layout.loginpopup);

                txtUsername = dialog.findViewById(R.id.txtusername);
                txtPassword = dialog.findViewById(R.id.txtpassword);

                processLoginBtn = dialog.findViewById(R.id.btnProcessLogin);

                processLoginBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String username = txtUsername.getText().toString();
                        String password = txtPassword.getText().toString();

                        Methods methods = getRetrofit().create(Methods.class);
                        Call<CustomerResponse> call = methods.loginCustomer(new Customer(username, password));
                        call.enqueue(new Callback<CustomerResponse>() {
                            @Override
                            public void onResponse(Call<CustomerResponse> call, Response<CustomerResponse> response) {
                                String data = response.body().getAccessToken();
                                Log.v("ACCESSTOKEN", data);
                                if(response.body().getSuccess()) {

                                    SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getContext());

                                    SharedPreferences.Editor editor = settings.edit();
                                    editor.putString("jwt", data);
                                    editor.commit();

                                    WindowManager manager = (WindowManager) getActivity().getSystemService(Context.WINDOW_SERVICE);

                                    // initializing a variable for default display.
                                    Display display = manager.getDefaultDisplay();

                                    // creating a variable for point which
                                    // is to be displayed in QR Code.
                                    Point point = new Point();
                                    display.getSize(point);

                                    // getting width and
                                    // height of a point
                                    int width = point.x;
                                    int height = point.y;

                                    // generating dimension from width and height.
                                    int dimen = width < height ? width : height;
                                    dimen = dimen * 3 / 4;
                                    qrgEncoder = new QRGEncoder(data, null, QRGContents.Type.TEXT, dimen);
                                    try {
                                        bitmap = qrgEncoder.encodeAsBitmap();

                                        qrImage.setImageBitmap(bitmap);
                                    } catch (WriterException e) {

                                        Log.e("Tag", e.toString());
                                    }
                                    btnLogin.setText("Logout");
                                    dialog.dismiss();
                                }
                            }
                            @Override
                            public void onFailure(Call<CustomerResponse> call, Throwable t) {
                                Log.v("log:", t.getMessage());
                            }
                        });
                    }
                });

                dialog.show();
            }
        });

        return rootView;
    }



}