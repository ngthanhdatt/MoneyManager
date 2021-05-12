package com.example.moneymanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Them_ViTien extends AppCompatActivity {

    private Button btnback, btnluu;
    private EditText etLoaivi, etSotien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_vi_tien);

        btnback = findViewById(R.id.frag_Toolbar_ThemViTien_back);
        btnback.setText("Thêm Ví Tiền");
        btnluu = findViewById(R.id.button_themvitien);
        etLoaivi = findViewById(R.id.editText_loaivi);
        etSotien = findViewById(R.id.editText_sotienvi);

        btnluu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String loaivi = etLoaivi.getText().toString().trim();
                String sotien = etSotien.getText().toString().trim();
                int intsotien = Integer.parseInt(sotien);
                if(loaivi.isEmpty()){
                    Toast.makeText(Them_ViTien.this, "Mục ví tiền không được bỏ trống", Toast.LENGTH_SHORT).show();
                }if (sotien.isEmpty()){
                    Toast.makeText(Them_ViTien.this, "Mục số tiền không được bỏ trống", Toast.LENGTH_SHORT).show();
                }else{

                }
            }
        });

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Them_ViTien.this, com.example.moneymanager.MainActivity.class);
                startActivity(intent);
            }
        });
    }
}