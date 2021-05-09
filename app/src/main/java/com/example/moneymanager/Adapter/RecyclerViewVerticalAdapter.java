package com.example.moneymanager.Adapter;

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

import com.example.moneymanager.R;
import com.example.moneymanager.Model.ViTien;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RecyclerViewVerticalAdapter extends RecyclerView.Adapter<RecyclerViewVerticalAdapter.ViewHolder> {
    private final List<ViTien> list;

    public RecyclerViewVerticalAdapter(List<ViTien> list) {
        this.list = list;
    }

    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v =LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_list_vi_tien, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ViTien vi = list.get(position);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private final ImageView donvi;
        private final TextView title;
        private final TextView content;


        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            donvi = itemView.findViewById(R.id.ivDonvi);
            title = itemView.findViewById(R.id.tv_vitien_title);
            content = itemView.findViewById(R.id.tv_vitien_content);
        }
    }
}
