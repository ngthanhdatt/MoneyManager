package com.example.moneymanager.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moneymanager.Edit_Chi;
import com.example.moneymanager.Edit_Thu;
import com.example.moneymanager.Model.Chi;
import com.example.moneymanager.Model.Thu;
import com.example.moneymanager.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewChiHangNgayAdapter extends RecyclerView.Adapter<RecyclerViewChiHangNgayAdapter.ViewHolder>{
    private List<Chi> listChi;
    private Context context;
    private static final int MENU_ITEM_EDIT = 222;
    private static final int MENU_ITEM_DELETE = 444;

    public RecyclerViewChiHangNgayAdapter() {
        this.listChi = new ArrayList<>();
    }

    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_detail__hang_ngay, parent, false);
        return new RecyclerViewChiHangNgayAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerViewChiHangNgayAdapter.ViewHolder holder, int position) {
        Chi chi = listChi.get(position);
        holder.ngay.setText("Ngày: " + chi.getThoiGian());
        holder.tien.setText("Số tiền: " + chi.getSotien());
        holder.theloai.setText("Thể loại: " + chi.getLoaiChi().getName());
        holder.vi.setText("Ví: " + chi.getViTien().getName());

        holder.setClickListener(new ViewHolder.ClickListener() {
            @Override
            public void onClickListener(int position, View v) {
                Intent intent = new Intent(context, Edit_Chi.class);
//                intent.putExtra("title", vi.getName());
//                String tien = String.valueOf(vi.getMoney());
//                intent.putExtra("content", tien);
                intent.putExtra("chi", chi);
                context.startActivity(intent);
            }
        });
    }



    // update data chi
    public void updateDataChi(List<Chi> chi) {
        this.listChi = chi;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return (listChi == null) ? 0 : listChi.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView ngay, tien, theloai, vi;
        private ClickListener clickListener;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            ngay = itemView.findViewById(R.id.tv_detail_ngay_ngay);
            tien = itemView.findViewById(R.id.tv_detail_ngay_tien);
            theloai = itemView.findViewById(R.id.tv_detail_ngay_theloai);
            vi = itemView.findViewById(R.id.tv_detail_ngay_vi);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            clickListener.onClickListener(getAdapterPosition(), v);
        }

        public void setClickListener(ClickListener listener) {
            this.clickListener = listener;
        }

        public interface ClickListener {
            void onClickListener(int position, View v);
        }
    }
}
