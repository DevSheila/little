package com.example.little.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.little.R;
import com.example.little.databinding.ActivityRegisterBinding;

import static com.example.little.adapters.RiderCategoryAdapter.COUNTRY;
import static com.example.little.adapters.RiderCategoryAdapter.SHARED_PREFS;
//import android.view.View;

public class RegisterActivity extends AppCompatActivity  implements View.OnClickListener {

    private String selectedCity, selectedCountry;                 //variables to hold the values of selected City and Country
    private ActivityRegisterBinding binding;
    private ArrayAdapter<CharSequence> countryAdapter, cityAdapter;   //declare adapters for the spinners

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityRegisterBinding.inflate(getLayoutInflater());
        View view =binding.getRoot();
        setContentView(view);

        binding.btnSignUp.setOnClickListener(this);
        binding.arrowBack.setOnClickListener(this);

        SharedPreferences sharedPreferences= getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);

        String selectedCountry=sharedPreferences.getString(COUNTRY,"");

        switch (selectedCountry) {
            case "Select Your Make": cityAdapter = ArrayAdapter.createFromResource(getApplicationContext(),
                    R.array.array_default_model, R.layout.support_simple_spinner_dropdown_item);
                break;
            case "Kenya":
                cityAdapter = ArrayAdapter.createFromResource(getApplicationContext(),
                        R.array.array_kenya, R.layout.support_simple_spinner_dropdown_item);
                break;
            case "Tanzania":
                cityAdapter = ArrayAdapter.createFromResource(getApplicationContext(),
                        R.array.array_tanzania, R.layout.support_simple_spinner_dropdown_item);
                break;

            case "Ghana":
                cityAdapter = ArrayAdapter.createFromResource(getApplicationContext(),
                        R.array.array_ghana, R.layout.support_simple_spinner_dropdown_item);
                break;
             case "Senegal":
                 cityAdapter = ArrayAdapter.createFromResource(getApplicationContext(),
                        R.array.array_senegal, R.layout.support_simple_spinner_dropdown_item);
                break;
             case "India":
                 cityAdapter = ArrayAdapter.createFromResource(getApplicationContext(),
                        R.array.array_india, R.layout.support_simple_spinner_dropdown_item);
                break;
             case "Zambia":
                 cityAdapter = ArrayAdapter.createFromResource(getApplicationContext(),
                        R.array.array_zambia, R.layout.support_simple_spinner_dropdown_item);
                break;
             case "Uganda":
                 cityAdapter = ArrayAdapter.createFromResource(getApplicationContext(),
                        R.array.array_uganda, R.layout.support_simple_spinner_dropdown_item);
                break;
             case "Somalia":
                 cityAdapter = ArrayAdapter.createFromResource(getApplicationContext(),
                        R.array.array_somalia, R.layout.support_simple_spinner_dropdown_item);
                break;


            default:
                throw new IllegalStateException("Unexpected value: " + selectedCountry);
        }

        cityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);     // Specify the layout to use when the list of choices appears
        binding.spinnerCity.setAdapter(cityAdapter);        //Populate the list of Models in respect of the Country selected

        //To obtain the selected City from the spinner
        binding.spinnerCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedCity = binding.spinnerCity.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


    }


    @Override
    public void onClick(View view) {
       if(view==binding.btnSignUp){
           startActivity(new Intent(getApplicationContext(), RiderDocsActivity.class));
       }

       if(view == binding.arrowBack){
           super.onBackPressed();
       }

    }
}