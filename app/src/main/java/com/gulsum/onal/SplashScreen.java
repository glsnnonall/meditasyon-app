package com.gulsum.onal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {
    ImageView logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        logo = (ImageView)findViewById(R.id.logo);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.mytransistion);
        logo.startAnimation(animation);

        Thread thread = new Thread(){
            @Override
            public void run() {
                super.run();
                try{
                    sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    Intent i = new Intent(SplashScreen.this,MainActivity.class);
                    startActivity(i);
                    finish();

                }
            }
        };
        thread.start();
    }
}
