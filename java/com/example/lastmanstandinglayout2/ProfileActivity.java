package com.example.lastmanstandinglayout2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }

    public void billingInformation(View view) {
        Intent intent = new Intent(this, BillingInformationActivity.class);
        startActivity(intent);
    }
}
