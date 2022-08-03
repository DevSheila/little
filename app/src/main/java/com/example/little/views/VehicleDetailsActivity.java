package com.example.little.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.little.R;
import com.example.little.databinding.ActivityVehicleDetailsBinding;

public class VehicleDetailsActivity extends AppCompatActivity implements View.OnClickListener {

    private String selectedMake, selectedModel;                 //variables to hold the values of selected Make and Model
    private ActivityVehicleDetailsBinding binding;
    private ArrayAdapter<CharSequence> makeAdapter, modelAdapter;   //declare adapters for the spinners

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityVehicleDetailsBinding.inflate(getLayoutInflater());
        View view =binding.getRoot();
        setContentView(view);

        binding.btnVehicleDetails.setOnClickListener(this);
        binding.arrowBack.setOnClickListener(this);

        makeAdapter= ArrayAdapter.createFromResource(this,
                R.array.array_make, R.layout.support_simple_spinner_dropdown_item);
        // Specify the layout to use when the list of choices appear
        makeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinnerMake.setAdapter(makeAdapter);

        binding.spinnerMake.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedMake = binding.spinnerMake.getSelectedItem().toString();      //Obtain the selected Make

                int parentID = adapterView.getId();
                if (parentID == R.id.spinner_make) {
                    switch (selectedMake) {
                        case "Select Your Make": modelAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_default_model, R.layout.support_simple_spinner_dropdown_item);
                            break;
                        case "BAIC":
                            modelAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_Baic, R.layout.support_simple_spinner_dropdown_item);
                            break;
                        case "BOXER":
                            modelAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_Beth, R.layout.support_simple_spinner_dropdown_item);
                            break;
                        case "BETH":
                        case "Citroen":
                        case"Changan":
                        case"Cherry":
                        case"FAW":
                        case"FORCE":
                        case"Ford":
                        case"HONDA":
                        case"Isuzu":
                        case"Hyundai":
                        case"Geely":
                        case"Dong Feng":
                        case"Jac":
                        case "DAF":
                            modelAdapter = ArrayAdapter.createFromResource(adapterView.getContext(),
                                R.array.array_Boxer, R.layout.support_simple_spinner_dropdown_item);
                            break;
                        default:
                            throw new IllegalStateException("Unexpected value: " + selectedMake);
                    }

                    modelAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);     // Specify the layout to use when the list of choices appears
                    binding.spinnerModel.setAdapter(modelAdapter);        //Populate the list of Models in respect of the Make selected

                    //To obtain the selected Model from the spinner
                    binding.spinnerModel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            selectedModel = binding.spinnerModel.getSelectedItem().toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




    }

    @Override
    public void onClick(View view) {

        if(view== binding.arrowBack){
            super.onBackPressed();
        }
        if(view== binding.btnVehicleDetails){
            startActivity(new Intent(this, VehicleDocsActivity.class));

        }
    }
}