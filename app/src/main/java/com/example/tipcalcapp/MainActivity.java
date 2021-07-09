package com.example.tipcalcapp;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.TestLooperManager;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.slider.Slider;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;

public class MainActivity extends AppCompatActivity {

    private Slider PercentageSet;
    private MaterialTextView PercentageView;
    private TextInputEditText BillAmount;
    private MaterialButton change;

    double percentage,bill;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

        PercentageSet = (Slider) findViewById(R.id.percentage);
        PercentageView = (MaterialTextView) findViewById(R.id.perview);
        BillAmount = (TextInputEditText) findViewById(R.id.amt);
        change = (MaterialButton) findViewById(R.id.pariwartan);

        PercentageSet.addOnChangeListener(new Slider.OnChangeListener() {
            @Override
            public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {
                int per = (int) value;
                percentage = value;
                PercentageView.setText(Integer.toString(per)+"%");
            }
        });
    }

    public void ChangeActivity(View view){
        if (BillAmount.getText().toString().isEmpty())
            Toast.makeText(this,"you have not entered bill amount",0).show();
        else if(!isDouble(BillAmount.getText().toString()))
            Toast.makeText(this,"you have not entered a number",0).show();
        else{
            Intent intent = new Intent(this, BillActivity.class);

            bill = Double.parseDouble(BillAmount.getText().toString());

            intent.putExtra("bill_amount",bill);
            intent.putExtra("tip_percentage",percentage);

            startActivity(intent);
        }
    }

    public boolean isDouble(String text){
        try {
            Double.parseDouble(text);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}