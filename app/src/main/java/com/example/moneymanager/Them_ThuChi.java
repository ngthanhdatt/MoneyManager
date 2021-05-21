package com.example.moneymanager;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.moneymanager.Fragment.ThuChi.BottomSheetDialog_LoaiChi;
import com.example.moneymanager.Fragment.ThuChi.BottomSheetDialog_LoaiThu;
import com.example.moneymanager.Fragment.ThuChi.BottomSheetDialog_ViTien;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Them_ThuChi extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_thu_chi);

        Toolbar toolbar1 = findViewById(R.id.frag_Toolbar_ThemThuChi);
        Toolbar toolbar2 = findViewById(R.id.frag_Toolbar_ThemThuChi_ngay);
        Toolbar toolbar3 = findViewById(R.id.frag_Toolbar_ThemThuChi_ViTien);
        Toolbar toolbar4 = findViewById(R.id.frag_Toolbar_ThemThuChi_TheLoai);
        Toolbar toolbar5 = findViewById(R.id.frag_Toolbar_ThemThuChi_SoTien);
        Toolbar toolbar6 = findViewById(R.id.frag_Toolbar_ThemThuChi_GhiChu);

        Button back = findViewById(R.id.frag_Toolbar_ThemThuChi_back);
        back.setText("Thu");
        Button luu = findViewById(R.id.button_themthuchi);
        Button tieptuc = findViewById(R.id.button_tieptuc);
        Button editNgay = findViewById(R.id.edit_Ngay);
        Button editGio = findViewById(R.id.edit_Gio);

        TextView ngay = findViewById(R.id.TextView_ngay);
        TextView vitien = findViewById(R.id.TextView_vitien);
        TextView theloai = findViewById(R.id.TextView_theloai);
        TextView sotien = findViewById(R.id.TextView_sotien);
        TextView ghichu = findViewById(R.id.TextView_ghichu);


        EditText editVitien = findViewById(R.id.editText_vitien);
        EditText editTheloai = findViewById(R.id.editText_theloai);
        EditText editSotien = findViewById(R.id.editText_sotien);
        EditText editGhichu = findViewById(R.id.editText_ghichu);

        TabLayout tabLayout = findViewById(R.id.frag_tabLayout_ThemThuChi);
        TabItem tabThu= findViewById(R.id.tabThu);
        TabItem tabChi= findViewById(R.id.tabChi);


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


        editVitien.setInputType(InputType.TYPE_NULL);
        editVitien.setShowSoftInputOnFocus(false);
        editVitien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog_ViTien bottomSheet = new BottomSheetDialog_ViTien();
                bottomSheet.show(getSupportFragmentManager(),
                        "ModalBottomSheet");
            }
        });


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition()==0) {
                    back.setText("Thu");
                }
                if(tab.getPosition()==1) {
                    back.setText("Chi");
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        editTheloai.setInputType(InputType.TYPE_NULL);
        editTheloai.setShowSoftInputOnFocus(false);
        editTheloai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(back.getText()=="Thu") {
                    BottomSheetDialog_LoaiThu bottomSheet = new BottomSheetDialog_LoaiThu();
                    bottomSheet.show(getSupportFragmentManager(),
                            "ModalBottomSheet");
                }
                if(back.getText()=="Chi") {
                    BottomSheetDialog_LoaiChi bottomSheet = new BottomSheetDialog_LoaiChi();
                    bottomSheet.show(getSupportFragmentManager(),
                            "ModalBottomSheet");
                }
            }
        });
    }
}