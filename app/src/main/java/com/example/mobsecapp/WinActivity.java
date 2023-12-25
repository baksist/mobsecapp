package com.example.mobsecapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class WinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);

        String username = getIntent().getStringExtra("username");
        WinFragment winFragment = WinFragment.newInstance(username);
        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout, winFragment).commit();
    }
}