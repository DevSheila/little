package com.example.little.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.example.little.adapters.ProgressStepsAdapter;
import com.example.little.databinding.ActivityProgressBinding;
import com.example.little.models.ProgressStepsModel;
import com.example.little.viewmodels.ProgressStepsViewModel;

import java.util.ArrayList;

public class ProgressActivity extends AppCompatActivity {

    private ArrayList<ProgressStepsModel> progressModelList;
    private ProgressStepsAdapter adapter;
    private ActivityProgressBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=ActivityProgressBinding.inflate(getLayoutInflater());
        View view =binding.getRoot();
        setContentView(view);
        initRecyclerView();

        ProgressStepsViewModel viewModel = ViewModelProviders.of(this).get(ProgressStepsViewModel.class);

        viewModel = ViewModelProviders.of(this).get(ProgressStepsViewModel.class);
        viewModel.getData().observe(this, new Observer<ArrayList<ProgressStepsModel>>() {
            @Override
            public void onChanged(ArrayList<ProgressStepsModel> progressStepsModels) {
                if(progressStepsModels != null) {
                    progressModelList = progressStepsModels;
                    adapter.setProgresStepsList(progressStepsModels);

                } else {
                }
            }
        });

    }

    private void initRecyclerView(){
        adapter = new ProgressStepsAdapter(this,progressModelList );
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}