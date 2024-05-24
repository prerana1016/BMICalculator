package com.example.myfirstapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {


    TextView mcurrentheight;
    TextView mcurrentweight,mcurrentage;
    ImageView mincrementage,mdecrementage,mincrementweight,mdecrementweight;
    SeekBar mseekbarforheight;
    Button mcalculatebmi;
    RelativeLayout mmale,mfemale;

    int intweight=55;
    int intage=22;
    int currentprogress;
    String mintprogress="170";
    String typerofuser="0";
    String weight2="55";
    String age2="22";

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Objects.requireNonNull(getSupportActionBar()).hide();
        mcurrentage=findViewById(R.id.currentage);
        mcurrentweight=findViewById(R.id.currentweight);
        mcurrentheight=findViewById(R.id.currentheight);
        mincrementage=findViewById(R.id.incrementage);
        mdecrementage=findViewById(R.id.decrementage);
        mincrementweight=findViewById(R.id.incremetweight);
        mdecrementweight=findViewById(R.id.decrementweight);
        mcalculatebmi=findViewById(R.id.calculatebmi);
        mseekbarforheight=findViewById(R.id.seekbarforheight);
        mmale=findViewById(R.id.male);
        mfemale=findViewById(R.id.female);



        mmale.setOnClickListener(v -> {
            mmale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefocus));
            mfemale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalenotfocus));
            typerofuser="Male";

        });


        mfemale.setOnClickListener(v -> {
            mfemale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefocus));
            mmale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalenotfocus));
            typerofuser="Female";
        });

        mseekbarforheight.setMax(300);
        mseekbarforheight.setProgress(170);
        mseekbarforheight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                currentprogress=progress;
                mintprogress=String.valueOf(currentprogress);
                mcurrentheight.setText(mintprogress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        mincrementweight.setOnClickListener(v -> {
            intweight=intweight+1;
            weight2=String.valueOf(intweight);
            mcurrentweight.setText(weight2);
        });

        mincrementage.setOnClickListener(v -> {
            intage=intage+1;
            age2=String.valueOf(intage);
            mcurrentage.setText(age2);
        });


        mdecrementage.setOnClickListener(v -> {
            intage=intage-1;
            age2=String.valueOf(intage);
            mcurrentage.setText(age2);
        });


        mdecrementweight.setOnClickListener(v -> {

            intweight=intweight-1;
            weight2=String.valueOf(intweight);
            mcurrentweight.setText(weight2);
        });



        mcalculatebmi.setOnClickListener(v -> {

            if(typerofuser.equals("0"))
            {
                Toast.makeText(getApplicationContext(),"Select Your Gender First",Toast.LENGTH_SHORT).show();
            }
            else if(mintprogress.equals("0"))
            {
                Toast.makeText(getApplicationContext(),"Select Your Height First",Toast.LENGTH_SHORT).show();
            }
            else if(intage==0 || intage<0)
            {
                Toast.makeText(getApplicationContext(),"Age is Incorrect",Toast.LENGTH_SHORT).show();
            }

            else if(intweight==0|| intweight<0)
            {
                Toast.makeText(getApplicationContext(),"Weight Is Incorrect",Toast.LENGTH_SHORT).show();
            }
            else {

                Intent intent = new Intent(MainActivity.this, bmiactivity.class);
                intent.putExtra("gender", typerofuser);
                intent.putExtra("height", mintprogress);
                intent.putExtra("weight", weight2);
                intent.putExtra("age", age2);
                startActivity(intent);

            }


        });


    }
}