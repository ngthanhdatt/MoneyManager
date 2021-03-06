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

import com.example.moneymanager.Database.DatabaseHelper;
import com.example.moneymanager.Model.User;

import java.util.ArrayList;
import java.util.List;
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    private EditText etPassword;
    private Button btnLogin;
    private TextView tvSingup, tvForgotPass;
    DatabaseHelper db;

//    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DatabaseHelper(getBaseContext());

        etPassword = (EditText) findViewById(R.id.etPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        tvSingup = (TextView) findViewById(R.id.tvSignup);


//        FirebaseAuth firebaseAuthentication = FirebaseAuth.getInstance();
//        if(firebaseAuthentication.getCurrentUser() != null){
//            Intent intent = new Intent(Login.this, com.example.moneymanager.MainActivity.class);
//            startActivity(intent);
//            finish();
//        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pass = etPassword.getText().toString().trim();
                if(pass.isEmpty()){
                    Toast.makeText(Login.this, "Mật khẩu không được bỏ trống", Toast.LENGTH_SHORT).show();
                    return;
                } else{
                    Boolean check = db.checkLogin(pass);
                    if(check == false){
                        Toast.makeText(Login.this, "Đăng nhập thất bại, hãy thử lại!!!", Toast.LENGTH_SHORT).show();
//                       Reset();
                    }else {
                        Toast.makeText(Login.this, "Đăng nhập thành công!!!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Login.this, com.example.moneymanager.MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
            }
        });

//        btnLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String email = etEmail.getText().toString().trim();
//                String pass = etPassword.getText().toString().trim();
//
//                if(TextUtils.isEmpty(email)){
//                    Toast.makeText(Login.this, "Please enter valid email", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                if(TextUtils.isEmpty(pass)){
//                    Toast.makeText(Login.this, "Please enter valid pass", Toast.LENGTH_SHORT).show();
//                }
//
//                firebaseAuthentication.signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if(task.isSuccessful()){
//
//                        }else{
//                            Toast.makeText(Login.this, "Login failed!!!", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
//            }
//        });

        tvSingup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, com.example.moneymanager.Registration.class);
                startActivity(intent);
            }
        });
    }
    protected void Reset(){
        etPassword.setText("");
    }
}