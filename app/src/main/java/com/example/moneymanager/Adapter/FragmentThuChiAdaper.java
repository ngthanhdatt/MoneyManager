package com.example.moneymanager.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.moneymanager.Fragment.ThuChi.Chi_HangNgayFragment;
import com.example.moneymanager.Fragment.ThuChi.ThuChi_HangNgayFragment;
import com.example.moneymanager.Fragment.ThuChi.ThuChi_NgayFragment;
import com.example.moneymanager.Fragment.ThuChi.ThuChi_ThangFragment;
import com.example.moneymanager.Fragment.ThuChi.ThuChi_TuanFragment;
import com.example.moneymanager.Fragment.ThuChi.Thu_HangNgayFragment;

public class FragmentThuChiAdaper extends FragmentStateAdapter{
    private final Thu_HangNgayFragment thuHangNgayFragment= new Thu_HangNgayFragment();
    private final Chi_HangNgayFragment chiHangNgayFragment = new Chi_HangNgayFragment();

    public FragmentThuChiAdaper(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 1:
                return chiHangNgayFragment;
            default:
                return thuHangNgayFragment;
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
