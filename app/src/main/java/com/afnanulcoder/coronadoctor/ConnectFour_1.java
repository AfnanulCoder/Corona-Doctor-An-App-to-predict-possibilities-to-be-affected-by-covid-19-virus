package com.afnanulcoder.coronadoctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;

public class ConnectFour_1 extends AppCompatActivity {

    Handler handler = new Handler();
    LinearLayout choiceLayout;



    Runnable runnable = new Runnable() {
        @Override
        public void run() {

            choiceLayout.setVisibility(View.VISIBLE);
        }
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect_four_1);

        choiceLayout = findViewById(R.id.choiceLayoutID);
        handler.postDelayed(runnable, 1500);
    }

    public void human(View view)
    {
        Intent intent = new Intent(ConnectFour_1.this, ConnectFour_2.class);
        intent.putExtra("choice", 2);
        startActivity(intent);
    }

    public void computer(View view)
    {
        Intent intent = new Intent(ConnectFour_1.this, ConnectFour_2.class);
        intent.putExtra("choice", 1);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ConnectFour_1.this, StartingActivity.class);
        intent.putExtra("theLanguage", "English");
        startActivity(intent);
    }
}
