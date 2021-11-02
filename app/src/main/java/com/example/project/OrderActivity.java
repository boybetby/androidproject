package com.example.project;

import static com.example.lib.RetrofitClient.getRetrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.lib.Model.CartListModel;
import com.example.lib.Model.GHNapi.District;
import com.example.lib.Model.GHNapi.Province;
import com.example.lib.Model.GHNapi.Ward;
import com.example.lib.Model.Order.Address;
import com.example.lib.Model.Order.ShippingFee;
import com.example.lib.interfaceRepository.Methods;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Query;

public class OrderActivity extends AppCompatActivity {

    String token = "33103c88-ec46-11eb-9388-d6e0030cbbb7";
    String access_key="1d4e94a3da4ea7dfc7916c51c93d0860";

    String myAddress = "357 Lê Văn Lương, Tân Quy, Quận 7, Hồ Chí Minh";

    EditText txtAddress, txtName, txtPhone, txtEmail;
    Spinner provinceSpinner, districtSpinner ,wardSpinner;
    Button btnConfirm;

    List<String> listProvince = new ArrayList<>();
    List<String> listDistrict = new ArrayList<>();
    List<String> listWard = new ArrayList<>();
    List<Province.Datum> ProvinceData;
    List<District.Datum> DistrictData;
    List<Ward.Datum> WardData;

    List<CartListModel> cartlist = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        provinceSpinner = findViewById(R.id.spinnerProvince);
        districtSpinner = findViewById(R.id.spinnerDistrict);
        wardSpinner = findViewById(R.id.spinnerWard);

        txtAddress = findViewById(R.id.txtAddress);
        txtName = findViewById(R.id.orderName);
        txtEmail = findViewById(R.id.orderEmail);
        txtPhone = findViewById(R.id.orderPhone);

        Intent intent = getIntent();
        cartlist = (List<CartListModel>) intent.getSerializableExtra("cartlist");

        getProvince();

        provinceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String province = provinceSpinner.getSelectedItem().toString();

                for(Province.Datum item : ProvinceData){
                    if(item.getProvinceName() == province){
                        provinceID = item.getProvinceID();
                    }
                }

                if(provinceID != 0) getDistrict(provinceID);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        districtSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String district = districtSpinner.getSelectedItem().toString();

                for(District.Datum item : DistrictData){
                    if(item.getDistrictName() == district){
                        districtID = item.getDistrictID();
                    }
                }

                getShippingFee();

                if(districtID != 0)
                    getWard(districtID);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    int provinceID;
    int districtID;

    private void getProvince() {
        Methods methods = getRetrofit().create(Methods.class);
        Call<Province> call = methods.getProvince(token);
        call.enqueue(new Callback<Province>() {
            @Override
            public void onResponse(Call<Province> call, Response<Province> response) {

                ProvinceData = response.body().getData();

                for (Province.Datum dt : ProvinceData) {
                    listProvince.add(dt.getProvinceName());

                }

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                        android.R.layout.simple_list_item_1, listProvince);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                provinceSpinner.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<Province> call, Throwable t) {
                Log.v("log:", t.getMessage());
            }
        });
    }

    private void getDistrict(int province) {
        listDistrict.clear();
        Methods methods = getRetrofit().create(Methods.class);
        Call<District> call = methods.getDistrict(token);
        call.enqueue(new Callback<District>() {
            @Override
            public void onResponse(Call<District> call, Response<District> response) {

                DistrictData = response.body().getData();

                for (District.Datum dt : DistrictData) {
                    if(dt.getProvinceID() == province) {
                        listDistrict.add(dt.getDistrictName());
                    }
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                        android.R.layout.simple_list_item_1, listDistrict);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                districtSpinner.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<District> call, Throwable t) {
                Log.v("log:", t.getMessage());
            }
        });
    }

    private void getWard(int districtID) {
        listWard.clear();
        Methods methods = getRetrofit().create(Methods.class);
        Call<Ward> call = methods.getWard(token, districtID);
        call.enqueue(new Callback<Ward>() {
            @Override
            public void onResponse(Call<Ward> call, Response<Ward> response) {
                WardData = response.body().getData();
                for (Ward.Datum dt : WardData) {
                        listWard.add(dt.getWardName());
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                        android.R.layout.simple_list_item_1, listWard);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                wardSpinner.setAdapter(adapter);
            }
            @Override
            public void onFailure(Call<Ward> call, Throwable t) {
                Log.v("log:", t.getMessage());
            }
        });
    }

    String Address;

    public void Confirm(View view) {

        provinceSpinner = findViewById(R.id.spinnerProvince);
        districtSpinner = findViewById(R.id.spinnerDistrict);
        wardSpinner = findViewById(R.id.spinnerWard);
        txtAddress = findViewById(R.id.txtAddress);
        txtName = findViewById(R.id.orderName);
        txtEmail = findViewById(R.id.orderEmail);
        txtPhone = findViewById(R.id.orderPhone);

        if(TextUtils.isEmpty(txtName.getText())){
            txtName.setError("Xin hãy điền họ tên");
        }
        if(TextUtils.isEmpty(txtEmail.getText())){
            txtEmail.setError("Xin hãy điền Email");
        }
        if(TextUtils.isEmpty(txtPhone.getText())){
            txtPhone.setError("Xin hãy điền số điện thoại");
        }
        if(TextUtils.isEmpty(txtAddress.getText())){
            txtAddress.setError("Xin hãy điền địa chỉ");
        }
        else{
            String province, district, ward, address, name, email, phone;

            province = provinceSpinner.getSelectedItem().toString();
            district = districtSpinner.getSelectedItem().toString();
            ward = wardSpinner.getSelectedItem().toString();
            address = txtAddress.getText().toString();
            name = txtName.getText().toString();
            email = txtEmail.getText().toString();
            phone = txtPhone.getText().toString();

            Address = address + ", " + ward + ", " + district + ", " + province;

            Intent newActivity = new Intent(OrderActivity.this, ConfirmOrderActivity.class );
            newActivity.putExtra("name", name);
            newActivity.putExtra("email", email);
            newActivity.putExtra("phone", phone);
            newActivity.putExtra("address", Address);
            newActivity.putExtra("shippingFee", shippingFee);
            newActivity.putExtra("cartlist", (Serializable) cartlist);

            startActivity(newActivity);
        }
    }

    ShippingFee.Data GHNfee;
    int shippingFee;

    public void getShippingFee(){
        Methods methods = getRetrofit().create(Methods.class);
        Call<ShippingFee> call = methods.getShippingFee(token, 53321, 202, 1449, provinceID, districtID, 30, 20, 2000, 10);
        call.enqueue(new Callback<ShippingFee>() {
            @Override
            public void onResponse(Call<ShippingFee> call, Response<ShippingFee> response) {
                GHNfee = response.body().getData();
                shippingFee = GHNfee.getTotal();
            }
            @Override
            public void onFailure(Call<ShippingFee> call, Throwable t) {
                Log.v("log: ", t.getMessage());
            }
        });
    }

}