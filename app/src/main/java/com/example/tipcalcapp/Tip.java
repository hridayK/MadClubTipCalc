package com.example.tipcalcapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Tip extends AppCompatActivity {

    private TextView calc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip);
        calc = (TextView) findViewById(R.id.tipamt);
        Intent intent = getIntent();
        double bill = intent.getDoubleExtra("amount",0);
        double percen = intent.getDoubleExtra("percentage",0);
        double tip = bill*(percen/100.0);
        calc.setText("₹"+Double.toString(tip));
    }
}