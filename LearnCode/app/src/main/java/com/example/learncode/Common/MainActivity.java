package com.example.learncode.Common;

import android.annotation.SuppressLint;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.learncode.Fragment.ContactFragment;
import com.example.learncode.Fragment.HomeFragment;
import com.example.learncode.Fragment.NewsFragment;
import com.example.learncode.Fragment.ProfileFragment;
import com.example.learncode.Model.SharedPrefManager;

import com.example.learncode.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView Bnav;
    FrameLayout Fcon;
    SharedPrefManager sharedPrefManager;

    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        Bnav = findViewById(R.id.Bnav);
        Fcon = findViewById(R.id.Fcon);
        sharedPrefManager = new SharedPrefManager(getApplicationContext());

        Bnav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int id = menuItem.getItemId();
                switch (id) {
                    case R.id.nav_home:
                        loadfrg(new HomeFragment());
                        break;
                    case R.id.nav_news:
                        loadfrg(new NewsFragment());
                        break;
                    case R.id.nav_profile:
                        loadfrg(new ProfileFragment());
                        break;
                    case R.id.nav_contact:
                        loadfrg(new ContactFragment());
                        break;
                }
                return true;
            }
        });
        Bnav.setSelectedItemId(R.id.nav_home);
    }

    public void loadfrg(Fragment fragment) {

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.Fcon, fragment);
        ft.replace(R.id.Fcon, fragment);
        ft.commit();
    }
}