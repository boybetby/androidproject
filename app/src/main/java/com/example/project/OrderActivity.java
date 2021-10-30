package com.example.project;

import static com.example.lib.RetrofitClient.getRetrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.lib.Model.GHNapi.District;
import com.example.lib.Model.GHNapi.Province;
import com.example.lib.Model.ProductsModel;
import com.example.lib.interfaceRepository.Methods;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderActivity extends AppCompatActivity {

    String token = "33103c88-ec46-11eb-9388-d6e0030cbbb7";
    Spinner provinceSpinner, districtSpinner ,wardSpinner;
    List<String> listProvince = new ArrayList<>();
    List<String> listDistrict = new ArrayList<>();
    List<Province.Datum> ProvinceData;
    List<District.Datum> DistrictData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        provinceSpinner = findViewById(R.id.spinnerProvince);
        districtSpinner = findViewById(R.id.spinnerDistrict);
        wardSpinner = findViewById(R.id.spinnerWard);

        getProvince();

        provinceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int provinceID = 0;
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

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

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
        Methods methods = getRetrofit().create(Methods.class);
        Call<District> call = methods.getDistrict(token);
        call.enqueue(new Callback<District>() {
            @Override
            public void onResponse(Call<District> call, Response<District> response) {

                DistrictData = response.body().getData();

                for (District.Datum dt : DistrictData) {
                    if(dt.getProvinceID() == province) listDistrict.add(dt.getDistrictName());
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

}