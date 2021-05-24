package com.example.moneymanager.Fragment.ThongKe;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.moneymanager.Database.DatabaseHelper;
import com.example.moneymanager.Model.Chi;
import com.example.moneymanager.Model.Thu;
import com.example.moneymanager.R;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;
import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ThongKe_ChiFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ThongKe_ChiFragment extends Fragment {

    TextView tvAnUong, tvGiaiTri, tvSoThich, tvGiaoThong,tvSinhHoat,tvAoQuan,tvLamDep,tvSucKhoe,tvGiaoDuc,tvSuKien,tvKhac;
    PieChart pieChart;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ThongKe_ChiFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ThongKe_ChiFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ThongKe_ChiFragment newInstance(String param1, String param2) {
        ThongKe_ChiFragment fragment = new ThongKe_ChiFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_thong_ke__chi, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvAnUong=view.findViewById(R.id.tvAnUong);
        tvGiaiTri=view.findViewById(R.id.tvGiaiTri);
        tvSoThich=view.findViewById(R.id.tvSoThich);
        tvGiaoThong=view.findViewById(R.id.tvGiaoThong);
        tvSinhHoat=view.findViewById(R.id.tvSinhHoat);
        tvAoQuan=view.findViewById(R.id.tvAoQuan);
        tvLamDep=view.findViewById(R.id.tvLamDep);
        tvSucKhoe=view.findViewById(R.id.tvSucKhoe);
        tvGiaoDuc=view.findViewById(R.id.tvGiaoDuc);
        tvSuKien=view.findViewById(R.id.tvSuKien);
        tvKhac=view.findViewById(R.id.tvKhac_Chi);


        pieChart = view.findViewById(R.id.piechart_chi);
        try {
            setData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setData()throws Exception{
        DatabaseHelper db= new DatabaseHelper(getContext());
        List<Chi> list = new ArrayList<>();
        list=db.getAllChi();

        String start=db.getBatDau();
        String end=db.getKetThuc();
        SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
        Date startDate = format1.parse(start);
        Date endDate = format1.parse(end);

        SimpleDateFormat format2 = new SimpleDateFormat("dd/MM/yyyy(EEE) hh:mm");
        String start2= format2.format(startDate);
        String end2 = format2.format(endDate);
        Date startDate2=format2.parse(start2);
        Date endDate2 = format2.parse(end2);

        int anuong=0;
        int giaitri=0;
        int sothich=0;
        int sinhhoat=0;
        int giaothong=0;
        int aoquan=0;
        int lamdep=0;
        int giaoduc=0;
        int suckhoe=0;
        int sukien=0;
        int khac=0;

        for(int i=0;i<list.size();i++){
            if(format2.parse(list.get(i).getThoiGian()).before(endDate2) && format2.parse(list.get(i).getThoiGian()).after(startDate2)) {
                if (list.get(i).getLoaiChi().getId() == db.getLoaiChiByName("Ăn uống").getId()) {
                    anuong += list.get(i).getSotien();
                }
                if (list.get(i).getLoaiChi().getId() == db.getLoaiChiByName("Giải trí").getId()) {
                    giaitri += list.get(i).getSotien();
                }
                if (list.get(i).getLoaiChi().getId() == db.getLoaiChiByName("Sinh hoạt").getId()) {
                    sinhhoat += list.get(i).getSotien();
                }
                if (list.get(i).getLoaiChi().getId() == db.getLoaiChiByName("Sở thích").getId()) {
                    sothich += list.get(i).getSotien();
                }
                if (list.get(i).getLoaiChi().getId() == db.getLoaiChiByName("Giao thông").getId()) {
                    giaothong += list.get(i).getSotien();
                }
                if (list.get(i).getLoaiChi().getId() == db.getLoaiChiByName("Áo quần").getId()) {
                    aoquan += list.get(i).getSotien();
                }
                if (list.get(i).getLoaiChi().getId() == db.getLoaiChiByName(" Làm đẹp").getId()) {
                    lamdep += list.get(i).getSotien();
                }
                if (list.get(i).getLoaiChi().getId() == db.getLoaiChiByName("Sự kiện").getId()) {
                    sukien += list.get(i).getSotien();
                }
                if (list.get(i).getLoaiChi().getId() == db.getLoaiChiByName("Giáo dục").getId()) {
                    giaoduc += list.get(i).getSotien();
                }
                if (list.get(i).getLoaiChi().getId() == db.getLoaiChiByName("Sức khỏe").getId()) {
                    suckhoe += list.get(i).getSotien();
                }
                if (list.get(i).getLoaiChi().getId() == db.getLoaiChiByName("Khác").getId()) {
                    khac += list.get(i).getSotien();
                }
            }

        }
        tvAnUong.setText(Integer.toString(anuong));
        tvGiaiTri.setText(Integer.toString(giaitri));
        tvSoThich.setText(Integer.toString(sothich));
        tvGiaoThong.setText(Integer.toString(giaothong));
        tvSinhHoat.setText(Integer.toString(sinhhoat));
        tvAoQuan.setText(Integer.toString(aoquan));
        tvLamDep.setText(Integer.toString(lamdep));
        tvSucKhoe.setText(Integer.toString(suckhoe));
        tvGiaoDuc.setText(Integer.toString(giaoduc));
        tvSuKien.setText(Integer.toString(sukien));
        tvKhac.setText(Integer.toString(khac));


        pieChart.addPieSlice(
                new PieModel(
                        "tvAnUong",
                        Integer.parseInt(tvAnUong.getText().toString()),
                        Color.parseColor("#800000")));
        pieChart.addPieSlice(
                new PieModel(
                        "tvGiaiTri",
                        Integer.parseInt(tvGiaiTri.getText().toString()),
                        Color.parseColor("#ff0000")));
        pieChart.addPieSlice(
                new PieModel(
                        "tvGiaoThong",
                        Integer.parseInt(tvGiaoThong.getText().toString()),
                        Color.parseColor("#800080")));
        pieChart.addPieSlice(
                new PieModel(
                        "tvSoThich",
                        Integer.parseInt(tvSoThich.getText().toString()),
                        Color.parseColor("#ff00ff")));
        pieChart.addPieSlice(
                new PieModel(
                        "tvSinhHoat",
                        Integer.parseInt(tvSinhHoat.getText().toString()),
                        Color.parseColor("#008000")));
        pieChart.addPieSlice(
                new PieModel(
                        "tvAoQuan",
                        Integer.parseInt(tvAoQuan.getText().toString()),
                        Color.parseColor("#00ff00")));
        pieChart.addPieSlice(
                new PieModel(
                        "tvLamDep",
                        Integer.parseInt(tvLamDep.getText().toString()),
                        Color.parseColor("#808000")));
        pieChart.addPieSlice(
                new PieModel(
                        "tvSucKhoe",
                        Integer.parseInt(tvSucKhoe.getText().toString()),
                        Color.parseColor("#ffff00")));
        pieChart.addPieSlice(
                new PieModel(
                        "tvGiaoDuc",
                        Integer.parseInt(tvGiaoDuc.getText().toString()),
                        Color.parseColor("#000080")));
        pieChart.addPieSlice(
                new PieModel(
                        "tvSuKien",
                        Integer.parseInt(tvSuKien.getText().toString()),
                        Color.parseColor("#0000ff")));
        pieChart.addPieSlice(
                new PieModel(
                        "tvKhac",
                        Integer.parseInt(tvKhac.getText().toString()),
                        Color.parseColor("#00ffff")));

        pieChart.startAnimation();

    }
}