package com.example.tipcalcapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textview.MaterialTextView;

public class BillActivity extends AppCompatActivity {

    private MaterialTextView bill;
    private MaterialTextView tip;

    private double total,percentage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);

        bill = (MaterialTextView) findViewById(R.id.billamt);
        tip = (MaterialTextView) findViewById(R.id.tipamt);

        Intent intent = getIntent();
        total = intent.getDoubleExtra("bill_amount",0);
        bill.setText("₹"+Double.toString(total));
        percentage = intent.getDoubleExtra("tip_percentage",0);
        tip.setText("₹"+String.format("%.2f",(total*(percentage/100.0))));

    }
}