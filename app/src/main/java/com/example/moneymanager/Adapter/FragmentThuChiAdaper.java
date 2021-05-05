package com.example.moneymanager.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.moneymanager.Fragment.ThuChi.ThuChi_HangNgayFragment;
import com.example.moneymanager.Fragment.ThuChi.ThuChi_NgayFragment;
import com.example.moneymanager.Fragment.ThuChi.ThuChi_ThangFragment;
import com.example.moneymanager.Fragment.ThuChi.ThuChi_TuanFragment;

public class FragmentThuChiAdaper extends FragmentStateAdapter{
    private final ThuChi_HangNgayFragment thuChi_hangNgayFragment = new ThuChi_HangNgayFragment();
    private final ThuChi_NgayFragment thuChi_ngayFragment = new ThuChi_NgayFragment();
    private final ThuChi_TuanFragment thuChi_tuanFragment = new ThuChi_TuanFragment();
    private final ThuChi_ThangFragment thuChi_thangFragment = new ThuChi_ThangFragment();

    public FragmentThuChiAdaper(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 1:
                return thuChi_ngayFragment;
            case 2:
                return thuChi_tuanFragment;
            case 3:
                return thuChi_thangFragment;
            default:
                return thuChi_hangNgayFragment;
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
