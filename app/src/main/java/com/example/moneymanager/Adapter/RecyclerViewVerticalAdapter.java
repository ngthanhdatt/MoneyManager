package com.example.moneymanager.Adapter;

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

import com.example.moneymanager.R;
import com.example.moneymanager.Model.ViTien;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewVerticalAdapter extends RecyclerView.Adapter<RecyclerViewVerticalAdapter.ViewHolder> {
    private final List<ViTien> listVitien;
    private Context context;

    public RecyclerViewVerticalAdapter() {
        this.listVitien = new ArrayList<>();
    }

    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_list_vi_tien, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewVerticalAdapter.ViewHolder holder, int position) {
        ViTien vi = listVitien.get(position);
        holder.title.setText("title" + vi.getName());
        holder.content.setText("content" + vi.getMoney());
        holder.setClickListener(new ViewHolder.ClickListener() {
            @Override
            public void onClickListener(int position, View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return (listVitien == null) ? 0 : listVitien.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView title;
        private final TextView content;
        private ClickListener clickListener;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_vitien_title);
            content = itemView.findViewById(R.id.tv_vitien_content);
            itemView.setOnClickListener(this);
        }


        public interface ClickListener {
            void onClickListener(int position, View v);
        }

        @Override
        public void onClick(View v) {
            clickListener.onClickListener(getAdapterPosition(), v);
        }

        public void setClickListener(ClickListener listener) {
            this.clickListener = listener;
        }
    }

}
