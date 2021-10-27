package com.example.project;

import static com.example.lib.RetrofitClient.getRetrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lib.Model.ProductsModel;
import com.example.lib.interfaceRepository.Methods;
import com.example.project.Adapter.ProductsAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsPage extends AppCompatActivity {

    android.widget.ListView lvProducts;
    ProductsAdapter productsAdapter;
    TextView txtName, txtPrice;
    ImageView imgProduct;

    ArrayList<ProductsModel> studentModelsList =  new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_products_page);

        lvProducts = findViewById(R.id.lvProducts);
        productsAdapter = new ProductsAdapter(ProductsPage.this, R.layout.productcard);

        getProduct();

        lvProducts.setAdapter(productsAdapter);
    }

    private void getProduct() {
        Methods methods = getRetrofit().create(Methods.class);
        Call<List<ProductsModel>> call = methods.getProducts();
        call.enqueue(new Callback<List<ProductsModel>>() {
            @Override
            public void onResponse(Call<List<ProductsModel>> call, Response<List<ProductsModel>> response) {

                List<ProductsModel> data = response.body();

                for (ProductsModel dt : data) {
                    //Integer productID, String productname, String description, Integer price, Integer category, String image
                    productsAdapter.add(new ProductsModel(dt.getProductID(), dt.getProductname(), dt.getDescription(),dt.getPrice(),dt.getCategory(),dt.getImage()));
                }
            }

            @Override
            public void onFailure(Call<List<ProductsModel>> call, Throwable t) {
                Log.v("log:", t.getMessage());
            }
        });
    }
}