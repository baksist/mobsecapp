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
        EditText passwordText = findViewById(R.id.editPassword);
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameText.getText().toString();
                String password = passwordText.getText().toString();
                if(username.isEmpty() || password.isEmpty()){
                    Toast.makeText(MainActivity.this, "text field is empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(MainActivity.this, GameActivity.class);
                intent.putExtra("username", username);
                saveToPrefs(username, password);
                startActivity(intent);
            }
        };

        okButton.setOnClickListener(onClickListener);
    }

    void saveToPrefs(String username, String password){
        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        prefs.edit().putString("username", username).putString("password", password).commit();
    }
}