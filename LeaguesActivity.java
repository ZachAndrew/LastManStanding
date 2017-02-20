package com.example.lastmanstandinglayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LeaguesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leagues);
    }

    public void homePage(View view) {
        Intent intent = new Intent(this, HomePageActivity.class);
        startActivity(intent);
    }

    public void createLeaguePage(View view) {
        Intent intent = new Intent(this, CreateLeagueActivity.class);
        startActivity(intent);
    }

    public void joinLeaguePage(View view) {
        Intent intent = new Intent(this, JoinLeagueActivity.class);
        startActivity(intent);
    }

    public void viewLeague(View view) {
        Intent intent = new Intent(this, ViewLeagueActivity.class);
        startActivity(intent);
    }
}
