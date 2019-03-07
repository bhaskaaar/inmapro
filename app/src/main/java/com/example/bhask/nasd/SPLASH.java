package com.example.bhask.nasd;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SPLASH extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 4000;
    private TextView tv;
    private ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        tv = (TextView) findViewById(R.id.tv);
        iv = (ImageView) findViewById(R.id.iv);
        Animation myAnim = AnimationUtils.loadAnimation(this,R.anim.mytransition);
        tv.startAnimation(myAnim);
        iv.startAnimation(myAnim);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SPLASH.this,MainActivity.class);
                startActivity(intent);
                finish();

            }
        },SPLASH_TIME_OUT);
    }
}
