package com.example.little.views;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.little.databinding.ActivityOtpBinding;
import com.hbb20.CountryCodePicker;

import static com.example.little.adapters.RiderCategoryAdapter.COUNTRY;
import static com.example.little.adapters.RiderCategoryAdapter.SHARED_PREFS;

public class OtpActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityOtpBinding binding;
    private String phoneNumber;
    SharedPreferences sharedPreferences ;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=ActivityOtpBinding.inflate(getLayoutInflater());
        View view =binding.getRoot();
        setContentView(view);

        sharedPreferences= getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        editor= sharedPreferences.edit();

        binding.getOtp.setOnClickListener(this);
        binding.arrowBack.setOnClickListener(this);
        binding.ccp.setOnCountryChangeListener(new CountryCodePicker.OnCountryChangeListener() {
            @Override
            public void onCountrySelected() {
                Toast.makeText(getApplicationContext(), "Updated " + binding.ccp.getSelectedCountryName(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public void onClick(View view) {
        phoneNumber=binding.inputMobile.getText().toString().trim();
       if(view== binding.getOtp){
           if(!phoneNumber.isEmpty()){
               updateAlertDialog();
           }else{
               Toast.makeText(getApplicationContext(),"Enter mobile number",Toast.LENGTH_SHORT).show();
           }
       }else if(view== binding.arrowBack){
                super.onBackPressed();
       }
    }

    private void updateAlertDialog() {
        // Initialize AlertDialog
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        // Set title
//        builder.setTitle(getResources().getString(R.string.app_name));
        // set message
        builder.setMessage("You entered the phone number \n\n" +binding.inputMobile.getText().toString().trim()+ "\n\n Is this okay or would you like to edit the number?");
        // Set non cancelable
        builder.setCancelable(false);

        // On update
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                binding.ccp.registerCarrierNumberEditText(binding.inputMobile);
                binding.ccp.setPhoneNumberValidityChangeListener(new CountryCodePicker.PhoneNumberValidityChangeListener() {
                    @Override
                    public void onValidityChanged(boolean isValidNumber) {
                        if(isValidNumber){
                            editor.putString(COUNTRY,binding.ccp.getSelectedCountryName());
                            editor.apply();

                            Intent intent1=new Intent(getApplicationContext(), OtpVerifyActivity.class);
                            startActivity(intent1);
                        }else{
                            Toast.makeText(getApplicationContext(),"Please Enter a valid phone number",Toast.LENGTH_SHORT).show();

                        }
                    }
                });

                // Dismiss alert dialog
                dialogInterface.dismiss();
            }
        });

        // on cancel
        builder.setNegativeButton("EDIT", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // cancel alert dialog
                dialogInterface.cancel();
            }
        });

        // show alert dialog
        builder.show();
    }
}