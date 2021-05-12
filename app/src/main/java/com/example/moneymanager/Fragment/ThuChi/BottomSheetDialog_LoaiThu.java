package com.example.moneymanager.Fragment.ThuChi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.example.moneymanager.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomSheetDialog_LoaiThu extends BottomSheetDialogFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable
            ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.bottom_sheet_layout_loaithu,
                container, false);

        Button luong = v.findViewById(R.id.loaithu_luong);
        Button thuong = v.findViewById(R.id.loaithu_thuong);
        Button themgio = v.findViewById(R.id.loaithu_themgio);
        Button khac = v.findViewById(R.id.loaithu_khac);

        return v;
    }
}
