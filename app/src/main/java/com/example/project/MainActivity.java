package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.WindowManager;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.lib.Model.ProductsModel;
import com.example.project.Fragments.AboutFragment;
import com.example.project.Fragments.CartFragment;
import com.example.project.Fragments.HomeFragment;
import com.example.project.Fragments.ProductDetailFragment;


public class MainActivity extends AppCompatActivity{

    MeowBottomNavigation bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        bottomNavigation = findViewById(R.id.bottom_navigation);

        bottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.ic_home));
        bottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.ic_cart));
        bottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.ic_about));

        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                Fragment fragment = null;

                switch (item.getId()){
                    case 1:
                        fragment = new HomeFragment();
                        break;
                    case 2:
                        fragment = new CartFragment();
                        break;
                    case 3:
                        fragment = new AboutFragment();
                        break;
                }

                loadFragment(fragment);
            }
        });

        bottomNavigation.setCount(2,"0");
        bottomNavigation.show(1,true);

        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {

            }
        });


        //an lai lan nua
        bottomNavigation.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {
                Fragment fragment = null;

                switch (item.getId()){
                    case 1:
                        fragment = new HomeFragment();
                        break;
                    case 2:
                        fragment = new CartFragment();
                        break;
                    case 3:
                        fragment = new AboutFragment();
                        break;
                }

                loadFragment(fragment);
            }
        });

    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout, fragment)
                .commit();
    }

    public void setCartCount(int count){
        bottomNavigation.setCount(2,String.valueOf(count));
    }

}
