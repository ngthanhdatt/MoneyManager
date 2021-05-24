package com.example.moneymanager.Fragment.ThuChi;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.moneymanager.Adapter.RecyclerViewChiHangNgayAdapter;
import com.example.moneymanager.Database.DatabaseHelper;
import com.example.moneymanager.Model.Chi;
import com.example.moneymanager.Model.Thu;
import com.example.moneymanager.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Chi_HangNgayFragment extends Fragment {
    private RecyclerView recyclerView;
    private DatabaseHelper db;
    private RecyclerViewChiHangNgayAdapter adapter;

    public Chi_HangNgayFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        db = new DatabaseHelper(getActivity());
        db = new DatabaseHelper(this.getContext());
        return inflater.inflate(R.layout.fragment_chi__hang_ngay, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        adapter = new RecyclerViewChiHangNgayAdapter();
        recyclerView = view.findViewById(R.id.frag_recyclerView_chi_hangngay);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

        RecyclerView.ItemDecoration itemDecoration= new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
        registerForContextMenu(this.recyclerView);

        List<Chi> list = new ArrayList<>();
        try {
            list =getData();
        } catch (Exception e) {
            e.printStackTrace();
        }
        adapter.updateDataChi(list);
    }

    public List getData() throws Exception{
        List<Chi> list = new ArrayList<>();
        list = db.getAllChi();

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

        List<Chi> listChi = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            if(format2.parse(list.get(i).getThoiGian()).before(endDate2) && format2.parse(list.get(i).getThoiGian()).after(startDate2)) {
                listChi.add(list.get(i));
            }
        }
        return listChi;
    }
}