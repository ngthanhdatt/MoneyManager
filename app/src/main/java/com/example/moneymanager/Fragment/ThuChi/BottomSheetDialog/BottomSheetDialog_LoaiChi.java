package com.example.moneymanager.Fragment.ThuChi.BottomSheetDialog;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moneymanager.Adapter.BottomSheetDialog.DialogLoaiChiAdapter;
import com.example.moneymanager.Adapter.BottomSheetDialog.InterfaceLoaiChi;
import com.example.moneymanager.Model.LoaiChi;
import com.example.moneymanager.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class BottomSheetDialog_LoaiChi extends BottomSheetDialogFragment{

    private List<LoaiChi> list;
    private InterfaceLoaiChi anInterface;

    public BottomSheetDialog_LoaiChi(List<LoaiChi> list, InterfaceLoaiChi anInterface) {
        this.list = list;
        this.anInterface = anInterface;
    }

    @NotNull
    @Override
    public Dialog onCreateDialog(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        BottomSheetDialog bottomSheetDialog= (BottomSheetDialog) super.onCreateDialog(savedInstanceState);

        View view =LayoutInflater.from(getContext()).inflate(R.layout.bottom_sheet_layout_loaichi,null);
        bottomSheetDialog.setContentView(view);

        RecyclerView recyclerView = view.findViewById(R.id.frag_recyclerView_dialog_loaichi);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        DialogLoaiChiAdapter dialogLoaiChiAdapter = new DialogLoaiChiAdapter(list, new InterfaceLoaiChi() {
            @Override
            public void clickItem(LoaiChi loaiChi) {
                anInterface.clickItem(loaiChi);
            }
        });

        recyclerView.setAdapter(dialogLoaiChiAdapter);
        RecyclerView.ItemDecoration itemDecoration= new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);

        return bottomSheetDialog;
    }
}
