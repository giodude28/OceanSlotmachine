package com.billy.oceanslotmachinesearoute;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.widget.Toast;

import com.billy.oceanslotmachinesearoute.Fragment.AFFragment;
import com.billy.oceanslotmachinesearoute.Fragment.Home;
import com.billy.oceanslotmachinesearoute.Fragment.PrizefishFragment;
import com.billy.oceanslotmachinesearoute.Fragment.TFFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    public static BottomNavigationView navigationView;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigationView = findViewById(R.id.bottom_navigation);
        //navigationView.setSelectedItemId(R.id.one);
        getSupportFragmentManager().beginTransaction().replace(R.id.fLayout, new Home()).commit();

        declare();
    }

    private void declare()
    {
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                switch (item.getItemId()) {

                    case R.id.home:
                        selectedFragment = new Home();
                        break;
                    case R.id.prize:
                        selectedFragment = new PrizefishFragment();
                        break;
                    case R.id.term:
                        selectedFragment = new TFFragment();
                        break;

                    case R.id.tip:
                        selectedFragment = new AFFragment();
                        break;

//                    case R.id.rule:
//                        selectedFragment = new Rules();
//                        break;
//
//                    case R.id.five:
//                        selectedFragment = new Result();
//                        break;

                }
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fLayout,selectedFragment)
                        .commit();

                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {

        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Nhấn Thêm Lần Nữa Để Thoátn!", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);

    }

}