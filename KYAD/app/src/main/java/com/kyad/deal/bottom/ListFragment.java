package com.kyad.deal.bottom;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.kyad.deal.R;
import com.kyad.deal.list.ListTabAdapterChild;

public class ListFragment extends Fragment {
    TabLayout tabLayout;
    ViewPager viewPager;

    public ListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list, container, false);

        tabLayout = (TabLayout) v.findViewById(R.id.list_tabLayout);
        viewPager = (ViewPager) v.findViewById(R.id.list_viewPager);

        tabLayout.addTab(tabLayout.newTab().setText(R.string.favorite));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.shopping_list));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ListTabAdapterChild adapter = new ListTabAdapterChild(this, getChildFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return v;
    }


}
