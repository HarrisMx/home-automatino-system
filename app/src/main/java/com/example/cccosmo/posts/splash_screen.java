package com.example.cccosmo.posts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class splash_screen extends AppCompatActivity {
    private ImageView iv;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_splash_screen );

        iv = (ImageView) findViewById(R.id.house);
        tv = (TextView) findViewById ( R.id.text );


        Animation myanim = AnimationUtils.loadAnimation( this, R.anim.mytransition);

        iv.startAnimation(myanim);
        tv.startAnimation ( myanim );
        final Intent i = new Intent ( splash_screen.this, login.class);

        Thread timer = new Thread()
        {
            public void run()
            {
                try{
                    sleep(4000);


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {


                    startActivity(i);
                    finish();
                }
            }

        };
        timer.start();
    }
}
