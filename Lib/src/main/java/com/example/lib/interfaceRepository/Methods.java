package com.example.lib.interfaceRepository;

import com.example.lib.Model.GHNapi.District;
import com.example.lib.Model.GHNapi.Province;
import com.example.lib.Model.GHNapi.Ward;
import com.example.lib.Model.OrderModel;
import com.example.lib.Model.ProductsModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Methods {

    //product
    @GET("api/fetch")
    Call<List<ProductsModel>> getProducts();
    @GET("api/fetch/{id}")
    Call<ProductsModel> getDetail(@Path("id") String id);
    @POST("api/OrdersAPI")
    Call<OrderModel> insertContent(@Body OrderModel orderModel);

    //ghnApi
    @GET("https://dev-online-gateway.ghn.vn/shiip/public-api/master-data/province")
    Call<Province> getProvince(@Header("token") String token);

    @GET("https://dev-online-gateway.ghn.vn/shiip/public-api/master-data/district")
    Call<District> getDistrict(@Header("token") String token);

    @GET("https://dev-online-gateway.ghn.vn/shiip/public-api/master-data/ward")
    public Call<Ward> getWard(@Header("token") String token, @Query("district_id") int districtID);
}
