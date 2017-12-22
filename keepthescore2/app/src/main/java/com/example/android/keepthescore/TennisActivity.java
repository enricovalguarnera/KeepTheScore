package com.example.android.keepthescore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TennisActivity extends AppCompatActivity {

    private String score_playerA = "0", score_playerB = "0";
    private int score_gameA = 0, score_gameB = 0, score_setA = 0, score_setB =  0;
    int score_tiebreakA = 0, score_tiebreakB = 0;
    boolean tie_break = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tennis);
    }

    public void returnToMainActivity(View view){
        Intent returnHome = new Intent(this, MainActivity.class);
        startActivity(returnHome);
    }

    public void addOnePointPlayerA(View view) {
        if (!tie_break) {
            switch (score_playerA) {
                case "0": {
                    score_playerA = "15";
                    displayForPlayerA(score_playerA);
                    break;
                }
                case "15": {
                    score_playerA = "30";
                    displayForPlayerA(score_playerA);
                    break;
                }
                case "30": {
                    score_playerA = "40";
                    displayForPlayerA(score_playerA);
                    break;
                }
                case "40": {
                    if (score_playerB == "0" || score_playerB == "15" || score_playerB == "30") {
                        resetTextView(view);
                        addPointGameA(view);
                    }
                    if (score_playerB == "40") {
                        score_playerA = "A";
                        displayForPlayerA(score_playerA);
                    }
                    if (score_playerB == "A") {
                        score_playerB = "40";
                        displayForPlayerB(score_playerB);
                    }
                    break;
                }
                case "A": {
                    addPointGameA(view);
                    resetTextView(view);
                    break;
                }
            }
        } else {

            switch (score_tiebreakA) {
                case 0:{
                    score_tiebreakA += 1;
                    displayForPlayerA(score_tiebreakA);
                    break;
                }
                case 1: {
                    score_tiebreakA += 1;
                    displayForPlayerA(score_tiebreakA);
                    break;
                }
                case 2: {
                    score_tiebreakA += 1;
                    displayForPlayerA(score_tiebreakA);
                    break;
                }
                case 3: {
                    score_tiebreakA += 1;
                    displayForPlayerA(score_tiebreakA);
                    break;
                }
                case 4: {
                    score_tiebreakA += 1;
                    displayForPlayerA(score_tiebreakA);
                    break;
                }
                case 5: {
                    score_tiebreakA += 1;
                    displayForPlayerA(score_tiebreakA);
                    break;
                }
                default: {
                    if (score_tiebreakA == 6 && score_tiebreakB <= 5) {
                        addPointSetA(view);
                        resetTieBreak();
                    }else  if (score_tiebreakA >= 6 && (score_tiebreakA - score_tiebreakB > 1)) {
                        addPointSetA(view);
                        resetTieBreak();
                    } else if (score_tiebreakB >= 6 && (score_tiebreakB - score_tiebreakA == 0)) {
                        score_tiebreakA += 1;
                        displayForPlayerA(score_tiebreakA);

                    } else if (score_tiebreakA >= 6 && (score_tiebreakA - score_tiebreakB < 0)) {
                        score_tiebreakA += 1;
                        displayForPlayerA(score_tiebreakA);
                    } else if (score_tiebreakA >= 6 && (score_tiebreakA - score_tiebreakB <= 1)) {
                        score_tiebreakA += 1;
                        displayForPlayerA(score_tiebreakA);
                        addPointSetA(view);
                        resetTieBreak();
                    }
                    break;
                }

            }
        }
    }

    public void addOnePointPlayerB(View view) {
        if (!tie_break) {
            switch (score_playerB) {
                case "0": {
                    score_playerB = "15";
                    displayForPlayerB(score_playerB);
                    break;
                }
                case "15": {
                    score_playerB = "30";
                    displayForPlayerB(score_playerB);
                    break;
                }
                case "30": {
                    score_playerB = "40";
                    displayForPlayerB(score_playerB);
                    break;
                }
                case "40": {
                    if (score_playerA == "0" || score_playerA == "15" || score_playerA == "30") {
                        resetTextView(view);
                        addPointGameB(view);
                    }
                    if (score_playerA == "40") {
                        score_playerB = "A";
                        displayForPlayerB(score_playerB);
                    }
                    if (score_playerA == "A") {
                        score_playerA = "40";
                        displayForPlayerA(score_playerA);
                    }
                    break;
                }
                case "A": {
                    addPointGameB(view);
                    resetTextView(view);
                    break;
                }
            }
        } else {
            switch (score_tiebreakB) {
                case 0: {
                    score_tiebreakB += 1;
                    displayForPlayerB(score_tiebreakB);
                    break;
                }
                case 1: {
                    score_tiebreakB += 1;
                    displayForPlayerB(score_tiebreakB);
                    break;
                }
                case 2: {
                    score_tiebreakB += 1;
                    displayForPlayerB(score_tiebreakB);
                    break;
                }
                case 3: {
                    score_tiebreakB += 1;
                    displayForPlayerB(score_tiebreakB);
                    break;
                }
                case 4: {
                    score_tiebreakB += 1;
                    displayForPlayerB(score_tiebreakB);
                    break;
                }
                case 5: {
                    score_tiebreakB += 1;
                    displayForPlayerB(score_tiebreakB);
                    break;
                }
                default: {
                    if (score_tiebreakA == 6 && score_tiebreakB <= 5) {
                        addPointSetB(view);
                        resetTieBreak();
                    }else  if (score_tiebreakB >= 6 && (score_tiebreakB - score_tiebreakA > 1)) {
                        addPointSetB(view);
                        resetTieBreak();

                    } else if (score_tiebreakA >= 6 && (score_tiebreakA - score_tiebreakB == 0)) {
                        score_tiebreakB += 1;
                        displayForPlayerB(score_tiebreakB);

                    } else if (score_tiebreakB >= 6 && (score_tiebreakB - score_tiebreakA < 0)) {
                        score_tiebreakB += 1;
                        displayForPlayerB(score_tiebreakB);
                    } else if (score_tiebreakB >= 6 && (score_tiebreakB - score_tiebreakA <= 1)) {
                        score_tiebreakB += 1;
                        displayForPlayerB(score_tiebreakB);
                        addPointSetB(view);
                        resetTieBreak();
                    }
                    break;
                }
            }
        }
    }

    private void addPointGameA(View view){
        if (score_gameA < 5) {
            score_gameA += 1;
            displayGameForA(score_gameA);
        } else if ((score_gameA == 5 && score_gameB < 5) || (score_gameA == 6 && score_gameB == 5)) {
            addPointSetA(view);
        } else if (score_gameA == 5 && score_gameB == 5) {
            score_gameA += 1;
            displayGameForA(score_gameA);
        } else if (score_gameA == 5 && score_gameB == 6) {
            score_gameA += 1;
            displayGameForA(score_gameA);
            tie_break = true;
            enableTieBreak(view);
        }
    }

    private void addPointGameB(View view){
        if (score_gameB < 5) {
            score_gameB += 1;
            displayGameForB(score_gameB);
        } else if ((score_gameB == 5 && score_gameA < 5) || (score_gameB == 6 && score_gameA == 5)) {
            addPointSetB(view);
        } else if (score_gameB == 5 && score_gameA == 5) {
            score_gameB += 1;
            displayGameForB(score_gameB);
        } else if (score_gameB == 5 && score_gameA == 6) {
            score_gameB += 1;
            displayGameForB(score_gameB);
            tie_break = true;
            enableTieBreak(view);
        }
    }

    private void addPointSetA(View view){
        switch (score_setA){
            case 0:{
                score_setA += 1;
                displaySetForA(score_setA);
                resetGame(view);
                break;
            }
            case 1:{
                score_setA += 1;
                displaySetForA(score_setA);
                resetGame(view);
                disableButton(view);
                break;
            }
        }

        if(score_setA == 2)
            displayForPlayerA("Win");
    }

    private void addPointSetB(View view){
        switch (score_setB){
            case 0:{
                score_setB += 1;
                displaySetForB(score_setB);
                resetGame(view);
                break;
            }
            case 1:{
                score_setB += 1;
                displaySetForB(score_setB);
                resetGame(view);
                disableButton(view);
                break;
            }
        }
        if(score_setB == 2)
            displayForPlayerB("Win");
    }

    //method resets the score

    public void resetPointPlayersTennis(View view) {
        score_playerA = "0";
        score_playerB = "0";
        score_tiebreakB = 0;
        score_tiebreakA = 0;
        score_gameA = 0;
        score_gameB = 0;
        score_setA = 0;
        score_setB = 0;
        tie_break = false;
        displayForPlayerA(score_playerA);
        displayForPlayerB(score_playerB);
        displayGameForA(score_gameA);
        displayGameForB(score_gameB);
        displaySetForA(score_setA);
        displaySetForB(score_setB);
        enableButton(view);
        disableTieBreak(view);
    }

    private void resetGame(View view){
        score_gameA = 0;
        score_gameB = 0;
        displayGameForA(score_gameA);
        displayGameForB(score_gameB);
        resetTextView(view);
        disableTieBreak(view);
    }

    private void resetTextView(View view){
        score_playerA = "0";
        score_playerB = "0";
        displayForPlayerA(score_playerA);
        displayForPlayerB(score_playerB);
    }

    private void resetTieBreak(){
        score_tiebreakA = 0;
        score_tiebreakB = 0;
        tie_break = false;
    }


    //This method disables the buttons

    private void disableButton(View view){
        Button button_teamA = (Button) findViewById(R.id.addpoint_button_playerA);
        Button button_teamB = (Button) findViewById(R.id.addpoint_button_playerB);

        button_teamA.setEnabled(false);
        button_teamB.setEnabled(false);

        button_teamA.setAlpha((float)0.5);
        button_teamB.setAlpha((float)0.5);
    }

    //This method enables the buttons

    private void enableButton(View view){
        Button button_teamA = (Button) findViewById(R.id.addpoint_button_playerA);
        Button button_teamB = (Button) findViewById(R.id.addpoint_button_playerB);

        button_teamA.setEnabled(true);
        button_teamB.setEnabled(true);

        button_teamA.setAlpha((float)1);
        button_teamB.setAlpha((float)1);
    }

    private void displayForPlayerA(String score){
        TextView scoreView = (TextView) findViewById(R.id.player_a_score_tennis);
        scoreView.setText(String.valueOf(score));
    }
    private void displayForPlayerB(String score) {
        TextView scoreView = (TextView) findViewById(R.id.player_b_score_tennis);
        scoreView.setText(String.valueOf(score));
    }

    private void displayForPlayerB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.player_b_score_tennis);
        scoreView.setText(String.valueOf(score));
    }

    private void displayForPlayerA(int score){
        TextView scoreView = (TextView) findViewById(R.id.player_a_score_tennis);
        scoreView.setText(String.valueOf(score));
    }

    private void displayGameForA(int score){
        TextView scoreView = (TextView) findViewById(R.id.game_text_view_player_A);
        scoreView.setText(String.valueOf(score));
    }

    private void displayGameForB(int score){
        TextView scoreView = (TextView) findViewById(R.id.game_text_view_player_B);
        scoreView.setText(String.valueOf(score));
    }

    private void displaySetForA(int score){
        TextView scoreView = (TextView) findViewById(R.id.set_text_view_player_A);
        scoreView.setText(String.valueOf(score));
    }

    private void displaySetForB(int score){
        TextView scoreView = (TextView) findViewById(R.id.set_text_view_player_B);
        scoreView.setText(String.valueOf(score));
    }

    private void enableTieBreak(View view){
        TextView tie_break = (TextView) findViewById(R.id.tie_break_text_view);
        tie_break.setAlpha((float)1);
    }

    private void disableTieBreak(View view){
        TextView tie_break = (TextView) findViewById(R.id.tie_break_text_view);
        tie_break.setAlpha((float)0);
    }
}
