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

import com.example.moneymanager.Adapter.RecyclerViewThuHangNgayAdapter;
import com.example.moneymanager.Database.DatabaseHelper;
import com.example.moneymanager.Model.Thu;
import com.example.moneymanager.R;

import java.util.ArrayList;
import java.util.List;


public class Thu_HangNgayFragment extends Fragment {
    private RecyclerView recyclerView;
    private DatabaseHelper db;
    private List<Thu> listThu;
    private RecyclerViewThuHangNgayAdapter adapter;

    public Thu_HangNgayFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        db = new DatabaseHelper(getActivity());
        listThu = new ArrayList<>();
        db = new DatabaseHelper(this.getContext());
        return inflater.inflate(R.layout.fragment_thu__hang_ngay, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listThu = db.getAllThu();
        adapter = new RecyclerViewThuHangNgayAdapter();
        recyclerView = view.findViewById(R.id.frag_recyclerView_thu_hangngay);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

        RecyclerView.ItemDecoration itemDecoration= new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
        registerForContextMenu(this.recyclerView);

        adapter.updateDataThu(listThu);
    }
}