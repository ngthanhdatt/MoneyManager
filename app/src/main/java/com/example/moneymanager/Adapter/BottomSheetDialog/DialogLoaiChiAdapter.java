package com.example.moneymanager.Adapter.BottomSheetDialog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moneymanager.Model.LoaiChi;
import com.example.moneymanager.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class DialogLoaiChiAdapter extends RecyclerView.Adapter<DialogLoaiChiAdapter.ItemViewHolder>{

    private List<LoaiChi> list;
    private InterfaceLoaiChi anInterface;

    public DialogLoaiChiAdapter(List<LoaiChi> list, InterfaceLoaiChi anInterface) {
        this.list = list;
        this.anInterface = anInterface;
    }

    @NotNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_dialog_loaichi,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ItemViewHolder holder, int position) {
        LoaiChi loaiChi=list.get(position);
        if(loaiChi==null){
            return;
        }
        holder.textView.setText(loaiChi.getName());
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anInterface.clickItem(loaiChi);
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
            textView = itemView.findViewById(R.id.text_dialogloaichi);
        }
    }
}
