package com.example.little.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;

import com.example.little.databinding.ActivityVehicleOwnerBinding;
import com.example.little.views.PasswordsActivity;
import com.example.little.views.VehicleDetailsActivity;

import static com.example.little.adapters.RiderCategoryAdapter.HAS_CAR;
import static com.example.little.adapters.RiderCategoryAdapter.RIDER;
import static com.example.little.adapters.RiderCategoryAdapter.SHARED_PREFS;

public class VehicleOwnerActivity extends AppCompatActivity implements View.OnClickListener{

    private ActivityVehicleOwnerBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding= ActivityVehicleOwnerBinding.inflate(getLayoutInflater());
        View view =binding.getRoot();
        setContentView(view);

        binding.btnVehicleNext.setOnClickListener(this);
        binding.arrowBack.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        if (view == binding.btnVehicleNext) {

            int selectedId = binding.radiogrp.getCheckedRadioButtonId();
            RadioButton radioButton = (RadioButton) findViewById(selectedId);


            SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);

            SharedPreferences.Editor editor = sharedPreferences.edit();
            String ownsCar=radioButton.getText().toString();
            editor.putString(HAS_CAR,ownsCar);

            Log.i("owner",sharedPreferences.getString(HAS_CAR, ""));
            Log.i("rider",sharedPreferences.getString(RIDER, ""));

            editor.apply();

            if(ownsCar.equals("Yes")){
                startActivity(new Intent(getApplicationContext(), VehicleDetailsActivity.class));
            }else if(ownsCar.equals("No")){
                startActivity(new Intent(getApplicationContext(), PasswordsActivity.class));

            }


        }

        if(view== binding.arrowBack){
            super.onBackPressed();
        }
    }
}