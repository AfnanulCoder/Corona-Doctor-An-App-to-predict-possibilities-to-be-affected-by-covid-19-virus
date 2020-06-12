package com.afnanulcoder.coronadoctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Date;

public class ResultActivity extends AppCompatActivity {

    String theLanguage = "English";

    double percentageOfChance;

    TextView youHaveTV, percentageShowTV,chanceTV, stateShowTV, theSuggShowTv, predictionTV;
    ImageView happyFace, normalFace, sadFace;
    Button getReadyButton, whatToDoButton, checkAgainButton, takeScreenShotButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        percentageOfChance = getIntent().getDoubleExtra("percentageOfChance", 0);
        theLanguage = getIntent().getStringExtra("theLanguage");

        DecimalFormat df = new DecimalFormat("0.0");


        youHaveTV = findViewById(R.id.youHaveTvID);
        percentageShowTV = findViewById(R.id.thePercetageShowTvID);
        chanceTV = findViewById(R.id.chanceTVID);
        stateShowTV = findViewById(R.id.theStateShowTvID);
        theSuggShowTv = findViewById(R.id.theSuggShowTvID);
        predictionTV = findViewById(R.id.predictionTvID);

        happyFace = findViewById(R.id.happyFaceID);
        normalFace = findViewById(R.id.normalFaceID);
        sadFace = findViewById(R.id.sadFaceID);

        getReadyButton = findViewById(R.id.getReadyButtonID);
        whatToDoButton = findViewById(R.id.whatToDoButtonID);
        checkAgainButton = findViewById(R.id.checkAgainButtonID);
        takeScreenShotButton = findViewById(R.id.takeScreenShotButtonID);

        percentageShowTV.setText(df.format(percentageOfChance)+"%");

        if(theLanguage.equals("Bangla"))
        {
            youHaveTV.setText("আপনার");
            percentageShowTV.setText(ConvertDecimalDigitToBangla(Double.parseDouble(df.format(percentageOfChance)))+"%");
            chanceTV.setText("সম্ভাবনা রয়েছে করোনা ভাইরাস আক্রান্ত হওয়ার");
            predictionTV.setText("এটা একটি অনুমেয় ফলাফল।\nপরিক্ষিত ফলাফল নয়।");

            getReadyButton.setText("আক্রান্তের পুর্ববর্তি করনিয়");
            whatToDoButton.setText("আক্রান্তের পরবর্তি করনিয়");
            checkAgainButton.setText("আবার যাচাই করুন");
            takeScreenShotButton.setText("Screenshot নিন");
        }

