package com.example.moneymanager.Fragment.ThuChi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.example.moneymanager.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomSheetDialog_ViTien extends BottomSheetDialogFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable
            ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.bottom_sheet_layout_vitien,
                container, false);

        Button buttonA = v.findViewById(R.id.vi_tienmat);
        Button buttonB = v.findViewById(R.id.vi_nganhang);
        Button buttonC= v.findViewById(R.id.vi_tindung);

        return v;
    }
}
