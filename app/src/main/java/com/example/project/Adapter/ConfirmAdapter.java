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

import com.example.lib.Model.CartListModel;
import com.example.lib.Model.ProductsModel;
import com.example.project.R;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;

public class ConfirmAdapter extends ArrayAdapter<CartListModel> {
    Activity context;
    int resource;
    public ConfirmAdapter(@NonNull Context context, int resource) {
        super(context, resource);
        this.context = (Activity) context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = this.context.getLayoutInflater();
        View productView = layoutInflater.inflate(this.resource,null);

        TextView txtName = productView.findViewById(R.id.confirmProductName);
        TextView txtAmount = productView.findViewById(R.id.confirmProductAmount);

        CartListModel spModel = getItem(position);

        txtName.setText(spModel.getProduct().getProductname());
        txtAmount.setText(Integer.toString(spModel.getAmount()));

        return productView;
    }
}
