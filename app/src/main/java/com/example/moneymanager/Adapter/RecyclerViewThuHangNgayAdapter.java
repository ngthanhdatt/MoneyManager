package com.example.moneymanager.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moneymanager.Model.Thu;
import com.example.moneymanager.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewThuHangNgayAdapter extends RecyclerView.Adapter<RecyclerViewThuHangNgayAdapter.ViewHolder>{
    private List<Thu> listThu;
    private Context context;
    private static final int MENU_ITEM_EDIT = 222;
    private static final int MENU_ITEM_DELETE = 444;

    public RecyclerViewThuHangNgayAdapter() {
        this.listThu = new ArrayList<>();
    }

    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_detail__hang_ngay, parent, false);
        return new RecyclerViewThuHangNgayAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerViewThuHangNgayAdapter.ViewHolder holder, int position) {
        Thu thu = listThu.get(position);
        holder.ngay.setText("Ngày: " + thu.getThoiGian());
        holder.tien.setText("Số tiền: " + thu.getSotien());
        holder.theloai.setText("Thể loại: " + thu.getLoaiThu().getName());
        holder.vi.setText("Ví: " + thu.getViTien().getName());

        holder.setClickListener(new ViewHolder.ClickListener() {
            @Override
            public void onClickListener(int position, View v) {
//                Intent intent = new Intent(context, Edit_ViTien.class);
//                intent.putExtra("title", vi.getName());
//                String tien = String.valueOf(vi.getMoney());
//                intent.putExtra("content", tien);
//                intent.putExtra("vi", vi);
//                context.startActivity(intent);
            }
        });
    }



    // update data thu
    public void updateDataThu(List<Thu> thu) {
        this.listThu = thu;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return (listThu == null) ? 0 : listThu.size();
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
