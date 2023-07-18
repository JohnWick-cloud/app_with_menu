package com.example.main_window;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class spravochniki extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spravochniki);
        DrawerLayout myDrawerLayout = findViewById(R.id.spravochniki_drawer_layout);
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        ActionBarDrawerToggle myToggle = new ActionBarDrawerToggle(this, myDrawerLayout, myToolbar,  R.string.drawer_open, R.string.drawer_close);
        myDrawerLayout.addDrawerListener(myToggle);
        myToggle.syncState();
        NavigationView myNavView = findViewById(R.id.spravochniki_navigation_view);
        myNavView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if(itemId == R.id.go_to_main){
                    Intent intent = new Intent(spravochniki.this, MainActivity.class);
                    startActivity(intent);
                }
                myDrawerLayout.close();
                return false;
            }
        });

        TextView nomenklaturaTextView = findViewById(R.id.nomenklatura);
        TextView tovariTextView = findViewById(R.id.tovari);
        nomenklaturaTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(spravochniki.this, nomenklatura.class);
                startActivity(intent);
            }
        });
        tovariTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(spravochniki.this, tovari.class);
                startActivity(intent);
            }
        });
    }
}