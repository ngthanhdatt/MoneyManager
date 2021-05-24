package com.example.moneymanager;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
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
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.moneymanager.Adapter.BottomSheetDialog.InterfaceLoaiThu;
import com.example.moneymanager.Adapter.BottomSheetDialog.InterfaceViTien;
import com.example.moneymanager.Database.DatabaseHelper;
import com.example.moneymanager.Fragment.ThuChi.BottomSheetDialog.BottomSheetDialog_LoaiThu;
import com.example.moneymanager.Fragment.ThuChi.BottomSheetDialog.BottomSheetDialog_ViTien;
import com.example.moneymanager.Model.LoaiThu;
import com.example.moneymanager.Model.Thu;
import com.example.moneymanager.Model.ViTien;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Edit_Thu extends AppCompatActivity {
    Toolbar toolbar1;
    Toolbar toolbar2;
    Toolbar toolbar3;
    Toolbar toolbar4;
    Toolbar toolbar5;
    Toolbar toolbar6;

    Button back;
    Button luu ;
    Button xoa ;
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

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_thuchi);

        DatabaseHelper db = new DatabaseHelper(this);


        toolbar1 = findViewById(R.id.frag_Toolbar_EditThuChi);
        toolbar2 = findViewById(R.id.frag_Toolbar_EditThuChi_ngay);
        toolbar3 = findViewById(R.id.frag_Toolbar_EditThuChi_ViTien);
        toolbar4 = findViewById(R.id.frag_Toolbar_EditThuChi_TheLoai);
        toolbar5 = findViewById(R.id.frag_Toolbar_EditThuChi_SoTien);
        toolbar6 = findViewById(R.id.frag_Toolbar_ThemThuChi_GhiChu);

        back = findViewById(R.id.frag_Toolbar_EditThuChi_back);
        luu = findViewById(R.id.button_editthuchi);
        xoa=findViewById(R.id.button_xoathuchi);
        editNgay = findViewById(R.id.Edit_Ngay);
        editGio = findViewById(R.id.Edit_Gio);

        ngay = findViewById(R.id.Edit_TextView_ngay);
        vitien = findViewById(R.id.Edit_TextView_vitien);
        theloai = findViewById(R.id.Edit_TextView_theloai);
        sotien = findViewById(R.id.Edit_TextView_sotien);
        ghichu = findViewById(R.id.Edit_TextView_ghichu);


        editVitien = findViewById(R.id.EditText_vitien);
        editTheloai = findViewById(R.id.EditText_theloai);
        editSotien = findViewById(R.id.EditText_sotien);
        editGhichu = findViewById(R.id.EditText_ghichu);

        Intent intent = getIntent();
        Thu thu = (Thu) intent.getSerializableExtra("thu");
        String loai = thu.getLoaiThu().getName();
        String vi = thu.getViTien().getName();
        String tien = String.valueOf(thu.getSotien());
        String ghichu = thu.getGhichu();
        editVitien.setText(vi);
        editTheloai.setText(loai);
        editSotien.setText(tien);
        editGhichu.setText(ghichu);

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
                intent.putExtra("classFrom", Edit_Thu.class.toString());
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

        //editTheloai.setInputType(InputType.TYPE_NULL);
        editTheloai.setShowSoftInputOnFocus(false);
        editTheloai.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    openBottomLoaiThu();
                    return true;
                }
                return false;
            }
        });

        luu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTheloai.getText().toString().isEmpty() || editVitien.getText().toString().isEmpty()
                        || editSotien.getText().toString().isEmpty()) {
                    Toast.makeText(Edit_Thu.this, "Hãy nhập đủ các mục ví tiền,thể loại,só tiền", Toast.LENGTH_SHORT).show();
                }
                else {
                    String time = editNgay.getText().toString() + " " + editGio.getText().toString();
                    String ghichu = editGhichu.getText().toString();
                    Integer tien = Integer.parseInt(editSotien.getText().toString());
                    String vi = editVitien.getText().toString();
                    String loai = editTheloai.getText().toString();
                    ViTien viTien = db.getViTienByName(vi);

                    LoaiThu loaiThu = db.getLoaiThuByName(loai);
                    Thu thu2 = new Thu(tien, time, loaiThu, viTien, ghichu);
                    db.updateThu(thu2, thu, viTien);
                    Toast.makeText(Edit_Thu.this, "Cập nhật thành công", Toast.LENGTH_SHORT).show();
                }

            }
        });

        xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(v.getContext())
                        .setTitle("Delete ")
                        .setMessage("Bạn có chắc chắn muốn xóa không?")

                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                db.deleteThu(thu,thu.getViTien());
                                Intent intent = new Intent(v.getContext(), MainActivity.class);
                                intent.putExtra("classFrom", Edit_Thu.class.toString());
                                v.getContext().startActivity(intent);
                            }
                        })

                        .setNegativeButton(android.R.string.no, null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
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
