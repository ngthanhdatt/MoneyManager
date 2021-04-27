package com.example.moneymanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Registration extends AppCompatActivity {

    private EditText reg_etName, reg_etEmail, reg_etPassword;
    private Button btnSignup;
    private TextView tvLogin;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        mAuth = FirebaseAuth.getInstance();

        reg_etName = (EditText)findViewById(R.id.reg_etName);
        reg_etEmail = (EditText)findViewById(R.id.reg_etEmail);
        reg_etPassword = (EditText)findViewById(R.id.reg_etPassword);
        btnSignup = (Button) findViewById(R.id.btnSignup);
        tvLogin = (TextView) findViewById(R.id.tvLogin);


        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String reg_email = reg_etEmail.getText().toString().trim();
                String reg_pass = reg_etPassword.getText().toString().trim();

                if(reg_email.isEmpty()){
                    Toast.makeText(Registration.this, "Please enter valid email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(reg_pass.isEmpty()){
                    Toast.makeText(Registration.this, "Please enter valid pass", Toast.LENGTH_SHORT).show();
                    return;
                }

                mAuth.createUserWithEmailAndPassword(reg_email, reg_pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                            Toast.makeText(Registration.this, "Registered Successfully!! ", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Registration.this, com.example.moneymanager.Login.class);
                        }else{
                            Toast.makeText(Registration.this, "Registation failed!!", Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }

                    private void updateUI(FirebaseUser user) {
                    }
                });
           }
        });


        // have account? Login
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Registration.this, com.example.moneymanager.Login.class);
                startActivity(intent);
            }
        });

    }
}

