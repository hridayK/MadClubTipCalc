package com.example.tipcalcapp;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.os.TestLooperManager;
import android.view.View;

import com.google.android.material.slider.Slider;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;

public class MainActivity extends AppCompatActivity {

    private Slider PercentageSet;
    private MaterialTextView PercentageView;
    private TextInputEditText BillAmount;

    double percentage,bill;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PercentageSet = (Slider) findViewById(R.id.percentage);
        PercentageView = (MaterialTextView) findViewById(R.id.perview);
        BillAmount = (TextInputEditText) findViewById(R.id.amt);

        PercentageSet.addOnChangeListener(new Slider.OnChangeListener() {
            @Override
            public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {
                int per = (int) value;
                PercentageView.setText(Integer.toString(per)+"%");
            }
        });
    }

}