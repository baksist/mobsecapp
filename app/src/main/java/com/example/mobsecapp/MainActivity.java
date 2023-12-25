package com.example.mobsecapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button okButton = findViewById(R.id.buttonOk);
        EditText usernameText = findViewById(R.id.editName);
        // TODO: process password
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameText.getText().toString();
                if(username.isEmpty()){
                    Toast.makeText(MainActivity.this, "name is empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(MainActivity.this, GameActivity.class);
                intent.putExtra("username", username);
                saveToPrefs(username);
                startActivity(intent);
            }
        };

        okButton.setOnClickListener(onClickListener);
    }

    void saveToPrefs(String username){
        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        prefs.edit().putString("username", username).commit();
    }
}