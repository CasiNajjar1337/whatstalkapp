package com.example.berat.whatstalk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class RegisteredNumberActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered_number);


    }

    public void onClickUpdate(View v){
        startActivity(new Intent(RegisteredNumberActivity.this, AddNumberActivity.class));
    }
}
