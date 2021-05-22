package com.example.moneymanager.Adapter.BottomSheetDialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.moneymanager.Adapter.RecyclerViewVerticalAdapter;
import com.example.moneymanager.Model.LoaiChi;
import com.example.moneymanager.R;
import com.example.moneymanager.Model.ViTien;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class DialogViTienAdapter extends RecyclerView.Adapter<DialogViTienAdapter.ItemViewHolder> {
    private List<ViTien> list;
    private InterfaceViTien anInterface;

    public DialogViTienAdapter(List<ViTien> list, InterfaceViTien anInterface) {
        this.list = list;
        this.anInterface = anInterface;
    }

    @NotNull
    @Override
    public DialogViTienAdapter.ItemViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_dialog_vitien,parent,false);
        return new DialogViTienAdapter.ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull DialogViTienAdapter.ItemViewHolder holder, int position) {
        ViTien viTien=list.get(position);
        if(viTien==null){
            return;
        }
        holder.textView.setText(viTien.getName());
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anInterface.clickItem(viTien);
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
            textView = itemView.findViewById(R.id.text_dialogvitien);
        }
    }

}
