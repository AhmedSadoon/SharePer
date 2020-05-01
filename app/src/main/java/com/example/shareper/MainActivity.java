package com.example.shareper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText userName,Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName=findViewById(R.id.et_username);
        Password=findViewById(R.id.et_password);
    }

    public void Next(View view) {

        Toast.makeText(this,"Database",Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this,DBActivity.class);
        startActivity(intent);

    }

    public void Save(View view) {
        SharedPreferences sharedPreferences=getSharedPreferences("Data",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("name",userName.getText().toString());
        editor.putString("password",Password.getText().toString());
        editor.commit();

        Toast.makeText(this,"Saved successfully",Toast.LENGTH_SHORT).show();


    }
}
