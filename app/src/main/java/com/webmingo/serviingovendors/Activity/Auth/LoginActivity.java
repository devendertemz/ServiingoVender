package com.webmingo.serviingovendors.Activity.Auth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.irozon.sneaker.Sneaker;
import com.webmingo.serviingovendors.R;
import com.webmingo.serviingovendors.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding binding;
    private View view;

    String email,password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.activity_login);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_login);
        view = binding.getRoot();

        binding.cardLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DOLogin();
            }
        });
        binding.forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, SendOTP.class));
            }
        });




    }

    private void DOLogin()
    {
        email=binding.email.getText().toString();
        password=binding.password.getText().toString();
        if (email.isEmpty())
        {
            Sneaker.with(LoginActivity.this)
                    .setTitle("Enter email or Mobile Number !")
                    .setMessage("")
                    .sneakWarning();
        }
        else if (password.isEmpty())
        {
            Sneaker.with(LoginActivity.this)
                    .setTitle("Enter password !")
                    .setMessage("")
                    .sneakWarning();
        }else {


        }


    }
}