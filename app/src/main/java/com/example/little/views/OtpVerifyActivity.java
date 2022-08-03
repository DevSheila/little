package com.example.little.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;

import com.example.little.R;
import com.example.little.databinding.ActivityOtpVerifyBinding;

public class OtpVerifyActivity extends AppCompatActivity implements View.OnClickListener{

    Button verifyBtn;

    private ActivityOtpVerifyBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityOtpVerifyBinding.inflate(getLayoutInflater());
        View view =binding.getRoot();
        setContentView(view);

        verifyBtn = findViewById(R.id.otpVerify);

        binding.otpVerify.setOnClickListener(this);
        

        numberotpmove();


    }

    @Override
    public void onClick(View view) {


        if(view== binding.arrowBack){
            super.onBackPressed();

        }else if( view ==  binding.otpVerify){
            startActivity(new Intent(getApplicationContext(), RegisterActivity.class));

        }
    }

    private void numberotpmove(){
        binding.inputotp1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() == 1) {
                    binding.inputotp2.requestFocus();
                } else if (editable.length() == 0) {
                    binding.inputotp1.clearFocus();
                    binding.inputotp1.requestFocus();
                }
            }
        });
        binding.inputotp2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() == 1) {
                    binding.inputotp3.requestFocus();
                } else if (editable.length() == 0) {
                    binding.inputotp2.clearFocus();
                    binding.inputotp1.requestFocus();
                }
            }
        });
        binding.inputotp3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() == 1) {
                    binding.inputotp4.requestFocus();
                } else if (editable.length() == 0) {
                    binding.inputotp3.clearFocus();
                    binding.inputotp2.requestFocus();
                }
            }
        });
        binding.inputotp4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {




            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() == 1) {
                    binding.inputotp5.requestFocus();
                } else if (editable.length() == 0) {
                    binding.inputotp4.clearFocus();
                    binding.inputotp3.requestFocus();
                }
            }
        });
        binding.inputotp5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() == 1) {
                    binding.inputotp6.requestFocus();
                } else if (editable.length() == 0) {
                    binding.inputotp5.clearFocus();
                    binding.inputotp4.requestFocus();
                }
            }
        });
        binding.inputotp6.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() == 1) {
                    binding.inputotp6.requestFocus();
                } else if (editable.length() == 0) {
                    binding.inputotp6.clearFocus();
                    binding.inputotp5.requestFocus();
                }
            }
        });
    }
}