package com.leewilson.codelabs.batteryindicator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int mBatteryLevel;
    private Button mMinusButton;
    private Button mPlusButton;
    private ImageView mBatteryImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBatteryImage = findViewById(R.id.battery_image);
        mMinusButton = findViewById(R.id.button_minus);
        mPlusButton = findViewById(R.id.button_plus);

        if(savedInstanceState != null){
            mBatteryLevel = savedInstanceState.getInt("mBatteryLevel");
            mBatteryImage.setImageLevel(mBatteryLevel);
        } else {
            mBatteryImage.setImageLevel(mBatteryLevel);
        }

        mMinusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mBatteryLevel != 0){
                    mBatteryLevel--;
                    mBatteryImage.setImageLevel(mBatteryLevel);
                } else {
                    Toast.makeText(MainActivity.this, "Cannot reduce battery level.", Toast.LENGTH_LONG).show();
                }
            }
        });

        mPlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mBatteryLevel != 6){
                    mBatteryLevel++;
                    mBatteryImage.setImageLevel(mBatteryLevel);
                } else {
                    Toast.makeText(MainActivity.this, "Cannot increase battery level.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("mBatteryLevel", mBatteryLevel);
    }
}
