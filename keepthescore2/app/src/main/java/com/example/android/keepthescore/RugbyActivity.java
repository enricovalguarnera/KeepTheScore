package com.example.android.keepthescore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class RugbyActivity extends AppCompatActivity {

    private int score_teamA = 0, score_teamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rugby);
    }

    public void returnToMainActivity(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void add5PointsTeamA(View view){
        score_teamA += 5;
        displayForTeamA(score_teamA);
    }

    public void add3PointsTeamA(View view){
        score_teamA += 3;
        displayForTeamA(score_teamA);
    }

    public void add2PointTeamA(View view){
        score_teamA += 2;
        displayForTeamA(score_teamA);
    }

    public void add5PointsTeamB(View view){
        score_teamB += 5;
        displayForTeamB(score_teamB);
    }

    public void add3PointsTeamB(View view){
        score_teamB += 3;
        displayForTeamB(score_teamB);
    }

    public void add2PointTeamB(View view){
        score_teamB += 2;
        displayForTeamB(score_teamB);
    }


    public void resetPointTeams(View view){
        score_teamA = 0;
        score_teamB = 0;
        displayForTeamA(score_teamA);
        displayForTeamB(score_teamB);
    }
    private void displayForTeamA(int score){
        TextView scoreView = (TextView) findViewById(R.id.team_a_score_rugby);
        scoreView.setText(String.valueOf(score));
    }
    private void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score_rugby);
        scoreView.setText(String.valueOf(score));
    }

}
