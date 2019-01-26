package com.example.myapplication;


import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPre;
    EditText userEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {//read
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main_linear);
        //setContentView(R.layout.activity_main_grid);
        //setContentView(R.layout.activity_main_relative);
        setContentView(R.layout.activity_main_lab3);

        userEmail = (EditText)this.getDelegate().findViewById(R.id.email_Text);
        sharedPre = getSharedPreferences("FileUserName", Context.MODE_PRIVATE);
        String savedString = sharedPre.getString("UserEmail", "");
        userEmail.setText(savedString);
    }

    @Override
    protected void onPause() {// save
        super.onPause();
        //get an editor object
        //sharedPre = getSharedPreferences("FileUserName", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPre.edit();
        //save what was typed under the name "ReserveName"
        String userTypedEmail = userEmail.getText().toString();
        editor.putString("UserEmail", userTypedEmail);

        //write it to disk:
        editor.commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}
