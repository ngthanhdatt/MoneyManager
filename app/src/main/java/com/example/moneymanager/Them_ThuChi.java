package com.example.moneymanager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import com.google.android.material.tabs.TabLayout;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Them_ThuChi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_thu_chi);

        Toolbar toolbar1 = findViewById(R.id.frag_Toolbar_ThemThuChi);
        Toolbar toolbar2 = findViewById(R.id.frag_Toolbar_ThemThuChi_ngay);
        Toolbar toolbar3 = findViewById(R.id.frag_Toolbar_ThemThuChi_TaiKhoan);
        Toolbar toolbar4 = findViewById(R.id.frag_Toolbar_ThemThuChi_TheLoai);
        Toolbar toolbar5 = findViewById(R.id.frag_Toolbar_ThemThuChi_SoTien);
        Toolbar toolbar6 = findViewById(R.id.frag_Toolbar_ThemThuChi_GhiChu);

        Button back = findViewById(R.id.frag_Toolbar_ThemThuChi_back);
        Button luu = findViewById(R.id.button_themthuchi);
        Button tieptuc = findViewById(R.id.button_tieptuc);
        Button editNgay = findViewById(R.id.edit_Ngay);
        Button editGio = findViewById(R.id.edit_Gio);

        TextView ngay = findViewById(R.id.TextView_ngay);
        TextView taikhoan = findViewById(R.id.TextView_taikhoan);
        TextView theloai = findViewById(R.id.TextView_theloai);
        TextView sotien = findViewById(R.id.TextView_sotien);
        TextView ghichu = findViewById(R.id.TextView_ghichu);


        EditText editTaikhoan = findViewById(R.id.editText_taikhoan);
        EditText editTheloai = findViewById(R.id.editText_theloai);
        EditText editSotien = findViewById(R.id.editText_sotien);
        EditText editGhichu = findViewById(R.id.editText_ghichu);

        TabLayout tabLayout = findViewById(R.id.frag_tabLayout_ThemThuChi);
        tabLayout.addTab(tabLayout.newTab().setText("Thu"));
        tabLayout.addTab(tabLayout.newTab().setText("Chi"));

        String currentDate = new SimpleDateFormat("dd/MM/yyyy(EEE)", Locale.getDefault()).format(new Date());
        editNgay.setText(currentDate);
        String currentTime = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());
        editGio.setText(currentTime);

        editNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int date = c.get(Calendar.DAY_OF_MONTH);
                int day = c.get(Calendar.DAY_OF_WEEK);
                DatePickerDialog datePickerDialog = new DatePickerDialog(toolbar2.getContext(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                SimpleDateFormat inFormat = new SimpleDateFormat("dd-MM-yyyy");
                                try {
                                    Date myDate = inFormat.parse(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy(EEE)");
                                    String dayName = simpleDateFormat.format(myDate);
                                    editNgay.setText(dayName);
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                            }
                        }, year, month, date);
                datePickerDialog.show();
            }
        });


        editGio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int hour = c.get(Calendar.HOUR_OF_DAY);
                int minute = c.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(toolbar2.getContext(),
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int hourOfDay,
                                                  int minute) {
                                String m;
                                if (minute >= 10) {
                                    m = Integer.toString(minute);
                                } else {
                                    m = "0" + Integer.toString(minute);
                                }
                                editGio.setText(hourOfDay + ":" + m);
                            }
                        }, hour, minute, true);
                timePickerDialog.show();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                v.getContext().startActivity(intent);
            }
        });
    }
}