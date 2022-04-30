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

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.lib.Model.CartListModel;
import com.example.lib.Model.ProductsModel;
import com.example.project.R;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;

public class CartAdapter extends ArrayAdapter<CartListModel> {
    Activity context;
    int resource;
    public CartAdapter(@NonNull Context context, int resource) {
        super(context, resource);
        this.context = (Activity) context;
        this.resource = resource;
    }

    ImageView imgProduct;
    TextView txtName ;
    TextView txtPrice;
    ElegantNumberButton amountButton;

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = this.context.getLayoutInflater();
        View productView = layoutInflater.inflate(this.resource,null);

        imgProduct = productView.findViewById(R.id.cartImage);
        txtName = productView.findViewById(R.id.cartName);
        txtPrice = productView.findViewById(R.id.cartPrice);
        amountButton = productView.findViewById(R.id.cartAmount);
        amountButton.setRange(0, 1000);

        CartListModel spModel = getItem(position);

        String imageUrl = spModel.getProduct().getDrinkImage();

        String URL = "http://10.0.2.2:5000" + imageUrl;

        DecimalFormat format = new DecimalFormat("0.#");
        String newPrice = format.format(spModel.getProduct().getDefaultPrice().get(0)) + " VND";

        Picasso.get().load(URL).into(imgProduct);
        txtName.setText(spModel.getProduct().getDrinkName());
        txtPrice.setText(newPrice);
        amountButton.setNumber(Integer.toString(spModel.getAmount()));

        amountButton.setOnValueChangeListener(new ElegantNumberButton.OnValueChangeListener() {
            @Override
            public void onValueChange(ElegantNumberButton view, int oldValue, int newValue) {
                spModel.setAmount(newValue);
                if(mOnDataChangeListener != null){
                    mOnDataChangeListener.onDataChanged(spModel);
                }
            }
        });

        return productView;
    }

    public interface OnDataChangeListener{
        public void onDataChanged(CartListModel spModel);
    }
    OnDataChangeListener mOnDataChangeListener;
    public void setOnDataChangeListener(OnDataChangeListener onDataChangeListener){
        mOnDataChangeListener = onDataChangeListener;
    }
}
