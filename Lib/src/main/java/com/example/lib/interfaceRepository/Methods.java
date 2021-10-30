package com.example.lib.interfaceRepository;

import com.example.lib.Model.OrderModel;
import com.example.lib.Model.ProductsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Methods {
    @GET("api/fetch")
    Call<List<ProductsModel>> getProducts();
    @GET("api/fetch/{id}")
    Call<ProductsModel> getDetail(@Path("id") String id);
    @POST("api/OrdersAPI")
    Call<OrderModel> insertContent(@Body OrderModel orderModel);
}
