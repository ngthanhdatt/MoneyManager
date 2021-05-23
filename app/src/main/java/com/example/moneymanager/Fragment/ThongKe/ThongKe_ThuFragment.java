package com.example.moneymanager.Fragment.ThongKe;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Pie;
import com.anychart.enums.LegendLayout;
import com.anychart.enums.Align;
import com.anychart.chart.common.listener.Event;
import com.anychart.chart.common.listener.ListenersInterface;
import com.example.moneymanager.Adapter.FragmentThuChiAdaper;
import com.example.moneymanager.Database.DatabaseHelper;
import com.example.moneymanager.Model.LoaiThu;
import com.example.moneymanager.Model.Thu;
import com.example.moneymanager.R;
import com.example.moneymanager.Them_ThuChi;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

import java.util.ArrayList;
import java.util.List;


public class ThongKe_ThuFragment extends Fragment {

    private RecyclerView recyclerView;
    private AnyChartView anyChartView;
    TextView tvLuong, tvThuong, tvThemGio, tvKhac;
    PieChart pieChart;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_thong_ke__thu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvLuong=view.findViewById(R.id.tvLuong);
        tvThuong=view.findViewById(R.id.tvThuong);
        tvThemGio=view.findViewById(R.id.tvThemGio);
        tvKhac=view.findViewById(R.id.tvKhac);
        pieChart = view.findViewById(R.id.piechart_thu);
        setData();

        //recyclerView = view.findViewById(R.id.frag_recyclerView_bieudo_thu);
        // = view.findViewById(R.id.bieudo_thu);

//        Pie pie = AnyChart.pie();
//
//        List<DataEntry> data = new ArrayList<>();
//        data.add(new ValueDataEntry("Apples", 6371664));
//        data.add(new ValueDataEntry("Pears", 789622));
//        data.add(new ValueDataEntry("Bananas", 7216301));
//        data.add(new ValueDataEntry("Grapes", 1486621));
//        data.add(new ValueDataEntry("Oranges", 1200000));
//
//        pie.data(data);
//
//        pie.title("Fruits imported in 2015 (in kg)");
//
//        pie.labels().position("outside");
//
//        pie.legend().title().enabled(true);
//        pie.legend().title()
//                .text("Retail channels")
//                .padding(0d, 0d, 10d, 0d);
//
//        pie.legend()
//                .position("center-bottom")
//                .itemsLayout(LegendLayout.HORIZONTAL)
//                .align(Align.CENTER);
//
//        anyChartView.setChart(pie);

    }

    private void setData(){
        DatabaseHelper db= new DatabaseHelper(getContext());
        List<Thu> list = new ArrayList<>();
        list=db.getAllThu();
        int luong=0;
        int thuong=0;
        int themgio=0;
        int khac=0;

        for(int i=0;i<list.size();i++){
            if(list.get(i).getLoaiThu().getId()==db.getLoaiThuByName("Tiền lương").getId()){
                luong+= list.get(i).getSotien();
            }
            if(list.get(i).getLoaiThu().getId()==db.getLoaiThuByName("Tiền thưởng").getId()){
                thuong+= list.get(i).getSotien();
            }
            if(list.get(i).getLoaiThu().getId()==db.getLoaiThuByName("Trả thêm giờ").getId()){
                themgio+= list.get(i).getSotien();
            }
            if(list.get(i).getLoaiThu().getId()==db.getLoaiThuByName("Khác").getId()){
                khac+= list.get(i).getSotien();
            }
        }
        tvLuong.setText(Integer.toString(luong));
        tvThuong.setText(Integer.toString(thuong));
        tvThemGio.setText(Integer.toString(themgio));
        tvKhac.setText(Integer.toString(khac));


        pieChart.addPieSlice(
                new PieModel(
                        "Lương",
                        Integer.parseInt(tvLuong.getText().toString()),
                        Color.parseColor("#ff0000")));
        pieChart.addPieSlice(
                new PieModel(
                        "Thưởng",
                        Integer.parseInt(tvThuong.getText().toString()),
                        Color.parseColor("#0000ff")));
        pieChart.addPieSlice(
                new PieModel(
                        "Trả thêm giờ",
                        Integer.parseInt(tvThemGio.getText().toString()),
                        Color.parseColor("#ffff00")));
        pieChart.addPieSlice(
                new PieModel(
                        "Khác",
                        Integer.parseInt(tvKhac.getText().toString()),
                        Color.parseColor("#ff00ff")));

        pieChart.startAnimation();

    }

}