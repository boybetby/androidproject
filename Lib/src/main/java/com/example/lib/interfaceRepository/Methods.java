package com.example.lib.interfaceRepository;

import com.example.lib.Model.ProductsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Methods {
    @GET("api/fetch")
    Call<List<ProductsModel>> getProducts();
    @GET("api/fetch/{id}")
    Call<ProductsModel> getDetail(@Path("id") String id);
}
