package com.example.moneymanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Init extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init);

        boolean b=new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Init.this, MainActivity.class);
                intent.putExtra("classFrom", Init.class.toString());
                startActivity(intent);
                finish();
            }
        },100);
    }
}
