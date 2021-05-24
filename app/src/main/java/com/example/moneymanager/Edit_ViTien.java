package com.example.moneymanager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.moneymanager.Database.DatabaseHelper;
import com.example.moneymanager.Model.ViTien;

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
        String name=viTien.getName();
        String money =String.valueOf(viTien.getMoney());
       etLoaivi.setText(name);
       etSotien.setText(money);

        btnluu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etLoaivi.getText().toString().isEmpty() || etSotien.getText().toString().isEmpty()) {
                    Toast.makeText(Edit_ViTien.this, "Hãy nhập đủ các mục tên ví,só tiền", Toast.LENGTH_SHORT).show();
                }
                else {
                    String loai = etLoaivi.getText().toString();
                    int money = Integer.parseInt(etSotien.getText().toString());

                    ViTien viTien1 = new ViTien(loai, money);
                    db.updateViTienByID(viTien1, viTien);
                    Toast.makeText(Edit_ViTien.this, "Cập nhật thành công", Toast.LENGTH_SHORT).show();

                }
            }
        });

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(v.getContext())
                        .setTitle("Delete ")
                        .setMessage("Bạn có chắc chắn muốn xóa không?")

                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                db.deleteViTien(viTien);
                                Intent intent = new Intent(v.getContext(), MainActivity.class);
                                intent.putExtra("classFrom", Edit_ViTien.class.toString());
                                v.getContext().startActivity(intent);
                            }
                        })

                        .setNegativeButton(android.R.string.no, null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });


        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                intent.putExtra("classFrom", Edit_ViTien.class.toString());
                v.getContext().startActivity(intent);
            }
        });
    }
}