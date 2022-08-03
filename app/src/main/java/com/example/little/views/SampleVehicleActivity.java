package com.example.little.views;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.little.databinding.ActivitySampleBinding;
import com.example.little.models.VehicleDocsModel;
import com.example.little.viewmodels.VehicleDocsViewModel;
import com.github.dhaval2404.imagepicker.ImagePicker;

import static com.example.little.adapters.RiderCategoryAdapter.RIDER;
import static com.example.little.adapters.RiderCategoryAdapter.SHARED_PREFS;

public class SampleVehicleActivity extends AppCompatActivity implements View.OnClickListener{

    private ActivitySampleBinding binding;
    private String rider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySampleBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.uplaodImg.setOnClickListener(this);
        binding.arrowBack.setOnClickListener(this);

        Intent intent = getIntent();

        int position = intent.getIntExtra("position", 0);
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        rider=sharedPreferences.getString(RIDER, "");


        VehicleDocsViewModel viewModel = ViewModelProviders.of(this).get(VehicleDocsViewModel.class);

        viewModel = ViewModelProviders.of(this).get(VehicleDocsViewModel.class);


        viewModel.getDocData(rider,position).observe(this, new Observer<VehicleDocsModel>() {
            @Override
            public void onChanged(VehicleDocsModel vehicleDocsModel) {
                binding.txtTitle.setText(String.format("Take a photo of your %s", vehicleDocsModel.docType));
                binding.txtDescription.setText(String.format(vehicleDocsModel.docDescription));
                Toast.makeText(getApplicationContext(), "doc:" + vehicleDocsModel.docType, Toast.LENGTH_LONG).show();
            }
        });


    }

    @Override
    public void onClick(View view) {
        if (view == binding.uplaodImg) {
            ImagePicker.Companion.with(this)
                    .crop()
                    .compress(1024)
                    .maxResultSize(1080, 1080)
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
            Intent intent2 = new Intent(getApplicationContext(), SampleVehicleResponseActivity.class);
            intent2.putExtra("uploadedDoc", fileUri.toString());
            startActivity(intent2);

        } else if (resultCode == ImagePicker.RESULT_ERROR) {
            Toast.makeText(this, ImagePicker.Companion.getError(data), Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this, "Task Cancelled", Toast.LENGTH_SHORT).show();
        }

    }
}