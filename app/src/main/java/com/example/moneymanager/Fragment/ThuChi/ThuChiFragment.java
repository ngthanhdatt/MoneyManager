package com.example.moneymanager.Fragment.ThuChi;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;


import com.example.moneymanager.Adapter.FragmentThongKeAdapter;
import com.example.moneymanager.Adapter.FragmentThuChiAdaper;
import com.example.moneymanager.Database.DatabaseHelper;
import com.example.moneymanager.R;
import com.example.moneymanager.Them_ThuChi;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class ThuChiFragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private Toolbar toolbar;
    private Button start;
    private Button end;
    private int year, month, date;

    public ThuChiFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_thu_chi, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        DatabaseHelper db = new DatabaseHelper(getContext());

        tabLayout = view.findViewById(R.id.frag_tabLayout_thuchi);
        viewPager2 = view.findViewById(R.id.frag_viewPager_thuchi);
        FloatingActionButton add = view.findViewById(R.id.fab);
        toolbar = (Toolbar)view.findViewById(R.id.frag_Toolbar_thongke);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
        start = (Button)view.findViewById(R.id.frag_Toolbar_thuchi_StartDate);
        end = (Button)view.findViewById(R.id.frag_Toolbar_thuchi_EndDate);

        FragmentThuChiAdaper fragmentThuChiAdaper = new FragmentThuChiAdaper(this.getActivity());
        viewPager2.setAdapter(fragmentThuChiAdaper);

        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if(position == 0){
                    tab.setText("Thu");
                } else if(position == 1) {
                    tab.setText("Chi");
                }
            }
        }).attach();

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), Them_ThuChi.class);
                view.getContext().startActivity(intent);
            }
        });

        Calendar cal = Calendar.getInstance();
        int last_day = cal.getActualMaximum(Calendar.DATE);
        String currentTime = new SimpleDateFormat("MM/yyyy", Locale.getDefault()).format(new Date());
        start.setText("01/" +currentTime);
        end.setText(Integer.toString(last_day)+'/'+currentTime);
        db.updateBatDau(start.getText().toString());
        db.updateKetThuc(end.getText().toString());

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                year = c.get(Calendar.YEAR);
                month = c.get(Calendar.MONTH);
                date = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(viewPager2.getContext(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                start.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                                db.updateBatDau(start.getText().toString());
                                int t=tabLayout.getSelectedTabPosition();
                                FragmentThuChiAdaper fragmentThuChiAdaper1 = new FragmentThuChiAdaper(getActivity());
                                viewPager2.setAdapter(fragmentThuChiAdaper1);
                                viewPager2.setCurrentItem(t);
                            }
                        }, year, month, date);
                datePickerDialog.show();
            }
        });

        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                year = c.get(Calendar.YEAR);
                month = c.get(Calendar.MONTH);
                date = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(viewPager2.getContext(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                end.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                                db.updateKetThuc(end.getText().toString());
                                int t=tabLayout.getSelectedTabPosition();
                                FragmentThuChiAdaper fragmentThuChiAdaper1 = new FragmentThuChiAdaper(getActivity());
                                viewPager2.setAdapter(fragmentThuChiAdaper1);
                                viewPager2.setCurrentItem(t);
                            }
                        }, year, month, date);
                datePickerDialog.show();
            }
        });

    }

}