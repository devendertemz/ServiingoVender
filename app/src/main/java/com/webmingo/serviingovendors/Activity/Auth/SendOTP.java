package com.webmingo.serviingovendors.Activity.Auth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.webmingo.serviingovendors.R;
import com.webmingo.serviingovendors.databinding.ActivitySendOTPBinding;


public class SendOTP extends AppCompatActivity {
    //implements ForgotPasswordSendOtpPresenter.ForgotPasswordSendOtpView{


    ActivitySendOTPBinding binding;

    TextView back, otpContinue, tvCreateAccount;
    EditText etEmail;
    String email;
    //ForgotPasswordSendOtpPresenter passwordSendOtpPresenter;
    private View view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_send_o_t_p);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_send_o_t_p);
        view = binding.getRoot();
        binding.cardLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(SendOTP.this, OTP_VerificationActivity.class));
            }
        });

    }


    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        startActivity(new Intent(SendOTP.this, LoginActivity.class));


    }


}