package com.example.moneymanager.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.moneymanager.Fragment.ThuChi.Chi_HangNgayFragment;
import com.example.moneymanager.Fragment.ThuChi.Thu_HangNgayFragment;

public class FragmentHangNgayAdapter extends FragmentStateAdapter {
    private final Thu_HangNgayFragment thu_hangNgayFragment = new Thu_HangNgayFragment();
    private final Chi_HangNgayFragment chi_hangNgayFragment = new Chi_HangNgayFragment();

    public FragmentHangNgayAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if(position==0){
            return thu_hangNgayFragment;
        } else {
            return chi_hangNgayFragment;
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
