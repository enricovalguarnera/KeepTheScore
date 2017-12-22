package com.example.android.keepthescore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void basketActivity(View view) {
        Intent intent_basket = new Intent(this, BasketActivity.class);
        startActivity(intent_basket);
    }

    public void footballActivity(View view){
        this.view = view;
        Intent intent_football = new Intent(this, FootballActivity.class);
        startActivity(intent_football);
    }

    public void volleyActivity(View view){
        this.view = view;
        Intent intent_volley = new Intent(this, VolleyActivity.class);
        startActivity(intent_volley);
    }

    public void tennisActivity(View view){
        this.view = view;
        Intent intent_tennis = new Intent(this, TennisActivity.class);
        startActivity(intent_tennis);
    }

    public void rugbyActivity(View view){
        this.view = view;
        Intent intent_rugby = new Intent(this, RugbyActivity.class);
        startActivity(intent_rugby);
    }
}