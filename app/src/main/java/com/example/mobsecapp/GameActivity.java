package com.example.mobsecapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {
    public static final int WIN_LIMIT = 15;
    public static final int FAKE_LIMIT = 10;
    TextView tvHello;
    TextView tvScore;
    int score = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        Log.d("GameActivity", "username: " + username);

        tvHello = findViewById(R.id.tvHello);
        tvHello.setText("Hello, " + username + "!");

        tvScore = findViewById(R.id.tvScore);
        tvScore.setText("0");
    }


    public void onBtnClick(View view) {
        score++;
        if (score <= FAKE_LIMIT){
            tvScore.setText("Your score: " + score);
        }
        else if (score > WIN_LIMIT){
            // TODO: WinActivity
            Toast.makeText(this, "game over", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, WinActivity.class);
            String username = getIntent().getStringExtra("username");
            intent.putExtra("username", username);
            intent.putExtra("score", score);
            startActivity(intent);
        }
    }
}