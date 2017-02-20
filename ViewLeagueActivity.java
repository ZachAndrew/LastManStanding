package com.example.lastmanstandinglayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ViewLeagueActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_league);
    }

    public void leagues(View view) {
        Intent intent = new Intent(this, LeaguesActivity.class);
        startActivity(intent);
    }

    public void manageLeague(View view) {
        Intent intent = new Intent(this, ManageLeagueActivity.class);
        startActivity(intent);
    }

    public void pickTeam(View view) {
        Intent intent = new Intent(this, PickTeamActivity.class);
        startActivity(intent);
    }
}
