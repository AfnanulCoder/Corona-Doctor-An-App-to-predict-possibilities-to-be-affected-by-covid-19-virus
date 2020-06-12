package com.afnanulcoder.coronadoctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;


public class HowToPrevent extends AppCompatActivity {

    String theLanguage = "English";
    double percentageOfChance = 200;

    ImageView p1, p2, p3, p4, p5, p6, p7, p8;

    Handler handler2 = new Handler();
    Runnable runnable2 = new Runnable() {
        @Override
        public void run() {
            p7.setVisibility(View.VISIBLE);
        }
    };

    Handler handler3 = new Handler();
    Runnable runnable3 = new Runnable() {
        @Override
        public void run() {
            p6.setVisibility(View.VISIBLE);
        }
    };

    Handler handler4 = new Handler();
    Runnable runnable4 = new Runnable() {
        @Override
        public void run() {
            p5.setVisibility(View.VISIBLE);
        }
    };

    Handler handler5 = new Handler();
    Runnable runnable5 = new Runnable() {
        @Override
        public void run() {
            p4.setVisibility(View.VISIBLE);
        }
    };

    Handler handler6 = new Handler();
    Runnable runnable6 = new Runnable() {
        @Override
        public void run() {
            p3.setVisibility(View.VISIBLE);
        }
    };

    Handler handler7 = new Handler();
    Runnable runnable7 = new Runnable() {
        @Override
        public void run() {
            p2.setVisibility(View.VISIBLE);
        }
    };

    Handler handler8 = new Handler();
    Runnable runnable8 = new Runnable() {
        @Override
        public void run() {
            p1.setVisibility(View.VISIBLE);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to_prevent);

        theLanguage = getIntent().getStringExtra("theLanguage");
        percentageOfChance = getIntent().getDoubleExtra("percentageOfChance", 200);

        p1 = findViewById(R.id.p1ID);
        p2 = findViewById(R.id.p2ID);
        p3 = findViewById(R.id.p3ID);
        p4 = findViewById(R.id.p4ID);
        p5 = findViewById(R.id.p5ID);
        p6 = findViewById(R.id.p6ID);
        p7 = findViewById(R.id.p7ID);
        p8 = findViewById(R.id.p8ID);


        if(theLanguage.equals("Bangla"))
        {
            p1.setImageResource(R.drawable.p1_bn);
            p2.setImageResource(R.drawable.p2_bn);
            p3.setImageResource(R.drawable.p3_bn);
            p4.setImageResource(R.drawable.p4_bn);
            p5.setImageResource(R.drawable.p5_bn);
            p6.setImageResource(R.drawable.p6_bn);
            p7.setImageResource(R.drawable.p7_bn);
            p8.setImageResource(R.drawable.p8_bn);
        }



        handler2.postDelayed(runnable2, 1000);
        handler3.postDelayed(runnable3, 2000);
        handler4.postDelayed(runnable4, 3000);
        handler5.postDelayed(runnable5, 4000);
        handler6.postDelayed(runnable6, 5000);
        handler7.postDelayed(runnable7, 6000);
        handler8.postDelayed(runnable8, 7000);

    }


    @Override
    public void onBackPressed() {
        //super.onBackPressed();

        if(percentageOfChance<100)
        {
            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra("percentageOfChance", percentageOfChance);
            intent.putExtra("theLanguage", theLanguage);
            startActivity(intent);
        }
        else
        {
            Intent intent = new Intent(this, StartingActivity.class);
            intent.putExtra("theLanguage", theLanguage);
            startActivity(intent);
        }



    }

}
