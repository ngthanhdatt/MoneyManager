package com.example.moneymanager.Fragment.ThuChi;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.moneymanager.Adapter.FragmentHangNgayAdapter;
import com.example.moneymanager.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class ThuChi_HangNgayFragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager2 viewPager2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_thu_chi__hang_ngay, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tabLayout = view.findViewById(R.id.frag_tabLayout_thu_hangngay);
        viewPager2 = view.findViewById(R.id.frag_viewPager_thu_hangngay);

        FragmentHangNgayAdapter fragmentHangNgayAdapter = new FragmentHangNgayAdapter(this.getActivity());
        viewPager2.setAdapter(fragmentHangNgayAdapter);

        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if(position == 0){
                    tab.setText("Thu");
                } else if(position == 1){
                    tab.setText("Chi");
                }
            }
        }).attach();
    }
}