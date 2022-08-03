package com.example.little.views;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.little.databinding.ActivitySampleVehicleResponseBinding;
import com.example.little.views.PasswordsActivity;
import com.github.dhaval2404.imagepicker.ImagePicker;

import static com.example.little.adapters.RiderCategoryAdapter.RIDER;
import static com.example.little.adapters.RiderCategoryAdapter.SHARED_PREFS;

public class SampleVehicleResponseActivity extends AppCompatActivity implements View.OnClickListener{

    String rider;

    private ActivitySampleVehicleResponseBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivitySampleVehicleResponseBinding.inflate(getLayoutInflater());
        View view =binding.getRoot();
        setContentView(view);

        binding.proceed.setOnClickListener(this);
        binding.uplaodImg.setOnClickListener(this);
        binding.arrowBack.setOnClickListener(this);


        Intent intent = getIntent();
        Uri fileUri = Uri.parse(intent.getStringExtra("uploadedDoc"));

        binding.sampleimg.setImageURI(fileUri);

    }

    @Override
    public void onClick(View view) {
        if(view == binding.proceed){
            SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
            String rider=sharedPreferences.getString(RIDER, "");
            Log.i("rider",sharedPreferences.getString(RIDER, ""));
            startActivity(new Intent(getApplicationContext(), PasswordsActivity.class));

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
}
