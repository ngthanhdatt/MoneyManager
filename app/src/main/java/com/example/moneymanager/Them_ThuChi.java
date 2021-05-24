package com.example.moneymanager;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.moneymanager.Adapter.BottomSheetDialog.InterfaceLoaiChi;
import com.example.moneymanager.Adapter.BottomSheetDialog.InterfaceLoaiThu;
import com.example.moneymanager.Adapter.BottomSheetDialog.InterfaceViTien;
import com.example.moneymanager.Database.DatabaseHelper;
import com.example.moneymanager.Fragment.ThuChi.BottomSheetDialog.BottomSheetDialog_LoaiChi;
import com.example.moneymanager.Fragment.ThuChi.BottomSheetDialog.BottomSheetDialog_LoaiThu;
import com.example.moneymanager.Fragment.ThuChi.BottomSheetDialog.BottomSheetDialog_ViTien;
import com.example.moneymanager.Model.Chi;
import com.example.moneymanager.Model.LoaiChi;
import com.example.moneymanager.Model.LoaiThu;
import com.example.moneymanager.Model.Thu;
import com.example.moneymanager.Model.ViTien;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Them_ThuChi extends AppCompatActivity{
    DatabaseHelper db= new DatabaseHelper(getBaseContext());

    Toolbar toolbar1;
    Toolbar toolbar2;
    Toolbar toolbar3;
    Toolbar toolbar4;
    Toolbar toolbar5;
    Toolbar toolbar6;

    Button back;
    Button luu ;
    Button tieptuc ;
    Button editNgay ;
    Button editGio ;

    TextView ngay ;
    TextView vitien ;
    TextView theloai ;
    TextView sotien;
    TextView ghichu;


    EditText editVitien ;
    EditText editTheloai ;
    EditText editSotien ;
    EditText editGhichu ;

    TabLayout tabLayout ;
    TabItem tabThu;
    TabItem tabChi;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_thu_chi);

        DatabaseHelper db = new DatabaseHelper(this);


        toolbar1 = findViewById(R.id.frag_Toolbar_ThemThuChi);
        toolbar2 = findViewById(R.id.frag_Toolbar_ThemThuChi_ngay);
        toolbar3 = findViewById(R.id.frag_Toolbar_ThemThuChi_ViTien);
        toolbar4 = findViewById(R.id.frag_Toolbar_ThemThuChi_TheLoai);
        toolbar5 = findViewById(R.id.frag_Toolbar_ThemThuChi_SoTien);
        toolbar6 = findViewById(R.id.frag_Toolbar_ThemThuChi_GhiChu);

        back = findViewById(R.id.frag_Toolbar_ThemThuChi_back);
        back.setText("Thu");
        luu = findViewById(R.id.button_themthuchi);
//        tieptuc = findViewById(R.id.button_tieptuc);
        editNgay = findViewById(R.id.edit_Ngay);
        editGio = findViewById(R.id.edit_Gio);

        ngay = findViewById(R.id.TextView_ngay);
        vitien = findViewById(R.id.TextView_vitien);
        theloai = findViewById(R.id.TextView_theloai);
        sotien = findViewById(R.id.TextView_sotien);
        ghichu = findViewById(R.id.TextView_ghichu);


        editVitien = findViewById(R.id.editText_vitien);
        editTheloai = findViewById(R.id.editText_theloai);
        editSotien = findViewById(R.id.editText_sotien);
        editGhichu = findViewById(R.id.editText_ghichu);

        tabLayout = findViewById(R.id.frag_tabLayout_ThemThuChi);
        tabThu = findViewById(R.id.tabThu);
        tabChi = findViewById(R.id.tabChi);


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


        //editVitien.setInputType(InputType.TYPE_NULL);
        editVitien.setShowSoftInputOnFocus(false);
        editVitien.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    openBottomViTien();
                    return true;
                }
                return false;
            }
        });


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    back.setText("Thu");
                }
                if (tab.getPosition() == 1) {
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


        //editTheloai.setInputType(InputType.TYPE_NULL);
        editTheloai.setShowSoftInputOnFocus(false);
        editTheloai.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (back.getText() == "Thu") {
                        openBottomLoaiThu();
                    }
                    if (back.getText() == "Chi") {
                        openBottomLoaiChi();
                    }
                    return true;
                }
                return false;
            }
        });

        luu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String time = editNgay.getText().toString()+" "+editGio.getText().toString();
                String ghichu= editGhichu.getText().toString();
                Integer tien= Integer.parseInt(editSotien.getText().toString());
                String vi=editVitien.getText().toString();
                String loai=editTheloai.getText().toString();
                ViTien viTien=db.getViTienByName(vi);

                    if (back.getText() == "Thu") {
                        LoaiThu loaiThu = db.getLoaiThuByName(loai);
                        Thu thu = new Thu(tien, time, loaiThu, viTien, ghichu);
                        db.addThu(thu, viTien);
                    }

                    if (back.getText() == "Chi") {
                        LoaiChi loaiChi = db.getLoaiChiByName(loai);
                        Chi chi = new Chi(tien, time, loaiChi, viTien, ghichu);
                        db.addChi(chi, viTien);
                    }

                editTheloai.setText("");
                editGhichu.setText("");
                editVitien.setText("");
                editSotien.setText("");
            }
        });
    }

    private void openBottomLoaiThu(){
        DatabaseHelper db= new DatabaseHelper(this);
        List<LoaiThu> list= new ArrayList<>();
        list =db.getAllLoaiThu();
        BottomSheetDialog_LoaiThu bottomSheetDialog_loaiThu= new BottomSheetDialog_LoaiThu(list, new InterfaceLoaiThu() {
            @Override
            public void clickItem(LoaiThu loaiThu) {
                editTheloai.setText(loaiThu.getName());
            }
        });
        bottomSheetDialog_loaiThu.show(getSupportFragmentManager(),bottomSheetDialog_loaiThu.getTag());
    }

    private void openBottomLoaiChi(){
        DatabaseHelper db= new DatabaseHelper(this);
        List<LoaiChi> list= new ArrayList<>();
        list =db.getAllLoaiChi();
        BottomSheetDialog_LoaiChi bottomSheetDialog_loaiChi= new BottomSheetDialog_LoaiChi(list, new InterfaceLoaiChi() {
            @Override
            public void clickItem(LoaiChi loaiChi) {
                editTheloai.setText(loaiChi.getName());
            }
        });
        bottomSheetDialog_loaiChi.show(getSupportFragmentManager(),bottomSheetDialog_loaiChi.getTag());
    }

    private void openBottomViTien(){
        DatabaseHelper db= new DatabaseHelper(this);
        List<ViTien> list= new ArrayList<>();
        list =db.getAllViTien();
        BottomSheetDialog_ViTien bottomSheetDialog_viTien= new BottomSheetDialog_ViTien(list, new InterfaceViTien() {
            @Override
            public void clickItem(ViTien viTien) {
                editVitien.setText(viTien.getName());
            }
        });
        bottomSheetDialog_viTien.show(getSupportFragmentManager(),bottomSheetDialog_viTien.getTag());
    }


}