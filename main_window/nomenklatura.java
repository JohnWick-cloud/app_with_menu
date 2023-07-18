package com.example.main_window;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class nomenklatura extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nomenklatura);
        DrawerLayout myDrawerLayout = findViewById(R.id.nomenklatura_drawer_layout);
        Toolbar myToolbar = findViewById(R.id.nomenklatura_toolbar);
        setSupportActionBar(myToolbar);
        ActionBarDrawerToggle myToggle = new ActionBarDrawerToggle(this, myDrawerLayout, myToolbar,  R.string.drawer_open, R.string.drawer_close);
        myDrawerLayout.addDrawerListener(myToggle);
        myToggle.syncState();
        NavigationView myNavView = findViewById(R.id.navigation_view);

        myNavView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if(itemId == R.id.go_to_main){
                    Intent intent = new Intent(nomenklatura.this, MainActivity.class);
                    startActivity(intent);
                }
                else if(itemId == R.id.spravochnikiItem){
                    Intent intent = new Intent(nomenklatura.this, spravochniki.class);
                    startActivity(intent);
                }
                myDrawerLayout.close();
                return false;
            }
        });
    }
}