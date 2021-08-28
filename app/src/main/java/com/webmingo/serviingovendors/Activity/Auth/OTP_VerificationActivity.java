package com.webmingo.serviingovendors.Activity.Auth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.webmingo.serviingovendors.R;
import com.webmingo.serviingovendors.databinding.ActivityOTPVerificationBinding;

public class OTP_VerificationActivity extends AppCompatActivity {
   ActivityOTPVerificationBinding binding;
    private View view;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_o_t_p__verification);


        binding = DataBindingUtil.setContentView(this, R.layout.activity_o_t_p__verification);
        view = binding.getRoot();
        binding.otpContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(OTP_VerificationActivity.this, CratePasswordActivity.class));
            }
        });
    }

}