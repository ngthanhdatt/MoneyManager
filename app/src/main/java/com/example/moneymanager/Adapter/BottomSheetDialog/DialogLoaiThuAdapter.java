package com.example.moneymanager.Adapter.BottomSheetDialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moneymanager.Model.LoaiChi;
import com.example.moneymanager.Model.LoaiThu;
import com.example.moneymanager.Model.ViTien;
import com.example.moneymanager.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class DialogLoaiThuAdapter extends RecyclerView.Adapter<DialogLoaiThuAdapter.ItemViewHolder>{
    private List<LoaiThu> list;
    private InterfaceLoaiThu anInterface;

    public DialogLoaiThuAdapter(List<LoaiThu> list, InterfaceLoaiThu anInterface) {
        this.list = list;
        this.anInterface = anInterface;
    }

    @NotNull
    @Override
    public DialogLoaiThuAdapter.ItemViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_dialog_loaithu,parent,false);
        return new DialogLoaiThuAdapter.ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull DialogLoaiThuAdapter.ItemViewHolder holder, int position) {
        LoaiThu loaiThu=list.get(position);
        if(loaiThu==null){
            return;
        }
        holder.textView.setText(loaiThu.getName());
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anInterface.clickItem(loaiThu);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(list!= null){
            return list.size();
        }
        return 0;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;
        public ItemViewHolder(@NonNull View itemView){
            super(itemView);
            textView = itemView.findViewById(R.id.text_dialogloaithu);
        }
    }
}
