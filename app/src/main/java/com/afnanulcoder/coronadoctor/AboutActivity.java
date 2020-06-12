package com.afnanulcoder.coronadoctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {

    String theLanguage;

    TextView t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        theLanguage = getIntent().getStringExtra("theLanguage");

        t1 = findViewById(R.id.t1ID);
        t2 = findViewById(R.id.t2ID);
        t3 = findViewById(R.id.t3ID);
        t4 = findViewById(R.id.t4ID);
        t5 = findViewById(R.id.t5ID);
        t6 = findViewById(R.id.t6ID);
        t7 = findViewById(R.id.t7ID);
        t8 = findViewById(R.id.t8ID);
        t9 = findViewById(R.id.t9ID);
        t10 = findViewById(R.id.t10ID);
        t11 = findViewById(R.id.t11ID);
        t12 = findViewById(R.id.t12ID);
        t13 = findViewById(R.id.t13ID);


        if(theLanguage.equals("Bangla"))
        {
            t1.setText("অ্যাপলিকেশনের নাম");
            t2.setText("করোনা ডাক্তার");
            t3.setText("করোনা ডাক্তার একটি মোবাইল অ্যাপলিকেশন যেটা কাজ করে কোভিড-১৯ ভাইরাসের প্রকৃত লক্ষণের উপর ভিত্তি করে। এই অ্যাপলিকোশন শুধুমাত্র একটি অনুমান হিসেব করে। ভয় পাবার কোন কারণ নেই। যদি ভাইরাস আক্রান্ত হওয়ার বেশি সম্ভাবনা দেখায় তবে, প্রদত্ত পদক্ষেপ গ্রহণ করতে হবে।");
            t4.setText("ভার্সন নাম");
            t5.setText("আলফা");
            t6.setText("ভার্সন");
            t7.setText("ভি১.০");
            t8.setText("বানানোর তারিখ");
            t9.setText("২৩ . ০৩ . ২০২০");
            t10.setText("স্বত্ত্বাধিকারি");
            t11.setText("আফনানুলকোডার");
            t12.setText("দেশ");
            t13.setText("বাংলাদেশ");
        }


    }

    public void goToBack(View view)
    {
        Intent intent = new Intent(this, StartingActivity.class);
        intent.putExtra("theLanguage", theLanguage);
        startActivity(intent);
    }
}
