package com.example.moneymanager.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.moneymanager.Fragment.CaiDatFragment;
import com.example.moneymanager.Fragment.ThongKe.ThongKeFragment;
import com.example.moneymanager.Fragment.ThuChi.ThuChiFragment;
//import com.example.moneymanager.Fragment.ThuChi.ThuChi_HangNgayFragment;
import com.example.moneymanager.Fragment.ViTien.ViTienFragment;

public class FragmentAdapter extends FragmentStateAdapter {

    public FragmentAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 1:
                return new ThongKeFragment();
            case 2:
                return new ViTienFragment();
            case 3:
                return new CaiDatFragment();
            default:
                return new ThuChiFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
