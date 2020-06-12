package com.afnanulcoder.coronadoctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class WaitingForResult extends AppCompatActivity {


    String theLanguage;

    int valueOfChance = 0;
    double percentageOfChance;
    boolean boyos, jor, shaskosto, thanda, golabetha, bideshVromon, rogirSatheDekha, heartProblem;

    TextView waitingTV;
    ImageView loading1, loading2, loading3, loading4, loading5;


    Handler handler1 = new Handler();
    Runnable runnable1 = new Runnable() {
        @Override
        public void run() {
            loading1.setVisibility(View.VISIBLE);
            loading2.setVisibility(View.INVISIBLE);
            loading3.setVisibility(View.INVISIBLE);
            loading4.setVisibility(View.INVISIBLE);
            loading5.setVisibility(View.INVISIBLE);
        }
    };

    Handler handler2 = new Handler();
    Runnable runnable2 = new Runnable() {
        @Override
        public void run() {
            loading1.setVisibility(View.INVISIBLE);
            loading2.setVisibility(View.VISIBLE);
            loading3.setVisibility(View.INVISIBLE);
            loading4.setVisibility(View.INVISIBLE);
            loading5.setVisibility(View.INVISIBLE);
        }
    };

    Handler handler3 = new Handler();
    Runnable runnable3 = new Runnable() {
        @Override
        public void run() {
            loading1.setVisibility(View.INVISIBLE);
            loading2.setVisibility(View.INVISIBLE);
            loading3.setVisibility(View.VISIBLE);
            loading4.setVisibility(View.INVISIBLE);
            loading5.setVisibility(View.INVISIBLE);
        }
    };

    Handler handler4 = new Handler();
    Runnable runnable4 = new Runnable() {
        @Override
        public void run() {
            loading1.setVisibility(View.INVISIBLE);
            loading2.setVisibility(View.INVISIBLE);
            loading3.setVisibility(View.INVISIBLE);
            loading4.setVisibility(View.VISIBLE);
            loading5.setVisibility(View.INVISIBLE);
        }
    };

    Handler handler5 = new Handler();
    Runnable runnable5 = new Runnable() {
        @Override
        public void run() {
            loading1.setVisibility(View.INVISIBLE);
            loading2.setVisibility(View.INVISIBLE);
            loading3.setVisibility(View.INVISIBLE);
            loading4.setVisibility(View.INVISIBLE);
            loading5.setVisibility(View.VISIBLE);
        }
    };

    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent(WaitingForResult.this, ResultActivity.class);
            intent.putExtra("percentageOfChance", percentageOfChance);
            intent.putExtra("theLanguage", theLanguage);
            startActivity(intent);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiting_for_result);

        theLanguage = getIntent().getStringExtra("theLanguage");
        boyos = getIntent().getBooleanExtra("boyos",false);
        jor = getIntent().getBooleanExtra("jor",false);
        shaskosto = getIntent().getBooleanExtra("shaskosto",false);
        thanda = getIntent().getBooleanExtra("thanda",false);
        golabetha = getIntent().getBooleanExtra("golabetha",false);
        bideshVromon = getIntent().getBooleanExtra("bideshVromon",false);
        rogirSatheDekha = getIntent().getBooleanExtra("rogirSatheDekha",false);
        heartProblem = getIntent().getBooleanExtra("heartProblem",false);

        CalculateResult(boyos, jor, shaskosto, thanda, golabetha, bideshVromon, rogirSatheDekha, heartProblem);

        loading1 = findViewById(R.id.loading1ID);
        loading2 = findViewById(R.id.loading2ID);
        loading3 = findViewById(R.id.loading3ID);
        loading4 = findViewById(R.id.loading4ID);
        loading5 = findViewById(R.id.loading5ID);

        waitingTV = findViewById(R.id.waitingTvID);

        if (theLanguage.equals("Bangla"))
        {
            waitingTV.setText("ফলাফলের জন্য অপেক্ষা");
        }


        handler1.postDelayed(runnable1, 500);
        handler3.postDelayed(runnable2, 1000);
        handler2.postDelayed(runnable3, 1500);
        handler4.postDelayed(runnable4, 2000);
        handler5.postDelayed(runnable5, 2500);

        handler2.postDelayed(runnable1, 3000);
        handler3.postDelayed(runnable2, 3500);
        handler1.postDelayed(runnable3, 4000);
        handler5.postDelayed(runnable4, 4500);
        handler4.postDelayed(runnable5, 5000);

        handler.postDelayed(runnable, 5500);
    }


    void CalculateResult(boolean boyos, boolean jor, boolean shaskosto, boolean thanda, boolean golabetha, boolean bideshVromon, boolean rogirSatheDekha, boolean heartProblem)
    {

        if(jor)
        {
            valueOfChance += 10;
        }

        if(shaskosto)
        {
            valueOfChance += 10;
        }

        if(thanda)
        {
            valueOfChance += 10;
        }

        if(golabetha)
        {
            valueOfChance += 10;
        }

        if(bideshVromon)
        {
            valueOfChance += 20;
        }

        if(rogirSatheDekha)
        {
            valueOfChance += 20;
        }


        if(valueOfChance >= 30)
        {
            if(boyos)
            {
                valueOfChance += 10;
            }

            if(heartProblem)
            {
                valueOfChance += 10;
            }
        }

        percentageOfChance = (valueOfChance*0.97);

    }


    @Override
    public void onBackPressed() {
        //super.onBackPressed();

        Toast.makeText(this, "Application Working", Toast.LENGTH_SHORT).show();

    }

}
