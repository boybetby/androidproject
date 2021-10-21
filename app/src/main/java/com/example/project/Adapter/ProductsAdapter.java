package com.example.project.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.lib.Model.ProductsModel;
import com.example.project.R;

public class ProductsAdapter extends ArrayAdapter<ProductsModel> {
    Activity context;
    int resource;
    public ProductsAdapter(@NonNull Context context, int resource) {
        super(context, resource);
        this.context = (Activity) context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = this.context.getLayoutInflater();
        View productView = layoutInflater.inflate(this.resource,null);

        ImageView imgProduct = productView.findViewById(R.id.producImage);
        TextView txtName = productView.findViewById(R.id.productName);
        TextView txtPrice = productView.findViewById(R.id.productPrice);


        ProductsModel stModel = getItem(position);

//        imgProduct.setImageResource(stModel.getImage());
        txtName.setText(stModel.getProductname());
        txtPrice.setText(stModel.getPrice().toString());


        return productView;

    }
}
