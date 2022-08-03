package com.example.little.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.little.adapters.VehicleDocsAdapter;
import com.example.little.databinding.ActivityVehicleDocsBinding;
import com.example.little.models.VehicleDocsModel;
import com.example.little.viewmodels.VehicleDocsViewModel;

import java.util.ArrayList;

import static com.example.little.adapters.RiderCategoryAdapter.RIDER;
import static com.example.little.adapters.RiderCategoryAdapter.SHARED_PREFS;

public class VehicleDocsActivity extends AppCompatActivity  implements View.OnClickListener {
    private ArrayList<VehicleDocsModel> vehicleDocsModelsList;
    VehicleDocsAdapter adapter;
    private ActivityVehicleDocsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding= ActivityVehicleDocsBinding.inflate(getLayoutInflater());
        View view =binding.getRoot();
        setContentView(view);

        binding.arrowBack.setOnClickListener(this);
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        String rider=sharedPreferences.getString(RIDER, "");

        VehicleDocsViewModel viewModel = ViewModelProviders.of(this).get(VehicleDocsViewModel.class);

        viewModel = ViewModelProviders.of(this).get(VehicleDocsViewModel.class);
        viewModel.getData(rider).observe(this, new Observer<ArrayList<VehicleDocsModel>>() {
            @Override
            public void onChanged(ArrayList<VehicleDocsModel> vehicleDocsModel) {
                if(vehicleDocsModel != null) {
                    vehicleDocsModelsList = vehicleDocsModel;
                    adapter.setVehicleDocList(vehicleDocsModel);

                } else {
                }
            }
        });

        initRecyclerView();

    }

    @Override
    public void onClick(View view) {
        if(view== binding.arrowBack){
            super.onBackPressed();
        }

    }

    private void initRecyclerView(){
        adapter = new VehicleDocsAdapter(this, vehicleDocsModelsList);
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}