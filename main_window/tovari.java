package com.example.main_window;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class tovari extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tovari);
        DrawerLayout myDrawerLayout = findViewById(R.id.tovari_drawer_layout);
        Toolbar myToolbar = findViewById(R.id.tovari_toolbar);
        setSupportActionBar(myToolbar);
        ActionBarDrawerToggle myToggle = new ActionBarDrawerToggle(this, myDrawerLayout, myToolbar,  R.string.drawer_open, R.string.drawer_close);
        myDrawerLayout.addDrawerListener(myToggle);
        myToggle.syncState();
        NavigationView myNavView = findViewById(R.id.tovari_navigation_view);
        AppBarLayout AppBar = findViewById(R.id.app_bar_tovari);
        myNavView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if(itemId == R.id.go_to_main){
                    Intent intent = new Intent(tovari.this, MainActivity.class);
                    startActivity(intent);
                }
                else if(itemId == R.id.spravochnikiItem){
                    Intent intent = new Intent(tovari.this, spravochniki.class);
                    startActivity(intent);
                }
                myDrawerLayout.close();
                return false;
            }
        });
        try{
            InputStream inputStream = getAssets().open("products.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            String json;

            json = new String(buffer, StandardCharsets.UTF_8);
            JSONArray jsonArray = new JSONArray(json);
            int max = jsonArray.length();

            for(int i = 0; i < max; i++){
                JSONObject product_item = jsonArray.getJSONObject(i);
                String name = product_item.getString("name");
                int id = product_item.getInt("id");

                TextView product = new TextView(this);
                product.setText("Имя продукта: " + name + "\n"+"ID продукта: " + id);
                product.setId(i);
                product.setTextSize(18);
                product.setPadding(35, 35, 35, 35);
                AppBar.addView(product);

            }

        }catch (IOException e){
            e.printStackTrace();
        }catch (JSONException js){
            js.printStackTrace();
        }

    }
    
}
