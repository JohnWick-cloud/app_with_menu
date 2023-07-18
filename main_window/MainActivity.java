package com.example.main_window;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity {

    static {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DrawerLayout myDrawerLayout = findViewById(R.id.drawer_layout);
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        ActionBarDrawerToggle myToggle = new ActionBarDrawerToggle(this, myDrawerLayout, myToolbar,  R.string.drawer_open, R.string.drawer_close);
        myDrawerLayout.addDrawerListener(myToggle);
        myToggle.syncState();
        NavigationView myNavView = findViewById(R.id.navigation_view);
        myNavView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                int itemId = item.getItemId();
                if (itemId == R.id.products){
                    Intent intent = new Intent(MainActivity.this, spravochniki.class);
                    startActivity(intent);
                }

                myDrawerLayout.close();
                return false;
            }
        });








    }



}