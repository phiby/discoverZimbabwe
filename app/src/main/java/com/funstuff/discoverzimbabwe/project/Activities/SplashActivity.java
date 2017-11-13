package com.funstuff.discoverzimbabwe.project.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.funstuff.discoverzimbabwe.project.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    //here we control the splash screen and its contents.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_splash);

        //here we manage the splash screen progressbar and its animation.
     final ProgressBar prg = (ProgressBar) findViewById(R.id.progressBar14);


        final TextView iv = (TextView) findViewById(R.id.author);
        final Animation an = AnimationUtils.loadAnimation(getBaseContext(),R.anim.rotate);
         final Animation an2 = AnimationUtils.loadAnimation(getBaseContext(),R.anim.abc_fade_out);

         iv.startAnimation(an);

        //here is were we set and call the progressbar animation to start.

        an.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                 prg.setProgress(25);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                iv.startAnimation(an2);
                prg.setProgress(85);
                finish();
                Intent intent = new Intent(getBaseContext(),MainActivity.class);
                startActivity(intent);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
