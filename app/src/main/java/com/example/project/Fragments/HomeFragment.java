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
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.lib.Model.DrinkList;
import com.example.lib.Model.DrinkModel;
import com.example.lib.Model.ProductsModel;
import com.example.lib.interfaceRepository.Methods;
import com.example.project.Adapter.ProductsAdapter;
import com.example.project.R;



import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    List<ProductsModel> CartList = new ArrayList<>();
    android.widget.ListView lvProducts;
    ProductsAdapter productsAdapter;

    ArrayList<ProductsModel> studentModelsList =  new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        lvProducts = (ListView)rootView.findViewById(R.id.lvProducts);
        productsAdapter = new ProductsAdapter(getActivity(), R.layout.productcard);

        getProduct();

        lvProducts.setAdapter(productsAdapter);

        lvProducts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                DrinkModel item =(DrinkModel) adapterView.getAdapter().getItem(i);

                Bundle bundle = new Bundle();
                bundle.putString("id", item.getId());
                bundle.putString("name", item.getDrinkName());
                bundle.putDouble("price", item.getDefaultPrice().get(0));
                bundle.putString("image", item.getDrinkImage());

                ProductDetailFragment nextFrag= new ProductDetailFragment();
                nextFrag.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, nextFrag, "findThisFragment").commit();

//                getActivity().getSupportFragmentManager().beginTransaction()
//                        .replace(R.id.frame_layout, nextFrag, "findThisFragment")
//                        .addToBackStack(null)
//                        .commit();
            }
        });

        return rootView;
    }


    private void getProduct() {
        Methods methods = getRetrofit().create(Methods.class);
        Call<DrinkList> call = methods.getProducts();
        call.enqueue(new Callback<DrinkList>() {
            @Override
            public void onResponse(Call<DrinkList> call, Response<DrinkList> response) {
                DrinkList data = response.body();

                for (DrinkModel dt : data.getDrinks()) {
                    //Integer productID, String productname, String description, Integer price, Integer category, String image
                    productsAdapter.add(new DrinkModel(dt.getId(), dt.getDrinkName(), dt.getDrinkImage(),dt.getDefaultPrice(),dt.getCategory(),dt.getDescription()));
                }
            }

            @Override
            public void onFailure(Call<DrinkList> call, Throwable t) {
                Log.v("log:", t.getMessage());
            }
        });
    }

}