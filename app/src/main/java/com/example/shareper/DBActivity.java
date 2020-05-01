package com.example.shareper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DBActivity extends AppCompatActivity {

    EditText userName, Password;
    String Default = "NA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);
        userName = findViewById(R.id.et_username);
        Password = findViewById(R.id.et_password);


    }

    public void show(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("Data", Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("name", Default);
        String password = sharedPreferences.getString("password", Default);

        if (name.equals(Default) || password.equals(Default)) {
            Toast.makeText(this, "No Data found!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Data found", Toast.LENGTH_SHORT).show();
            userName.setText(name);
            Password.setText(password);
        }

    }

    public void Back(View view) {
        Toast.makeText(this, "Main Window", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
