package com.example.moneymanager.Fragment;

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

import com.example.moneymanager.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CaiDatFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CaiDatFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CaiDatFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CaiDatFragment.
     */
    // TODO: Rename and change types and number of parameters
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

        Toolbar toolbar1 =(Toolbar)view.findViewById(R.id.frag_Toolbar1_caidat);
        Toolbar toolbar2 =(Toolbar)view.findViewById(R.id.frag_Toolbar2_caidat);
        Toolbar toolbar3 =(Toolbar)view.findViewById(R.id.frag_Toolbar3_caidat);
        Toolbar toolbar4 =(Toolbar)view.findViewById(R.id.frag_Toolbar4_caidat);

        TextView textView = view.findViewById((R.id.frag_Toolbar_caidat_TextView));

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
    }
}