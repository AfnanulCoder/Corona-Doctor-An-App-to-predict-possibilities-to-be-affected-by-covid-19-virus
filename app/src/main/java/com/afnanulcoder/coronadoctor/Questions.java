package com.afnanulcoder.coronadoctor;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Questions extends AppCompatActivity {

    String theLanguage = "English";
    String toastString = "Please Enter Answer Correctly";

    LinearLayout qsn1Layout, qsn2Layout,qsn3Layout, qsn4Layout, qsn5Layout, qsn6Layout, qsn7Layout, qsn8Layout;
    int numberOfVisibleQuestions = 1;

    TextView qsn1, qsn2, qsn3, qsn4, qsn5, qsn6, qsn7, qsn8;
    EditText qsn1answer;
    RadioButton qsn2answerYes, qsn2answerNo, qsn3answerYes, qsn3answerNo, qsn4answerYes, qsn4answerNo, qsn5answerYes, qsn5answerNo, qsn6answerYes, qsn6answerNo, qsn7answerYes, qsn7answerNo, qsn8answerYes, qsn8answerNo;
    boolean boyos = false, jor = false, shaskosto = false, thanda = false, golabetha = false, bideshVromon = false, rogirSatheDekha = false, heartProblem = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        theLanguage = getIntent().getStringExtra("theLanguage");

        qsn1 = findViewById(R.id.qsn1ID);
        qsn2 = findViewById(R.id.qsn2ID);
        qsn3 = findViewById(R.id.qsn3ID);
        qsn4 = findViewById(R.id.qsn4ID);
        qsn5 = findViewById(R.id.qsn5ID);
        qsn6 = findViewById(R.id.qsn6ID);
        qsn7 = findViewById(R.id.qsn7ID);
        qsn8 = findViewById(R.id.qsn8ID);

        qsn1answer = findViewById(R.id.qsn1AnswerID);

        qsn2answerYes = findViewById(R.id.qsn2AnswerYesID);
        qsn2answerNo = findViewById(R.id.qsn2AnswerNoID);

        qsn3answerYes = findViewById(R.id.qsn3AnswerYesID);
        qsn3answerNo = findViewById(R.id.qsn3AnswerNoID);

        qsn4answerYes = findViewById(R.id.qsn4AnswerYesID);
        qsn4answerNo = findViewById(R.id.qsn4AnswerNoID);

        qsn5answerYes = findViewById(R.id.qsn5AnswerYesID);
        qsn5answerNo = findViewById(R.id.qsn5AnswerNoID);

        qsn6answerYes = findViewById(R.id.qsn6AnswerYesID);
        qsn6answerNo = findViewById(R.id.qsn6AnswerNoID);

        qsn7answerYes = findViewById(R.id.qsn7AnswerYesID);
        qsn7answerNo = findViewById(R.id.qsn7AnswerNoID);

        qsn8answerYes = findViewById(R.id.qsn8AnswerYesID);
        qsn8answerNo = findViewById(R.id.qsn8AnswerNoID);



        qsn1Layout = findViewById(R.id.qsn1LayoutID);
        qsn2Layout = findViewById(R.id.qsn2LayoutID);
        qsn3Layout = findViewById(R.id.qsn3LayoutID);
        qsn4Layout = findViewById(R.id.qsn4LayoutID);
        qsn5Layout = findViewById(R.id.qsn5LayoutID);
        qsn6Layout = findViewById(R.id.qsn6LayoutID);
        qsn7Layout = findViewById(R.id.qsn7LayoutID);
        qsn8Layout = findViewById(R.id.qsn8LayoutID);


        if(theLanguage.equals("Bangla"))
        {
            qsn1.setText("আপনার বয়স কত?");
            qsn2.setText("আপনার কি জ্বর আছে?");
            qsn3.setText("আপনার কি শ্বাসকষ্ট আছে?");
            qsn4.setText("আপনার কি সর্দি-কাশি আছে?");
            qsn5.setText("আপনার কি গলাব্যাথা আছে বা গিলতে কষ্ট হয়?");
            qsn6.setText("আপনি কি গত ২০ দিনে বিদেশ থেকে এসেছেন?");
            qsn7.setText("আপনার কি কোন কোভিড-১৯ আক্রান্ত রোগির কাছে অথবা বিদেশ ভ্রমনকারীর কাছে গিয়েছিলেন?");
            qsn8.setText("আপনার কি কোন ডায়াবেটিস অথবা হ্মদরোগের ইতিহাস আছে?");
            toastString = "দয়া করে সঠিকভাবে উত্তর দিন";

            qsn2answerYes.setText("হ্যা             ");
            qsn2answerNo.setText("না");

            qsn3answerYes.setText("হ্যা             ");
            qsn3answerNo.setText("না");

            qsn4answerYes.setText("হ্যা             ");
            qsn4answerNo.setText("না");

            qsn5answerYes.setText("হ্যা             ");
            qsn5answerNo.setText("না");

            qsn6answerYes.setText("হ্যা             ");
            qsn6answerNo.setText("না");

            qsn7answerYes.setText("হ্যা             ");
            qsn7answerNo.setText("না");

            qsn8answerYes.setText("হ্যা             ");
            qsn8answerNo.setText("না");

        }

    }

    public void NextQuestionButton(View view)
    {
        switch (numberOfVisibleQuestions)
        {
            case 1:
                String answer1 = qsn1answer.getText().toString();
                if(answer1.equals(""))
                    Toast.makeText(this, toastString, Toast.LENGTH_SHORT).show();
                else
                {
                    int age = Integer.parseInt(answer1);
                    if(age > 120 || age <0)
                    {
                        if(theLanguage.equals("Bangla"))
                        {
                            Toast.makeText(this, "দয়া করে সঠিক বয়স দিন", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(this, "Please enter valid age", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        boyos = age >= 40;
                        qsn2Layout.setVisibility(View.VISIBLE);
                        numberOfVisibleQuestions++;
                    }

                }

                break;
            case 2:
                if(qsn2answerYes.isChecked() || qsn2answerNo.isChecked())
                {
                    jor = qsn2answerYes.isChecked();

                    qsn3Layout.setVisibility(View.VISIBLE);
                    numberOfVisibleQuestions++;
                }
                else
                {
                    Toast.makeText(this, toastString, Toast.LENGTH_SHORT).show();
                }

                break;
            case 3:
                if(qsn3answerYes.isChecked() || qsn3answerNo.isChecked())
                {
                    shaskosto = qsn3answerYes.isChecked();

                    qsn4Layout.setVisibility(View.VISIBLE);
                    numberOfVisibleQuestions++;
                }
                else
                {
                    Toast.makeText(this, toastString, Toast.LENGTH_SHORT).show();
                }

                break;
            case 4:
                if(qsn4answerYes.isChecked() || qsn4answerNo.isChecked())
                {
                    thanda = qsn4answerYes.isChecked();

                    qsn5Layout.setVisibility(View.VISIBLE);
                    numberOfVisibleQuestions++;
                }
                else
                {
                    Toast.makeText(this, toastString, Toast.LENGTH_SHORT).show();
                }

                break;
            case 5:
                if(qsn5answerYes.isChecked() || qsn5answerNo.isChecked())
                {
                    golabetha = qsn5answerYes.isChecked();

                    qsn6Layout.setVisibility(View.VISIBLE);
                    numberOfVisibleQuestions++;
                }
                else
                {
                    Toast.makeText(this, toastString, Toast.LENGTH_SHORT).show();
                }

                break;
            case 6:
                if(qsn6answerYes.isChecked() || qsn6answerNo.isChecked())
                {
                    bideshVromon = qsn6answerYes.isChecked();

                    qsn7Layout.setVisibility(View.VISIBLE);
                    numberOfVisibleQuestions++;
                }
                else
                {
                    Toast.makeText(this, toastString, Toast.LENGTH_SHORT).show();
                }

                break;
            case 7:
                if(qsn7answerYes.isChecked() || qsn7answerNo.isChecked())
                {
                    rogirSatheDekha = qsn7answerYes.isChecked();

                    qsn8Layout.setVisibility(View.VISIBLE);
                    numberOfVisibleQuestions++;
                }
                else
                {
                    Toast.makeText(this, toastString, Toast.LENGTH_SHORT).show();
                }

                break;
            default:
                if(qsn8answerYes.isChecked() || qsn8answerNo.isChecked())
                {
                    heartProblem = qsn8answerYes.isChecked();

                    Intent intent = new Intent(this, WaitingForResult.class);

                    intent.putExtra("boyos", boyos);
                    intent.putExtra("jor", jor);
                    intent.putExtra("shaskosto", shaskosto);
                    intent.putExtra("thanda", thanda);
                    intent.putExtra("golabetha", golabetha);
                    intent.putExtra("bideshVromon", bideshVromon);
                    intent.putExtra("rogirSatheDekha", rogirSatheDekha);
                    intent.putExtra("heartProblem", heartProblem);
                    intent.putExtra("theLanguage", theLanguage);

                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(this, toastString, Toast.LENGTH_SHORT).show();
                }

        }
    }

    public void WhatIsIt1(View view)
    {

        if(theLanguage.equals("Bangla"))
        {
            OpenActionDialogue("কত বছর এই পৃথিবীতে আছেম? করোনা ভাইরাসের সম্ভাবনা অনুমান করতে বয়স খুব গুরুত্বপূর্ণ বিষয়।");
        }
        else
        {
            OpenActionDialogue("How Long Have You Been on Earth\nAge will play a vital role to detect Corona.");
        }
    }

    public void WhatIsIt2(View view)
    {

        if(theLanguage.equals("Bangla"))
        {
            OpenActionDialogue("আপনার শরীরের তাপমাত্রা কি ৩৭°সে বা ৯৮°ফা এর চেয়ে বেশি?");
        }
        else
        {
            OpenActionDialogue("Is Your Body Temperature is more than 37°C or 98°F ?");
        }
    }

    public void WhatIsIt3(View view)
    {

        if(theLanguage.equals("Bangla"))
        {
            OpenActionDialogue("আপনার কি শ্বাস-প্রশ্বাসে কষ্ট হয়? বারবার শ্বাস নিতে অনেক পরিশ্রম অনুভুত হয়।");
        }
        else
        {
            OpenActionDialogue("Do you feel harder to take a breath?\nIt feels like you need rest from taking breath in continuous.");
        }
    }

    public void WhatIsIt4(View view)
    {

        if(theLanguage.equals("Bangla"))
        {
            OpenActionDialogue("আপনার কি কাশির সাথে কফ আসে? ঠান্ডা লেগে নাক দিয়ে পানি পরে?");
        }
        else
        {
            OpenActionDialogue("Do you have a cough with a cold? Do you have a runny nose?");
        }
    }

    public void WhatIsIt5(View view)
    {

        if(theLanguage.equals("Bangla"))
        {
            OpenActionDialogue("গলা ব্যাথা বলতে বুঝায় গলায় হালকা ব্যাথা। গিলতে গেলে বেশি কষ্ট অনুভুত হয়?");
        }
        else
        {
            OpenActionDialogue("Sore throat means a continuous mild pain in the throat.\nIt feels much while swallowing.");
        }
    }

    public void WhatIsIt6(View view)
    {

        if(theLanguage.equals("Bangla"))
        {
            OpenActionDialogue("১৪ দিন হলো করোনা ভাইরাসের ঘুমন্ত সময়। আপনি কোন করোনা ভাইরাসের বাহক হতেও পারেন। তাই আপনি দেশের বাহির থেকে এসেছেন কিনা জানা জরুরি।");
        }
        else
        {
            OpenActionDialogue("20 days is the sleeping time of the corona virus. You may be a carrier of a sleeping virus. So, did you come from somewhere outside of your country?");
        }
    }

    public void WhatIsIt7(View view)
    {

        if(theLanguage.equals("Bangla"))
        {
            OpenActionDialogue("নভেল করোনা (কভিড-১৯) শরীর থেকে শরীরে সহজে ছড়াতে পারে। তাই আপনি যদি কোন আক্রান্ত ব্যাক্তির সম্মিকটে আসেন সেটা বিপদজনক। তাই আপনি কি কোন আক্রান্ত ব্যাক্তির সম্মিকটে এসেছেন? বিদেশ ফেরত কোন ব্যাক্তি যদি অন্তত ১৪ দিন Quarantined থাকেন নাই, এমন কোন ব্যাক্তির সন্নিকটে এসেছেন কি?");
        }
        else
        {
            OpenActionDialogue("Noble Corona(COVID-19) may spread out from body to body because of coming close to any infected person. So did you come close to any infected person?\n" +
                    "Anyone who came from overseas may be a carrier of virus. Did you met someone like this who was not quarantined for 20 days at least?");
        }
    }

    public void WhatIsIt8(View view)
    {

        if(theLanguage.equals("Bangla"))
        {
            OpenActionDialogue("আপনার কি হ্মদরোগ বা ডায়াবেটিসের সমস্যা আছে?  এই ধরনের রোগ দীর্ঘকালীন হলে সেটা বিপদজনক।");
        }
        else
        {
            OpenActionDialogue("Do you have any history of diabetes or heart diseases?");
        }
    }


    private void OpenActionDialogue(String msg)
    {
        final AlertDialog.Builder alert = new AlertDialog.Builder(Questions.this);

        if(theLanguage.equals("Bangla"))
        {
            alert.setTitle("প্রশ্নের ব্যাখা")
                    .setMessage(msg)
                    .setIcon(R.drawable.what_is_it);
        }
        else
        {
            alert.setTitle("What Is It?")
                    .setMessage(msg)
                    .setIcon(R.drawable.what_is_it);
        }

        AlertDialog alertDialog = alert.create();
        alertDialog.show();
    }


    @Override
    public void onBackPressed() {
        //super.onBackPressed();

        Intent intent = new Intent(this, StartingActivity.class);
        intent.putExtra("theLanguage", theLanguage);
        startActivity(intent);

    }

}
