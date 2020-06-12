package com.afnanulcoder.coronadoctor;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class StartingActivity extends AppCompatActivity {


    String theLanguage = "English";
    Button saveDataOnline;
    Button about;
    Button changeLanguage;
    Button stayStressFree;
    Button getReadyButton, whatToDoButton;

    Spinner languageSpinner;

    ImageView checkYourself;

    String[] languages = new String[]{"Select Language", "বাংলা", "English"};

    AlertDialog alertDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting);

        theLanguage = getIntent().getStringExtra("theLanguage");

        checkYourself = findViewById(R.id.checkYourselfID);
        getReadyButton = findViewById(R.id.getReadyButtonID);
        whatToDoButton = findViewById(R.id.whatToDoButtonID);
        stayStressFree = findViewById(R.id.stayStressFreeID);

        if(theLanguage.equals("Bangla"))
        {
            checkYourself.setImageResource(R.drawable.check_yourself_bn);
            getReadyButton.setText("আক্রান্তের পুর্ববর্তি করনিয়");
            whatToDoButton.setText("আক্রান্তের পরবর্তি করনিয়");
            stayStressFree.setText("চিন্তা মুক্ত থাকুন");
        }


    }

    public void CheckYourselfButton(View view)
    {
        Intent intent = new Intent(this, Questions.class);
        intent.putExtra("theLanguage", theLanguage);
        startActivity(intent);
    }

    public void OptionsButton(View view)
    {
        final AlertDialog.Builder alert = new AlertDialog.Builder(StartingActivity.this);

        View myView = getLayoutInflater().inflate(R.layout.options_sample_view, null);


        saveDataOnline = myView.findViewById(R.id.saveDataOnlineID);
        about = myView.findViewById(R.id.aboutID);
        changeLanguage = myView.findViewById(R.id.changeLanguageID);

        if(theLanguage.equals("Bangla"))
        {
            saveDataOnline.setText("ডাটা অমলাইনে সংরক্ষণ করুন");
            about.setText("তথ্যাবলী");
            changeLanguage.setText("ভাষা পরিবর্তন");

        }

        languageSpinner = myView.findViewById(R.id.languageSpinnerID);
        alert.setView(myView);

        alertDialog = alert.create();

        alertDialog.show();
    }

    public void SaveDataOnline(View view)
    {
        Toast.makeText(this, "saveData", Toast.LENGTH_SHORT).show();
    }

    public void ChangeLanguage(View view)
    {
        if (changeLanguage.getText().toString().equals("Change Language") || changeLanguage.getText().toString().equals("ভাষা পরিবর্তন"))
        {
            languageSpinner.setVisibility(View.VISIBLE);
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.spinner_sample_view,R.id.spinnerTextViewID, languages);
            languageSpinner.setAdapter(arrayAdapter);

            changeLanguage.setText("Select Language");
            if(theLanguage.equals("Bangla"))
            {
                changeLanguage.setText("ভাষা নির্বাচন");
            }

        }
        else {

            if(languageSpinner.getSelectedItem().toString().equals("Select Language"))
            {
                if(theLanguage.equals("Bangla"))
                {
                    Toast.makeText(this, "দয়া করে একটি ভাষা নির্বাচন করুন", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(this, "Select a language, Please", Toast.LENGTH_SHORT).show();
                }

            }
            else {
                theLanguage =  languageSpinner.getSelectedItem().toString();
                if(theLanguage.equals("বাংলা"))
                {
                    theLanguage = "Bangla";
                }
                Intent intent = new Intent(this, StartingActivity.class);
                intent.putExtra("theLanguage", theLanguage);
                startActivity(intent);
            }


        }

    }

    public void HowToPrevent(View view)
    {
        Intent intent = new Intent(this, BeforeSickness.class);
        intent.putExtra("theLanguage", theLanguage);
        intent.putExtra("percentageOfChance", 200);
        startActivity(intent);
    }

    public void HowToGetHelp(View view)
    {
        Intent intent = new Intent(this, HowToGetHelp.class);
        intent.putExtra("theLanguage", theLanguage);
        intent.putExtra("percentageOfChance", 200);
        startActivity(intent);
    }

    public void GoToAbout(View view)
    {
        alertDialog.dismiss();

        Intent intent = new Intent(this, AboutActivity.class);
        intent.putExtra("theLanguage", theLanguage);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();

        /*Intent intent = new Intent(this, StartingActivity.class);
        intent.putExtra("theLanguage", theLanguage);
        startActivity(intent);

         */
        finish();

    }


    public void StayStressFree(View view)
    {
        startActivity(new Intent(this, ConnectFour_1.class));
    }
}
