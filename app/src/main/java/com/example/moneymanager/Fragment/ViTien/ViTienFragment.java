package com.example.moneymanager.Fragment.ViTien;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moneymanager.Adapter.RecyclerViewVerticalAdapter;
import com.example.moneymanager.Database.DatabaseHelper;
import com.example.moneymanager.MainActivity;
import com.example.moneymanager.Model.ViTien;
import com.example.moneymanager.R;
import com.example.moneymanager.ResetPassword;
import com.example.moneymanager.Them_ViTien;

import org.jetbrains.annotations.NotNull;

import java.util.List;


public class ViTienFragment extends Fragment {

    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private Button btnThemVi;
    private RecyclerViewVerticalAdapter adapter;
    private DatabaseHelper db;
    private List<ViTien> listVi;
    String id;

    public ViTienFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        MainActivity activity = (MainActivity) getActivity();
        id = activity.getId();
        db = new DatabaseHelper(getActivity());
        return inflater.inflate(R.layout.fragment_vi_tien, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        adapter = new RecyclerViewVerticalAdapter();
        db = new DatabaseHelper(getContext());

        toolbar = view.findViewById(R.id.frag_Toolbar_thongke);
        recyclerView = view.findViewById(R.id.frag_recyclerView_vitien);
        btnThemVi  = view.findViewById(R.id.btnThemVitien);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);


        btnThemVi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), Them_ViTien.class);
                intent.putExtra("userId1",id);
                view.getContext().startActivity(intent);
            }
        });
    }

}