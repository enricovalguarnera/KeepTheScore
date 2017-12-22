package com.example.android.keepthescore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class VolleyActivity extends AppCompatActivity {

    private int score_teamA = 0, score_teamB = 0, score_setA = 0, score_setB = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);
    }

    public void returnToMainActivity(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void addOnePointTeamA(View view){
        if(score_teamA < 25) {
            score_teamA += 1;
            displayForTeamA(score_teamA);
            if (score_teamA == 25 && (score_teamA - score_teamB > 1)) {
                addPointSetA(view);

            }
        }else if(score_teamA >= 25 && (score_teamA - score_teamB == 0 )){
                //caso del pareggio
                score_teamA += 1;
                displayForTeamA(score_teamA);
        }else if(score_teamA >= 25 && (score_teamA - score_teamB < 0 )){
            score_teamA += 1;
            displayForTeamA(score_teamA);
        }else if(score_teamA >= 25 && (score_teamA - score_teamB <= 1 )){
            addPointSetA(view);

        }
    }


    public void addOnePointTeamB(View view){
        if(score_teamB < 25) {
            score_teamB += 1;
            displayForTeamB(score_teamB);
            if (score_teamB == 25 && (score_teamB - score_teamA > 1)) {
                addPointSetB(view);

            }
        }else if(score_teamB >= 25 && (score_teamB - score_teamA == 0 )){
            //caso del pareggio
            score_teamB += 1;
            displayForTeamB(score_teamB);
        }else if(score_teamB >= 25 && (score_teamB - score_teamA < 0 )) {
            score_teamB += 1;
            displayForTeamB(score_teamB);
        }else if(score_teamB >= 25 && (score_teamB - score_teamA <= 1 )){
            addPointSetB(view);

        }


    }

    private void addPointSetA(View view){
        switch (score_setA){
            case 0:{
                score_setA += 1;
                displaySetTeamA(score_setA);
                resetTextView(view);
                break;
            }
            case 1:{
                score_setA += 1;
                displaySetTeamA(score_setA);
                resetTextView(view);
                displayForTeamA("Win");
                disableButton(view);
                break;
            }
        }
    }

    private void addPointSetB(View view){
        switch (score_setB){
            case 0:{
                score_setB += 1;
                displaySetTeamB(score_setB);
                resetTextView(view);
                break;
            }
            case 1:{
                score_setB += 1;
                displaySetTeamB(score_setB);
                resetTextView(view);
                displayForTeamB("Win");
                disableButton(view);
                break;
            }
        }
    }

    //Method resets the scores

    public void resetPointTeamsVolley(View view){
        score_teamA = 0;
        score_teamB = 0;
        score_setA = 0;
        score_setB = 0;
        //displayMessageForA("");
        //displayMessageForB("");
        displayForTeamA(score_teamA);
        displayForTeamB(score_teamB);
        displaySetTeamA(score_setA);
        displaySetTeamB(score_setB);
        enableButton(view);
    }

    private void resetTextView(View view){
        score_teamA = 0;
        score_teamB = 0;
        displayForTeamA(score_teamA);
        displayForTeamB(score_teamB);
    }

    //This method disables the buttons

    private void disableButton(View view){
        Button button_teamA = (Button) findViewById(R.id.addpoint_button_teamA);
        Button button_teamB = (Button) findViewById(R.id.addpoint_button_teamB);

        button_teamA.setEnabled(false);
        button_teamB.setEnabled(false);

        button_teamA.setAlpha((float)0.5);
        button_teamB.setAlpha((float)0.5);
    }

    //This method enables the buttons

    private void enableButton(View view){
            Button button_teamA = (Button) findViewById(R.id.addpoint_button_teamA);
            Button button_teamB = (Button) findViewById(R.id.addpoint_button_teamB);

            button_teamA.setEnabled(true);
            button_teamB.setEnabled(true);

            button_teamA.setAlpha((float)1);
        button_teamB.setAlpha((float)1);
    }

    private void displayForTeamA(int score){
        TextView scoreView = (TextView) findViewById(R.id.team_a_score_volley);
        scoreView.setText(String.valueOf(score));
    }
    private void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score_volley);
        scoreView.setText(String.valueOf(score));
    }

    private void displayForTeamA(String message){
        TextView scoreView = (TextView) findViewById(R.id.team_a_score_volley);
        scoreView.setText(String.valueOf(message));
    }
    private void displayForTeamB(String message) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score_volley);
        scoreView.setText(String.valueOf(message));
    }

    private void displaySetTeamA(int score){
        TextView scoreView = (TextView) findViewById(R.id.setvolley_text_view_teamA);
        scoreView.setText(String.valueOf(score));
    }
    private void displaySetTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.setvolley_text_view_teamB);
        scoreView.setText(String.valueOf(score));
    }





}
