package com.example.moneymanager.Fragment.ViTien;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.moneymanager.Database.DatabaseHelper;
import com.example.moneymanager.MainActivity;
import com.example.moneymanager.Model.ViTien;
import com.example.moneymanager.R;

public class Edit_ViTien extends AppCompatActivity {

    private Button btnback, btnluu, btnXoa;
    private EditText etLoaivi, etSotien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_vi_tien);

        DatabaseHelper db = new DatabaseHelper(getBaseContext());
        btnback = findViewById(R.id.frag_Toolbar_SuaViTien_back);
        btnback.setText("Sửa Ví Tiền");
        btnluu = findViewById(R.id.button_sua_vitien);
        etLoaivi = findViewById(R.id.editText_sua_loaivi);
        etSotien = findViewById(R.id.editText_sua_sotienvi);
        btnXoa = findViewById(R.id.button_xoa_vitien);

        Intent intent = getIntent();
//        String loaivi = intent.getStringExtra("title");
//        String money = intent.getStringExtra("content");
        ViTien viTien = (ViTien) intent.getSerializableExtra("vi");
//        etLoaivi.setText(viTien.getName());
//        etSotien.setText(viTien.getMoney());

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.deleteViTien(viTien);
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                v.getContext().startActivity(intent);
            }
        });


        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                v.getContext().startActivity(intent);
            }
        });
    }
}