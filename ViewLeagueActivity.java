package com.example.lastmanstandingv1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewLeagueActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_league);

        Intent intent = getIntent();
        String league_name = intent.getStringExtra(LeaguesActivity.EXTRA_MESSAGE);

        TextView leagueName = (TextView) findViewById(R.id.LeagueName);
        leagueName.setText(league_name);
    }
}
