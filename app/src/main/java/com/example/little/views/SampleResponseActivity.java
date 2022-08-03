package com.example.little.views;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.little.databinding.ActivitySampleResponseBinding;
import com.github.dhaval2404.imagepicker.ImagePicker;

import static com.example.little.adapters.RiderCategoryAdapter.RIDER;
import static com.example.little.adapters.RiderCategoryAdapter.SHARED_PREFS;

public class SampleResponseActivity extends AppCompatActivity implements View.OnClickListener{

    String rider;
    SharedPreferences sharedPreferences ;
    SharedPreferences.Editor editor;
    Uri fileUri;
    private ActivitySampleResponseBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivitySampleResponseBinding.inflate(getLayoutInflater());
        View view =binding.getRoot();
        setContentView(view);

        sharedPreferences= getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        editor= sharedPreferences.edit();


        binding.proceed.setOnClickListener(this);
        binding.arrowBack.setOnClickListener(this);
        binding.uplaodImg.setOnClickListener(this);


        Intent intent = getIntent();
        fileUri = Uri.parse(intent.getStringExtra("uploadedDoc"));

        binding.sampleimg.setImageURI(fileUri);



    }

    @Override
    public void onClick(View view) {
        if(view == binding.proceed){
            String rider=sharedPreferences.getString(RIDER, "");


            if(rider == "driver"){

                startActivity(new Intent(getApplicationContext(), VehicleOwnerActivity.class));
            }else{
                startActivity(new Intent(getApplicationContext(), VehicleDetailsActivity.class));
            }

        }
        if(view == binding.uplaodImg) {
            ImagePicker.Companion.with(this)
                    .crop()                    //Crop image(Optional), Check Customization for more option
                    .compress(1024)            //Final image size will be less than 1 MB(Optional)
                    .maxResultSize(1080, 1080)    //Final image resolution will be less than 1080 x 1080(Optional)
                    .start();


        }

        if(view== binding.arrowBack){
            super.onBackPressed();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            //Image Uri will not be null for RESULT_OK
            Uri fileUri = data.getData();

            // Use Uri object instead of File to avoid storage permissions
            binding.sampleimg.setImageURI(fileUri);



        } else if (resultCode == ImagePicker.RESULT_ERROR) {
            Toast.makeText(this, ImagePicker.Companion.getError(data), Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this, "Task Cancelled", Toast.LENGTH_SHORT).show();
        }

    }
}