package com.example.eproject_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //varaibles
    Animation topanim,bottomanim;
    ImageView image;
    TextView logo,slogan;


        Thread background =new Thread(){
            public void run(){
                try{
                    //thread will sleep for 5 sec
                    sleep(3000);
                    //after 5 second redireect it another intent
                    Intent i = new Intent(getBaseContext(),account1.class);
                    startActivity( i );

                    //delete activity
                    finish();
                }
                catch(Exception ex){
//                    Toast.makeText(MainActivity.this, ""+ex.getMessage(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, account1.class);
                    startActivity(intent);

                }
            }
        };

        //automation
        background.start();

        //Animation
        topanim= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomanim= AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        image=findViewById(R.id.imageView);
        logo=findViewById(R.id.textView);
        slogan=findViewById(R.id.textView2);

        image.setAnimation(topanim);
        logo.setAnimation(bottomanim);
        slogan.setAnimation(bottomanim);

    }
}