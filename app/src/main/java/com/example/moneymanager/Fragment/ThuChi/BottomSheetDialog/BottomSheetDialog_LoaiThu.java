package com.example.moneymanager.Fragment.ThuChi.BottomSheetDialog;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moneymanager.Adapter.BottomSheetDialog.DialogLoaiChiAdapter;
import com.example.moneymanager.Adapter.BottomSheetDialog.DialogLoaiThuAdapter;
import com.example.moneymanager.Adapter.BottomSheetDialog.DialogViTienAdapter;
import com.example.moneymanager.Adapter.BottomSheetDialog.InterfaceLoaiChi;
import com.example.moneymanager.Adapter.BottomSheetDialog.InterfaceLoaiThu;
import com.example.moneymanager.Database.DatabaseHelper;
import com.example.moneymanager.Model.LoaiChi;
import com.example.moneymanager.Model.LoaiThu;
import com.example.moneymanager.Model.ViTien;
import com.example.moneymanager.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class BottomSheetDialog_LoaiThu extends BottomSheetDialogFragment {

    private List<LoaiThu> list;
    private InterfaceLoaiThu anInterface;

    public BottomSheetDialog_LoaiThu(List<LoaiThu> list, InterfaceLoaiThu anInterface) {
        this.list = list;
        this.anInterface = anInterface;
    }

    @NotNull
    @Override
    public Dialog onCreateDialog(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {

        BottomSheetDialog bottomSheetDialog= (BottomSheetDialog) super.onCreateDialog(savedInstanceState);

        View view =LayoutInflater.from(getContext()).inflate(R.layout.bottom_sheet_layout_loaithu,null);
        bottomSheetDialog.setContentView(view);

        RecyclerView recyclerView = view.findViewById(R.id.frag_recyclerView_dialog_loaithu);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        DialogLoaiThuAdapter dialogLoaiThuAdapter = new DialogLoaiThuAdapter(list, new InterfaceLoaiThu() {
            @Override
            public void clickItem(LoaiThu loaiThu) {
                anInterface.clickItem(loaiThu);
            }
        });

        recyclerView.setAdapter(dialogLoaiThuAdapter);
        RecyclerView.ItemDecoration itemDecoration= new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);

        return bottomSheetDialog;
    }
}
