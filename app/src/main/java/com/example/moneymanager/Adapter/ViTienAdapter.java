//package com.example.moneymanager.Adapter;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.moneymanager.Adapter.BottomSheetDialog.DialogViTienAdapter;
//import com.example.moneymanager.Adapter.BottomSheetDialog.InterfaceViTien;
//import com.example.moneymanager.Model.ViTien;
//import com.example.moneymanager.R;
//
//import org.jetbrains.annotations.NotNull;
//
//import java.util.List;
//
//public class ViTienAdapter extends RecyclerView.Adapter<ViTienAdapter.ItemViewHolder> {
//    private List<ViTien> list;
//    private InterfaceViTien anInterface;
//
//    public ViTienAdapter(List<ViTien> list, InterfaceViTien anInterface) {
//        this.list = list;
//        this.anInterface = anInterface;
//    }
//
//    @NotNull
//    @Override
//    public ViTienAdapter.ItemViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
//        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_list_vi_tien,parent,false);
//        return new ViTienAdapter.ItemViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull @NotNull ViTienAdapter.ItemViewHolder holder, int position) {
//        ViTien viTien=list.get(position);
//        if(viTien==null){
//            return;
//        }
//        holder.title.setText("Ten vi: " + viTien.getName());
//        holder.content.setText("So tien: " + viTien.getMoney());
//        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                anInterface.clickItem(viTien);
//            }
//        });
//    }
//
//    @Override
//    public int getItemCount() {
//        if(list!= null){
//            return list.size();
//        }
//        return 0;
//    }
//
//    public void updateData(List<ViTien> list) {
//        this.list = list;
//        notifyDataSetChanged();
//    }
//
//    public class ItemViewHolder extends RecyclerView.ViewHolder{
//        private final TextView title;
//        private final TextView content;
//        private final LinearLayout linearLayout;
//        public ItemViewHolder(@NonNull View itemView){
//            super(itemView);
//            title = itemView.findViewById(R.id.tv_vitien_title);
//            content = itemView.findViewById(R.id.tv_vitien_content);
//            linearLayout = itemView.findViewById(R.id.linearLayout_listVi);
//        }
//    }
//}
