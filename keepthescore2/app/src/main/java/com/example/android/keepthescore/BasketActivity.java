package com.example.android.keepthescore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class BasketActivity extends AppCompatActivity {

    private int count_a_team_score = 0, count_b_team_score = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);

    }

    public void returnToMainActivity(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void add3PointsTeamA(View view){
        count_a_team_score+= 3;
        displayForTeamA(count_a_team_score);


    }

    public void add2PointsTeamA(View view){
        count_a_team_score += 2;
        displayForTeamA(count_a_team_score);
    }

    public void add1PointTeamA(View view){
        count_a_team_score += 1;
        displayForTeamA(count_a_team_score);
    }

    public void add3PointsTeamB(View view){
        count_b_team_score += 3;
        displayForTeamB(count_b_team_score);
    }

    public void add2PointsTeamB(View view){
        count_b_team_score += 2;
        displayForTeamB(count_b_team_score);
    }

    public void add1PointTeamB(View view){
        count_b_team_score += 1;
        displayForTeamB(count_b_team_score);
    }


    public void resetPointTeams(View view){
        count_b_team_score = 0;
        count_a_team_score = 0;
        displayForTeamB(count_b_team_score);
        displayForTeamA(count_a_team_score);
    }
    private void displayForTeamA(int score){
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }
    private void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

}
