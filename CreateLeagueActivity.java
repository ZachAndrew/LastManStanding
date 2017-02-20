package com.example.lastmanstandinglayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CreateLeagueActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_league);
    }

    public void leagues(View view) {
        Intent intent = new Intent(this, LeaguesActivity.class);
        startActivity(intent);
    }

    public void leagueCreated(View view) {
        Intent intent = new Intent(this, LeagueCreatedActivity.class);
        startActivity(intent);
    }
}
