package com.example.moneymanager.Fragment.ThuChi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.example.moneymanager.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomSheetDialog_LoaiChi extends BottomSheetDialogFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable
            ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.bottom_sheet_layout_loaichi,
                container, false);

        Button anuong = v.findViewById(R.id.loaichi_anuong);
        Button sinhhoat = v.findViewById(R.id.loaichi_sinhhoat);
        Button giaitri = v.findViewById(R.id.loaichi_giaitri);
        Button giaothong = v.findViewById(R.id.loaichi_giaothong);
        Button sothich = v.findViewById(R.id.loaichi_sothich);
        Button quanao = v.findViewById(R.id.loaichi_quanao);
        Button lamdep = v.findViewById(R.id.loaichi_lamdep);
        Button suckhoe = v.findViewById(R.id.loaichi_suckhoe);
        Button giaoduc = v.findViewById(R.id.loaichi_giaoduc);
        Button sukien = v.findViewById(R.id.loaichi_sukien);
        Button khac = v.findViewById(R.id.loaichi_khac);


        return v;
    }
}
