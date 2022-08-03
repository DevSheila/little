package com.example.little.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.little.adapters.RiderDocsAdapter;
import com.example.little.databinding.ActivityRiderDocsBinding;
import com.example.little.models.RiderDocsModel;
import com.example.little.viewmodels.RiderDocsViewModel;

import java.util.ArrayList;

import static com.example.little.adapters.RiderCategoryAdapter.SHARED_PREFS;
import static com.example.little.adapters.RiderCategoryAdapter.RIDER;

public class RiderDocsActivity extends AppCompatActivity implements View.OnClickListener{

    private ArrayList<RiderDocsModel> riderDocsModelsList;
    private RiderDocsAdapter adapter;
    private ActivityRiderDocsBinding binding;
    private String rider;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding= ActivityRiderDocsBinding.inflate(getLayoutInflater());
        View view =binding.getRoot();
        setContentView(view);


        binding.arrowBack.setOnClickListener(this);
        initRecyclerView();

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
         rider=sharedPreferences.getString(RIDER, "");
        Log.i("rider",sharedPreferences.getString(RIDER, ""));


        RiderDocsViewModel viewModel = ViewModelProviders.of(this).get(RiderDocsViewModel.class);

        viewModel = ViewModelProviders.of(this).get(RiderDocsViewModel.class);
        viewModel.getData(rider).observe(this, new Observer<ArrayList<RiderDocsModel>>() {
            @Override
            public void onChanged(ArrayList<RiderDocsModel> riderDocsModel) {
                if(riderDocsModel != null) {
                    riderDocsModelsList = riderDocsModel;
                    adapter.setRiderDocList(riderDocsModel);

                }
            }
        });


    }

    @Override
    public void onClick(View view) {
        if(view== binding.arrowBack){
            super.onBackPressed();
        }

    }


    private void initRecyclerView(){
        adapter = new RiderDocsAdapter(this, riderDocsModelsList);
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}