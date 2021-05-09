package com.example.moneymanager.Fragment.ViTien;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moneymanager.Adapter.RecyclerViewVerticalAdapter;
import com.example.moneymanager.R;

import org.jetbrains.annotations.NotNull;


public class ViTienFragment extends Fragment {

    private Toolbar toolbar;
    private RecyclerView recyclerView;

    public ViTienFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_vi_tien, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        toolbar = view.findViewById(R.id.frag_Toolbar_thongke);
        recyclerView = view.findViewById(R.id.frag_recyclerView_vitien);

//        RecyclerViewVerticalAdapter adapter = new RecyclerViewVerticalAdapter();
    }
}