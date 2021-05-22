package com.example.moneymanager.Fragment.ThuChi.BottomSheetDialog;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moneymanager.Adapter.BottomSheetDialog.DialogLoaiChiAdapter;
import com.example.moneymanager.Adapter.BottomSheetDialog.DialogViTienAdapter;
import com.example.moneymanager.Adapter.BottomSheetDialog.InterfaceLoaiChi;
import com.example.moneymanager.Adapter.BottomSheetDialog.InterfaceViTien;
import com.example.moneymanager.Database.DatabaseHelper;
import com.example.moneymanager.Model.LoaiChi;
import com.example.moneymanager.Model.ViTien;
import com.example.moneymanager.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class BottomSheetDialog_ViTien extends BottomSheetDialogFragment {
    private List<ViTien> list;
    private InterfaceViTien anInterface;

    public BottomSheetDialog_ViTien(List<ViTien> list, InterfaceViTien anInterface) {
        this.list = list;
        this.anInterface = anInterface;
    }

    @NotNull
    @Override
    public Dialog onCreateDialog(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        BottomSheetDialog bottomSheetDialog= (BottomSheetDialog) super.onCreateDialog(savedInstanceState);

        View view =LayoutInflater.from(getContext()).inflate(R.layout.bottom_sheet_layout_vitien,null);
        bottomSheetDialog.setContentView(view);

        RecyclerView recyclerView = view.findViewById(R.id.frag_recyclerView_dialog_vitien);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        DialogViTienAdapter dialogViTienAdapter = new DialogViTienAdapter(list, new InterfaceViTien() {
            @Override
            public void clickItem(ViTien viTien) {
                anInterface.clickItem(viTien);
            }
        });

        recyclerView.setAdapter(dialogViTienAdapter);
        RecyclerView.ItemDecoration itemDecoration= new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);

        return bottomSheetDialog;
    }
}
