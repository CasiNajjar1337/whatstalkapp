package com.example.berat.whatstalk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class PrivacyPolicyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_policy);


        TextView textView = (TextView) findViewById(R.id.privacy_policy_text);
        textView.setMovementMethod(new ScrollingMovementMethod());
    }
}
