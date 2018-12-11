package com.sera5.loginsederhana;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends Activity {

    EditText username,password;
    Button button;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        button=(Button)findViewById(R.id.button);

        sp=getSharedPreferences("login",MODE_PRIVATE);

        //if SharedPreferences contains username and password then redirect to Home activity
        if(sp.contains("username") && sp.contains("password")){
            startActivity(new Intent(MainActivity.this,HomeActivity.class));
            finish();   //finish current activity
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginCheck();
            }
        });
    }

    void loginCheck(){
        //check username and password are correct and then add them to SharedPreferences
        if(username.getText().toString().equals("amal") && password.getText().toString().equals("amalPsw")){
            SharedPreferences.Editor e=sp.edit();
            e.putString("username","amal");
            e.putString("password","amalPsw");
            e.commit();

            Toast.makeText(MainActivity.this,"Login Successful",Toast.LENGTH_LONG).show();

            startActivity(new Intent(MainActivity.this,HomeActivity.class));
            finish();
        }
        else{
            Toast.makeText(MainActivity.this,"Incorrect Login Details",Toast.LENGTH_LONG).show();
        }
    }
}