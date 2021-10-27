package com.example.project.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.lib.Model.ProductsModel;
import com.example.project.R;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProductDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProductDetailFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProductDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProductDetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProductDetailFragment newInstance(String param1, String param2) {
        ProductDetailFragment fragment = new ProductDetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    ElegantNumberButton amountButton;

    public int amount;

    String productName;
    double productPrice;
    String productImageURL;

    ImageView imgProduct;
    TextView txtName;
    TextView txtPrice;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_product_detail, container, false);

        Bundle bundle = this.getArguments();

        String URL = bundle.getString("image");
        String newImageURL = URL.substring(5);

        productImageURL = "http://10.0.2.2:8088" + newImageURL;
        productName = bundle.getString("name");
        productPrice = bundle.getDouble("price");


        imgProduct = rootView.findViewById(R.id.detailImage);
        txtName = rootView.findViewById(R.id.detailName);
        txtPrice = rootView.findViewById(R.id.detailPrice);

        Picasso.get().load(productImageURL).into(imgProduct);
        txtName.setText(productName);
        txtPrice.setText(formatPrice(productPrice));

        amountButton = (ElegantNumberButton) rootView.findViewById(R.id.amountButton);
        amountButton.setRange(1,100);

        amountButton.setOnValueChangeListener(new ElegantNumberButton.OnValueChangeListener() {
            @Override
            public void onValueChange(ElegantNumberButton view, int oldValue, int newValue) {
                amount = newValue;
                txtPrice.setText(formatPrice(productPrice*amount));
            }
        });

        return rootView;
    }

    public String formatPrice (Double price){
        DecimalFormat format = new DecimalFormat("0.#");
        return format.format(price) + " VND";
    }
}