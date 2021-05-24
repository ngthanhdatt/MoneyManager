package com.example.moneymanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.moneymanager.Database.DatabaseHelper;
import com.example.moneymanager.Model.ViTien;

public class Them_ViTien extends AppCompatActivity {

    private Button btnback, btnluu;
    private EditText etLoaivi, etSotien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_vi_tien);

        DatabaseHelper db = new DatabaseHelper(getBaseContext());

        btnback = findViewById(R.id.frag_Toolbar_ThemViTien_back);
        btnback.setText("Thêm Ví Tiền");
        btnluu = findViewById(R.id.button_themvitien);
        etLoaivi = findViewById(R.id.editText_loaivi);
        etSotien = findViewById(R.id.editText_sotienvi);
        //Intent intent=getIntent();
        //String id = intent.getStringExtra("userId1");

        btnluu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etLoaivi.getText().toString().isEmpty() || etSotien.getText().toString().isEmpty()) {
                    Toast.makeText(Them_ViTien.this, "Hãy nhập đủ các mục tên ví,só tiền", Toast.LENGTH_SHORT).show();
                }
                else {
                    String loai = etLoaivi.getText().toString();
                    int money = Integer.parseInt(etSotien.getText().toString());

                    ViTien viTien1 = new ViTien(loai, money);
                    db.addViTien(viTien1);
                    Toast.makeText(Them_ViTien.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                    etLoaivi.setText("");
                    etSotien.setText("");
                }
            }
        });


        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                intent.putExtra("classFrom", Them_ViTien.class.toString());
                v.getContext().startActivity(intent);
            }
        });
    }
}