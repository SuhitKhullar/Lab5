package com.example.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.view.Menu;

public class MainActivity extends AppCompatActivity {
    public static String usernameKey;

    //String usernameKey = "username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        usernameKey = "username";

        SharedPreferences sharedPreferences = getSharedPreferences("com.example.lab5", Context.MODE_PRIVATE);

        if (!sharedPreferences.getString(usernameKey,"").equals("")){
            String str = sharedPreferences.getString(usernameKey,"");
            goToActivity2(str);
        }else{
            setContentView(R.layout.activity_main);
        }


        setContentView(R.layout.activity_main);

        Intent intent = getIntent();



    }

    public void clickFunction(View view) {
        EditText myTextField = (EditText) findViewById(R.id.nameText);
        EditText myPasswordField = (EditText) findViewById(R.id.passwordText);

        SharedPreferences sharedPreferences = getSharedPreferences("com.example.lab5", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("username", myTextField.getText().toString()).apply();


        //Toast.makeText(MainActivity.this, myTextField.getText().toString(), Toast.LENGTH_LONG).show();
        String str = myTextField.getText().toString();
        goToActivity2(str);
    }

    private void goToActivity2(String s) {
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("message", s);
        startActivity(intent);
    }

   // @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.example_menu, menu);
//        return true;
//    }
}