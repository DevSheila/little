package com.example.little.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.example.little.adapters.RiderCategoryAdapter;
import com.example.little.databinding.ActivityMainBinding;
import com.example.little.models.RiderCategoryModel;
import com.example.little.viewmodels.RiderCategoryViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private ArrayList<RiderCategoryModel> riderCategoryModelList;
    private RiderCategoryAdapter adapter;
    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=ActivityMainBinding.inflate(getLayoutInflater());
        View view =binding.getRoot();
        setContentView(view);

        binding.arrowBack.setOnClickListener(this);
        initRecyclerView();

        RiderCategoryViewModel viewModel = ViewModelProviders.of(this).get(RiderCategoryViewModel.class);

        viewModel = ViewModelProviders.of(this).get(RiderCategoryViewModel.class);
        viewModel.getData().observe(this, new Observer<ArrayList<RiderCategoryModel>>() {
            @Override
            public void onChanged(ArrayList<RiderCategoryModel> riderCategoryModels) {
                if(riderCategoryModels != null) {
                    riderCategoryModelList = riderCategoryModels;
                    adapter.setRiderCategoryList(riderCategoryModels);

                }
            }
        });


    }

    private void initRecyclerView(){
        adapter = new RiderCategoryAdapter(this, riderCategoryModelList);
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onClick(View view) {
        if(view == binding.arrowBack){
            super.onBackPressed();
        }

    }
}