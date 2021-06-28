package com.example.urgentcalls;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CALL = 1;
    String[] buttonNames = {"Police", "Fire Control Room", "Ambulance", "COVID-19 Helpline",
            "Centralised Accident & Trauma Services(CATS)", "Women's Helpline", "Senior Citizen Helpline",
            "Anti-Obscene Calls Cell", "Ant-stalking Cell", "AIDS Helpline(India)", "Indian Red Cross Society",
            "Disaster Management", "Traffic Helpline", "Donation of Organs(AIIMS)", "Railway Inquiry",
            "Railway Accident Emergency Service", "Road Accident Emergency Service", "Tourism Helpline", "LPG Leak Helpline"};
    int[] numbers = {100, 101, 102, 1075, 1099, 1091, 1291, 1091, 1091, 1097, 01123711551, 108, 1095, 1060, 139,
            1072, 1073, 1800111363, 1906};

    RecyclerView recyclerView;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.more_item_menu, menu);

        return true;
    }

    // Method which takes care of the items in the menu if clicked
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_about:
                Intent intent = new Intent(MainActivity.this, about_activity.class);
                startActivity(intent);
                return true;
            case R.id.item_version:
                Intent intent2 = new Intent (MainActivity.this, version_activity.class);
                startActivity(intent2);
                return true;
            case R.id.item_share:
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                String url = "https://play.google.com/store/apps/";
                sendIntent.putExtra(Intent.EXTRA_TEXT, url);
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, "Share the app via...");
                startActivity(shareIntent);
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // For setting the logo in the action bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_call);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.myRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        CustomAdapter customAdapter = new CustomAdapter(this, buttonNames, numbers);
        recyclerView.setAdapter(customAdapter);

    }
}