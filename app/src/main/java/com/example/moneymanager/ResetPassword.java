package com.example.moneymanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.moneymanager.Fragment.CaiDatFragment;

public class ResetPassword extends AppCompatActivity {

    private EditText etPass, etRepass;
    private Button btnResetPass, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        etPass = findViewById(R.id.etNewPassword);
        etRepass = findViewById(R.id.etReNewPassword);
        btnResetPass = findViewById(R.id.btnResetPass);
        back = findViewById(R.id.frag_Toolbar_matkhau_back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResetPassword.this, CaiDatFragment.class);
                startActivity(intent);
            }
        });
    }
}