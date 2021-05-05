package com.example.moneymanager.Fragment.ThongKe;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.moneymanager.Adapter.FragmentThongKeAdapter;
import com.example.moneymanager.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class ThongKeFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager2 viewPager2;

    public ThongKeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_thong_ke, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tabLayout = view.findViewById(R.id.frag_tabLayout_thongke);
        viewPager2 = view.findViewById(R.id.frag_viewPager_thongke);


        FragmentThongKeAdapter fragmentThongKeAdapter = new FragmentThongKeAdapter(this.getActivity());
        viewPager2.setAdapter(fragmentThongKeAdapter);

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