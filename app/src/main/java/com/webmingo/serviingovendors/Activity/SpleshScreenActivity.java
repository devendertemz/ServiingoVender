package com.webmingo.serviingovendors.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.webmingo.serviingovendors.Activity.Auth.LoginActivity;
import com.webmingo.serviingovendors.R;
import com.webmingo.serviingovendors.Util.CheckInternetConnection;
import com.webmingo.serviingovendors.Util.util;
import com.webmingo.serviingovendors.databinding.ActivitySpleshScreenBinding;

public class SpleshScreenActivity extends AppCompatActivity {

    ActivitySpleshScreenBinding binding;
    private View view;



    private static int SPLASH_TIME_OUT = 3000;
  /*  LinearLayout LinnearLayoutLogo;
    LottieAnimationView animationView;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_splesh_screen);

        view = binding.getRoot();



        if (util.isOnline(getApplicationContext())) {

            splesh();
        } else {

            new CheckInternetConnection(this).checkConnection();


        }

    }

    public void splesh() {

        YoYo.with(Techniques.Bounce)
                .duration(7000)
                .playOn(binding.LinnearLayoutLogo);
        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                startActivity(new Intent(SpleshScreenActivity.this, LoginActivity.class));
                finish();
            }
        }, SPLASH_TIME_OUT);



/*

        new Handler().postDelayed(new Runnable() {

            *//*
         * Showing splash screen with a timer. This will be useful when you
         * want to show case your app logo / company
         *//*

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                startActivity(new Intent(SplashScreen.this, LoginActivity.class));
                finish();
            }
        }, SPLASH_TIME_OUT);*/
    }


}

