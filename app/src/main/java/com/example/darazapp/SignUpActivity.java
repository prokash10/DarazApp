package com.example.darazapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class SignUpActivity extends AppCompatActivity {

    EditText phoneno,Sms;
    Button btnnext, btnsend;
    TextView tvl;
    int min=1;
    int max=100000;
    Random r=new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        phoneno = findViewById(R.id.etNo);
        btnnext = findViewById(R.id.btnNext);
        tvl = findViewById(R.id.tvL);
        Sms = findViewById(R.id.etsms);
        btnsend = findViewById(R.id.button2);

        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(phoneno.getText().toString()))
                {
                    phoneno.setError("Mandatory Field");
                    return;
                }
                Thread thread = new Thread(){
                    @Override
                    public void run() {
                        try {
                            sleep(1000);
                            int I1 = r.nextInt(max - min + 1) + min;
                            Sms.setText(Integer.toString(I1));
                        }   catch (InterruptedException e)
                        {
                            e.printStackTrace();
                        }
                    }
                };
                thread.start();
            }
        });

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(phoneno.getText().toString()))
                {
                    phoneno.setError("Mandatory Field");
                    return;
                }
                else if (TextUtils.isEmpty(Sms.getText().toString())){
                    Sms.setError("Mandatory Field");
                    return;
                }
                Intent intent = new Intent(SignUpActivity.this, SignUpEmailActivity.class);
                String No = phoneno.getText().toString();
                String sms = Sms.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("PhoneNo", No);
                bundle.putString("SMS", sms);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        tvl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}