        if(percentageOfChance >= 0 && percentageOfChance <= 29)
        {
            stateShowTV.setTextColor(Color.parseColor("#4CAF50"));

            stateShowTV.setText("It is a MILD chance");
            theSuggShowTv.setText("Don't Panic. Be at Home and 6 feet away from people\nTry to not be infected.");

            if(theLanguage.equals("Bangla"))
            {
                stateShowTV.setText("বেশ কম সম্ভাবনা");
                theSuggShowTv.setText("ভয় পাবেন না। বাসায় থাকুন এবং মানুষ থেকে ৬ ফিট দুরে থাকুন।\nআক্রান্ত না হওয়ার চেষ্টা করুন।");
            }

            happyFace.setVisibility(View.VISIBLE);
        }
        else if(percentageOfChance > 29 && percentageOfChance <= 58)
        {
            stateShowTV.setTextColor(Color.parseColor("#03A9F4"));
            stateShowTV.setText("It is a MEDIUM chance");
            theSuggShowTv.setText("You Must to Be Home Quarantined.\nDrink Liquid, Eat Fruits and Stay Safe.");

            if(theLanguage.equals("Bangla"))
            {
                stateShowTV.setText("মাঝামাঝি সম্ভাবনা");
                theSuggShowTv.setText("আপনাকে অবশ্যই বাসায় Quarantined থাকতে হবে।\nবেশি করে তরল পান করুন, ফল খান ও সাবধানে থাকুন।");
            }

            normalFace.setVisibility(View.VISIBLE);
        }
        else if(percentageOfChance > 58 && percentageOfChance <= 97)
        {
            stateShowTV.setTextColor(Color.parseColor("#E91E63"));
            stateShowTV.setText("It is a SEVERER chance");
            theSuggShowTv.setText("You Must Meet Doctor.\nCall Your Doctor & Take Proper Steps.\nBe Isolated");

            if(theLanguage.equals("Bangla"))
            {
                stateShowTV.setText("বেশ গুরুতর সম্ভাবনা");
                theSuggShowTv.setText("অবশ্যই ডাক্তারের সাথে যোগাযোগ করুন।\nডাক্তারকে Call করুন ও পরিপুর্ণ পদক্ষেপ নিন।\nIsolated আর্থাত্ সম্পুর্ণ আলাদা থাকুন।");
            }

            sadFace.setVisibility(View.VISIBLE);
        }
        else
        {
            percentageShowTV.setText("--%");
            stateShowTV.setText("Sorry!!! SomeThing Went Wrong");
            theSuggShowTv.setText("Please Try Again");

            happyFace.setVisibility(View.VISIBLE);
        }


    }

    private String ConvertDecimalDigitToBangla(double theEnglishNumber)
    {
        String theBanglaNumber = "";
        int reminder = 0;
        int digit1, digit2, digit3;

        digit3 = (int)(theEnglishNumber*10)%10;
        theEnglishNumber = (int)theEnglishNumber;

        digit2 = (int)theEnglishNumber%10;
        theEnglishNumber = (theEnglishNumber-digit2)/10;

        digit1 = (int) theEnglishNumber;

        if(OneToTen(digit1).equals("০"))
        {
            theBanglaNumber = OneToTen(digit2)+"."+OneToTen(digit3);
        }
        else
        {
            theBanglaNumber = OneToTen(digit1)+OneToTen(digit2)+"."+OneToTen(digit3);
        }


        return theBanglaNumber;
    }

    String OneToTen(int reminder)
    {
        if(reminder == 0)
            return "০";
        else if(reminder == 1)
            return "১";
        else if(reminder == 2)
            return "২";
        else if(reminder == 3)
            return "৩";
        else if(reminder == 4)
            return "৪";
        else if(reminder == 5)
            return "৫";
        else if(reminder == 6)
            return "৬";
        else if(reminder == 7)
            return "৭";
        else if(reminder == 8)
            return "৮";
        else if(reminder == 9)
            return "৯";
        else
            return "";
    }

    public void HowToPrevent(View view)
    {
        Intent intent = new Intent(this, HowToPrevent.class);
        intent.putExtra("theLanguage", theLanguage);
        intent.putExtra("percentageOfChance", percentageOfChance);
        startActivity(intent);
    }

    public void HowToGetHelp(View view)
    {
        Intent intent = new Intent(this, HowToGetHelp.class);
        intent.putExtra("theLanguage", theLanguage);
        intent.putExtra("percentageOfChance", percentageOfChance);
        startActivity(intent);
    }

    public void CheckAgain(View view)
    {
        Intent intent = new Intent(this, Questions.class);
        intent.putExtra("theLanguage", theLanguage);
        startActivity(intent);
    }

    public void ScreenShot(View view)
    {
        Date date = new Date();
        CharSequence now = android.text.format.DateFormat.format("yyyy-MM-dd_hh:mm:ss", date);
        String fileName = Environment.getExternalStorageDirectory()+"/CoronaDoctor/"+now+".jpg";

        View root = getWindow().getDecorView();
        root.setDrawingCacheEnabled(true);
        Bitmap bitmap = Bitmap.createBitmap(root.getDrawingCache());
        root.setDrawingCacheEnabled(false);

        File file = new File(fileName);
        file.getParentFile().mkdirs();

        try
        {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();

            Uri uri = Uri.fromFile(file);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(uri, "image/*");
            startActivity(intent);

        }catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }catch (IOException e)
        {
            e.printStackTrace();
        }

        if(theLanguage.equals("Bangla"))
        {
            Toast.makeText(this, "যদি Screenshot ধারন করা না যায়, তবে App info তে গিয়ে permissions Allow করতে হবে।", Toast.LENGTH_LONG).show();
        }else
        {
            Toast.makeText(this, "If Screenshot is not captured, then allow permissions in App info", Toast.LENGTH_LONG).show();
        }

    }


    @Override
    public void onBackPressed() {
        //super.onBackPressed();

        Intent intent = new Intent(this, StartingActivity.class);
        intent.putExtra("theLanguage", theLanguage);
        startActivity(intent);

    }

}
