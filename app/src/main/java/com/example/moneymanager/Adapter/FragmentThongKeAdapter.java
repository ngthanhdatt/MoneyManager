package com.example.moneymanager.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.moneymanager.Fragment.ThongKe.ThongKe_ChiFragment;
import com.example.moneymanager.Fragment.ThongKe.ThongKe_ThuFragment;

public class FragmentThongKeAdapter extends FragmentStateAdapter {
    private final ThongKe_ChiFragment thongKe_chiFragment = new ThongKe_ChiFragment();
    private final ThongKe_ThuFragment thongKe_thuFragment = new ThongKe_ThuFragment();

    public FragmentThongKeAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if(position==0){
            return thongKe_thuFragment;
        } else {
            return thongKe_chiFragment;
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }

}
