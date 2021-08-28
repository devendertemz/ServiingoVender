package com.webmingo.serviingovendors.Activity.Auth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.webmingo.serviingovendors.R;
import com.webmingo.serviingovendors.databinding.ActivityCratePasswordBinding;


public class CratePasswordActivity extends AppCompatActivity {
    ActivityCratePasswordBinding binding;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_crate_password);

                binding = DataBindingUtil.setContentView(this, R.layout.activity_crate_password);
        view = binding.getRoot();
        binding.cardLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(CratePasswordActivity.this, LoginActivity.class));
            }
        });
    }


    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        startActivity(new Intent(CratePasswordActivity.this, SendOTP.class));


    }


}