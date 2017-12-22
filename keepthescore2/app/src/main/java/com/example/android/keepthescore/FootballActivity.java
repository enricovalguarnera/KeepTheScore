package com.example.android.keepthescore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FootballActivity extends AppCompatActivity {

    private int score_teamA = 0, score_teamB = 0, yellow_card_teamA = 0, yellow_card_teamB = 0, red_card_teamA = 0, red_card_teamB = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_football);
    }

    public void returnToMainActivity(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void addOneGoalTeamA(View view){
        score_teamA += 1;
        displayForTeamA(score_teamA);
    }

    public void addOneGoalTeamB(View view){
        score_teamB += 1;
        displayForTeamB(score_teamB);
    }

    public void addYellowCardTeamA(View view) {
        if (yellow_card_teamA != 11) {
            yellow_card_teamA += 1;
            displayYellowCardTeamA(yellow_card_teamA);
        }
    }

    public void addYellowCardTeamB(View view) {
        if (yellow_card_teamB != 11) {
            yellow_card_teamB += 1;
            displayYellowCardTeamB(yellow_card_teamB);
        }
    }

    public void addRedCardTeamA(View view){
        if(red_card_teamA < 4){
            red_card_teamA += 1;
            displayRedCardTeamA(red_card_teamA);
        }else if(red_card_teamA == 4){
            red_card_teamA += 1;
            displayRedCardTeamA(red_card_teamA);
            disableButton(view);
            displayForTeamB("Win");
        }
    }

    public void addRedCardTeamB(View view){
        if(red_card_teamB < 4){
            red_card_teamB += 1;
            displayRedCardTeamB(red_card_teamB);
        }else if(red_card_teamB == 4){
            red_card_teamB += 1;
            displayRedCardTeamB(red_card_teamB);
            disableButton(view);
            displayForTeamA("Win");
        }
    }


    public void resetPointTeamsFootball(View view){
        yellow_card_teamA = 0;
        yellow_card_teamB = 0;
        red_card_teamA = 0;
        red_card_teamB = 0;
        score_teamA = 0;
        score_teamB = 0;
        displayForTeamA(score_teamA);
        displayForTeamB(score_teamB);
        displayYellowCardTeamA(yellow_card_teamA);
        displayYellowCardTeamB(yellow_card_teamB);
        displayRedCardTeamA(red_card_teamA);
        displayRedCardTeamB(red_card_teamB);
        enableButton(view);
    }

    private void displayForTeamA(int score){
        TextView scoreView = (TextView) findViewById(R.id.team_a_score_football);
        scoreView.setText(String.valueOf(score));
    }
    private void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score_football);
        scoreView.setText(String.valueOf(score));
    }

    private void displayForTeamA(String score){
        TextView scoreView = (TextView) findViewById(R.id.team_a_score_football);
        scoreView.setText(String.valueOf(score));
    }
    private void displayForTeamB(String score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score_football);
        scoreView.setText(String.valueOf(score));
    }

    private void displayYellowCardTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.cartellinogiallo_teamA_textview);
        scoreView.setText(String.valueOf(score));
    }

    private void displayYellowCardTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.cartellinogiallo_teamB_textview);
        scoreView.setText(String.valueOf(score));
    }

    private void displayRedCardTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.cartellinorosso_teamA_textview);
        scoreView.setText(String.valueOf(score));
    }

    private void displayRedCardTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.cartellinorosso_teamB_textview);
        scoreView.setText(String.valueOf(score));
    }

    private void disableButton(View view){

        Button button_goal_teamA = (Button) findViewById(R.id.goal_button_teamA);
        Button button_goal_teamB = (Button) findViewById(R.id.goal_button_teamB);
        Button button_yellowcard_teamA = (Button) findViewById(R.id.add_yellowcard_teamA);
        Button button_yellowcard_teamB = (Button) findViewById(R.id.add_yellowcard_teamB);
        Button button_redcard_teamA = (Button) findViewById(R.id.add_redcard_teamA);
        Button button_redcard_teamB = (Button) findViewById(R.id.add_redcard_teamB);

        button_goal_teamA.setEnabled(false);
        button_goal_teamB.setEnabled(false);
        button_yellowcard_teamA.setEnabled(false);
        button_yellowcard_teamB.setEnabled(false);
        button_redcard_teamA.setEnabled(false);
        button_redcard_teamB.setEnabled(false);

        button_goal_teamA.setAlpha((float)0.5);
        button_goal_teamB.setAlpha((float)0.5);
        button_yellowcard_teamA.setAlpha((float)0.5);
        button_yellowcard_teamB.setAlpha((float)0.5);
        button_redcard_teamA.setAlpha((float)0.5);
        button_redcard_teamB.setAlpha((float) 0.5);

    }

    private void enableButton(View view){

        Button button_goal_teamA = (Button) findViewById(R.id.goal_button_teamA);
        Button button_goal_teamB = (Button) findViewById(R.id.goal_button_teamB);
        Button button_yellowcard_teamA = (Button) findViewById(R.id.add_yellowcard_teamA);
        Button button_yellowcard_teamB = (Button) findViewById(R.id.add_yellowcard_teamB);
        Button button_redcard_teamA = (Button) findViewById(R.id.add_redcard_teamA);
        Button button_redcard_teamB = (Button) findViewById(R.id.add_redcard_teamB);

        button_goal_teamA.setEnabled(true);
        button_goal_teamB.setEnabled(true);
        button_yellowcard_teamA.setEnabled(true);
        button_yellowcard_teamB.setEnabled(true);
        button_redcard_teamA.setEnabled(true);
        button_redcard_teamB.setEnabled(true);

        button_goal_teamA.setAlpha((float)1);
        button_goal_teamB.setAlpha((float)1);
        button_yellowcard_teamA.setAlpha((float)1);
        button_yellowcard_teamB.setAlpha((float)1);
        button_redcard_teamA.setAlpha((float)1);
        button_redcard_teamB.setAlpha((float) 1);

    }


}
