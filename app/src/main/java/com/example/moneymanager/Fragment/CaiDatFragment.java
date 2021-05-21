package com.example.moneymanager.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.moneymanager.Database.DatabaseHelper;
import com.example.moneymanager.R;
import com.example.moneymanager.ResetPassword;
import com.example.moneymanager.Them_ThuChi;


public class CaiDatFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public CaiDatFragment() {

    }

    public static CaiDatFragment newInstance(String param1, String param2) {
        CaiDatFragment fragment = new CaiDatFragment();
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
        return inflater.inflate(R.layout.fragment_cai_dat, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        DatabaseHelper db  = new DatabaseHelper(getActivity().getBaseContext());

        Toolbar toolbar1 =(Toolbar)view.findViewById(R.id.frag_Toolbar1_caidat);
        Toolbar toolbar2 =(Toolbar)view.findViewById(R.id.frag_Toolbar2_caidat);
        Toolbar toolbar3 =(Toolbar)view.findViewById(R.id.frag_Toolbar3_caidat);
        Toolbar toolbar4 =(Toolbar)view.findViewById(R.id.frag_Toolbar4_caidat);

        TextView textView = view.findViewById((R.id.frag_Toolbar_caidat_TextView));
        TextView tvShowUserName = view.findViewById(R.id.tvShowUserName);

        Button caidat = view.findViewById((R.id.frag_viewPager_caidat_CaiDat));
        Button vitien = view.findViewById((R.id.frag_viewPager_caidat_ViTien));
        Button matkhau = view.findViewById((R.id.frag_viewPager_caidat_MatKhau));
        Button saoluu = view.findViewById((R.id.frag_viewPager_caidat_SaoLuu));
        Button phongcach = view.findViewById((R.id.frag_viewPager_caidat_PhongCach));
        Button phanhoi = view.findViewById((R.id.frag_viewPager_caidat_PhanHoi));
        Button trogiup = view.findViewById((R.id.frag_viewPager_caidat_TroGiup));
        Button gioithieu = view.findViewById((R.id.frag_viewPager_caidat_GioiThieu));




        phongcach.setOnClickListener(new View.OnClickListener() {
            int i=0;
            @Override
            public void onClick(View v) {
                if(i%2==0) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    i += 1;
                }
                else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    i+=1;
                }

            }
        });

        matkhau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), ResetPassword.class);
                view.getContext().startActivity(intent);
            }
        });
    }
}