package com.example.project.Adapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.lib.Model.DrinkModel;
import com.example.lib.Model.ProductsModel;
import com.example.lib.RetrofitClient;
import com.example.project.R;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.List;

public class ProductsAdapter extends ArrayAdapter<DrinkModel> {
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

        ImageView imgProduct = productView.findViewById(R.id.productImage);
        TextView txtName = productView.findViewById(R.id.productName);
        TextView txtPrice = productView.findViewById(R.id.productPrice);

        DrinkModel spModel = getItem(position);

        String imageUrl = spModel.getDrinkImage();
        String URL = "http://10.0.2.2:5000" + imageUrl;

        DecimalFormat format = new DecimalFormat("0.#");
        String newPrice = format.format(spModel.getDefaultPrice().get(0)) + " VND";

        Picasso.get().load(URL).into(imgProduct);
        txtName.setText(spModel.getDrinkName());
        txtPrice.setText(newPrice);

        return productView;

    }

}
