package com.example.project.Fragments;

import static com.example.lib.RetrofitClient.getRetrofit;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.lib.Model.CartListModel;
import com.example.lib.Model.ProductsModel;
import com.example.lib.interfaceRepository.Methods;
import com.example.project.Adapter.CartAdapter;
import com.example.project.Adapter.ProductsAdapter;
import com.example.project.R;

import java.text.DecimalFormat;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CartFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CartFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CartFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CartFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CartFragment newInstance(String param1, String param2) {
        CartFragment fragment = new CartFragment();
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

    ArrayList<CartListModel> cartlist = new ArrayList<>();
    ListView lvCart;
    TextView cartTotalPrice, cartTotalAmount;
    CartAdapter cartAdapter;
    double totalPrice = 0;
    int totalAmount = 0;

    MeowBottomNavigation bottomNavigation;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_cart, container, false);

        bottomNavigation = (MeowBottomNavigation) rootView.findViewById(R.id.bottom_navigation);
        lvCart = (ListView) rootView.findViewById(R.id.cartListView);
        cartAdapter = new CartAdapter(getActivity(), R.layout.cardcart);

        Bundle arguments = this.getArguments();
        if (arguments != null){
            cartlist = (ArrayList<CartListModel>) arguments.getSerializable("cartlist");
            for (CartListModel item : cartlist) {
                cartAdapter.add(item);
            }
        }

        for (int i = 0; i < cartlist.size(); i ++) {
            CartListModel item = cartAdapter.getItem(i);
            Log.v("PRICE", item.getProduct().getDefaultPrice().get(0).toString());
            totalPrice += item.getProduct().getDefaultPrice().get(0)*item.getAmount();
            totalAmount += 1;
        }


        cartAdapter.setOnDataChangeListener(new CartAdapter.OnDataChangeListener(){
            @Override
            public void onDataChanged(CartListModel spModel) {
                totalPrice = 0;
                totalAmount = 0;
                for (int i = 0; i < cartlist.size(); i ++) {
                    CartListModel item = cartAdapter.getItem(i);
                    if (item.getAmount() == 0) {
                        cartlist.remove(item);
                        cartAdapter.remove(item);

                    }
                    else {
                        totalPrice += item.getProduct().getDefaultPrice().get(0)*item.getAmount();
                        totalAmount += 1;
                    }

                }
                cartTotalPrice =  rootView.findViewById(R.id.cartTotalPrice);
                cartTotalPrice.setText(formatPrice(totalPrice));

                String cartMessage;
                if(totalAmount == 0){
                    cartMessage = "Bạn chưa thêm vào giỏ hàng";
                }
                else{
                    cartMessage = "Số loại mặt hàng có trong giỏ hàng: " + Integer.toString(totalAmount);
                }

                cartTotalAmount.setText(cartMessage);
            }
        });

        cartTotalPrice =  rootView.findViewById(R.id.cartTotalPrice);
        cartTotalPrice.setText(formatPrice(totalPrice));
        cartTotalAmount =  rootView.findViewById(R.id.cartTotalAmount);

        String cartMessage;
        if(totalAmount == 0){
            cartMessage = "Bạn chưa thêm vào giỏ hàng";
        }
        else{
            cartMessage = "Số loại mặt hàng có trong giỏ hàng: " + Integer.toString(totalAmount);
        }

        cartTotalAmount.setText(cartMessage);

        lvCart.setAdapter(cartAdapter);

        return rootView;
    }

    public String formatPrice (Double price){
        DecimalFormat format = new DecimalFormat("0.#");
        return format.format(price) + " VND";
    }
}