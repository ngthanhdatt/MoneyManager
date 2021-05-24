package com.example.moneymanager;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import com.example.moneymanager.Adapter.FragmentAdapter;
import com.example.moneymanager.Database.DatabaseHelper;
import com.example.moneymanager.Fragment.ThongKe.ThongKeFragment;
import com.example.moneymanager.Fragment.ThongKe.ThongKe_ThuFragment;
import com.example.moneymanager.Fragment.ViTien.ViTienFragment;
import com.example.moneymanager.Model.Chi;
import com.example.moneymanager.Model.LoaiChi;
import com.example.moneymanager.Model.ViTien;
import com.google.android.material.bottomnavigation.BottomNavigationView;



public class MainActivity extends AppCompatActivity {

    String startDate;
    String endDate;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Intent intent=getIntent();
//        id = intent.getStringExtra("userId");

        ViewPager2 viewPager2 = findViewById(R.id.main_viewpager);
        FragmentAdapter fragmentAdapter = new FragmentAdapter(this);
        viewPager2.setAdapter(fragmentAdapter);
        viewPager2.setNestedScrollingEnabled(true);

        DatabaseHelper db = new DatabaseHelper(getBaseContext());
        db.addLoaiChi_Default();
        db.addLoaiThu_Default();
        db.addVi_Default();
        db.addThoiGian();

        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_bottom);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.menu_hangngay){
                    viewPager2.setCurrentItem(0, true);
                    return true;
                }else if (item.getItemId() == R.id.menu_thongke){
                    viewPager2.setCurrentItem(1, true);
                    return true;
                }else if (item.getItemId() == R.id.menu_vitien){
                    viewPager2.setCurrentItem(2, true);
                    return true;
                }else if (item.getItemId() == R.id.menu_caidat){
                    viewPager2.setCurrentItem(3, true);
                    return true;
                }
                return false;
            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
            }
        });

    }
}