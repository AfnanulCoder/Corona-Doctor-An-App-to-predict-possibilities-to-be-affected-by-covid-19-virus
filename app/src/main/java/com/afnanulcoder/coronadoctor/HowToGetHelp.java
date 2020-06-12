package com.afnanulcoder.coronadoctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

public class HowToGetHelp extends AppCompatActivity {

    String theLanguage;
    double percentageOfChance = 200;
    ImageView w1, w2, w3, w4, w5, w6, w7, w8, w9, w10;

    Handler handler2 = new Handler();
    Runnable runnable2 = new Runnable() {
        @Override
        public void run() {
            w9.setVisibility(View.VISIBLE);
        }
    };

    Handler handler3 = new Handler();
    Runnable runnable3 = new Runnable() {
        @Override
        public void run() {
            w8.setVisibility(View.VISIBLE);
        }
    };

    Handler handler4 = new Handler();
    Runnable runnable4 = new Runnable() {
        @Override
        public void run() {
            w7.setVisibility(View.VISIBLE);
        }
    };

    Handler handler5 = new Handler();
    Runnable runnable5 = new Runnable() {
        @Override
        public void run() {
            w6.setVisibility(View.VISIBLE);
        }
    };

    Handler handler6 = new Handler();
    Runnable runnable6 = new Runnable() {
        @Override
        public void run() {
            w5.setVisibility(View.VISIBLE);
        }
    };

    Handler handler7 = new Handler();
    Runnable runnable7 = new Runnable() {
        @Override
        public void run() {
            w4.setVisibility(View.VISIBLE);
        }
    };

    Handler handler8 = new Handler();
    Runnable runnable8 = new Runnable() {
        @Override
        public void run() {
            w3.setVisibility(View.VISIBLE);
        }
    };

    Handler handler9 = new Handler();
    Runnable runnable9 = new Runnable() {
        @Override
        public void run() {
            w2.setVisibility(View.VISIBLE);
        }
    };

    Handler handler10 = new Handler();
    Runnable runnable10 = new Runnable() {
        @Override
        public void run() {
            w1.setVisibility(View.VISIBLE);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to_get_help);

        theLanguage = getIntent().getStringExtra("theLanguage");
        percentageOfChance = getIntent().getDoubleExtra("percentageOfChance", 200);

        w1 = findViewById(R.id.w1ID);
        w2 = findViewById(R.id.w2ID);
        w3 = findViewById(R.id.w3ID);
        w4 = findViewById(R.id.w4ID);
        w5 = findViewById(R.id.w5ID);
        w6 = findViewById(R.id.w6ID);
        w7 = findViewById(R.id.w7ID);
        w8 = findViewById(R.id.w8ID);
        w9 = findViewById(R.id.w9ID);
        w10 = findViewById(R.id.w10ID);

        if(theLanguage.equals("Bangla"))
        {
            w1.setImageResource(R.drawable.w1_bn);
            w2.setImageResource(R.drawable.w2_bn);
            w3.setImageResource(R.drawable.w3_bn);
            w4.setImageResource(R.drawable.w4_bn);
            w5.setImageResource(R.drawable.w5_bn);
            w6.setImageResource(R.drawable.w6_bn);
            w7.setImageResource(R.drawable.w7_bn);
            w8.setImageResource(R.drawable.w8_bn);
            w9.setImageResource(R.drawable.w9_bn);
            w10.setImageResource(R.drawable.w10_bn);
        }

        handler2.postDelayed(runnable2, 1000);
        handler3.postDelayed(runnable3, 2000);
        handler4.postDelayed(runnable4, 3000);
        handler5.postDelayed(runnable5, 4000);
        handler6.postDelayed(runnable6, 5000);
        handler7.postDelayed(runnable7, 6000);
        handler8.postDelayed(runnable8, 7000);
        handler9.postDelayed(runnable9, 8000);
        handler10.postDelayed(runnable10, 9000);
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
