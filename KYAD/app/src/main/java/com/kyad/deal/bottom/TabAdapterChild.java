package com.kyad.deal.bottom;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.kyad.deal.top.BestDealsFragment;
import com.kyad.deal.top.NewDealsFragment;
import com.kyad.deal.top.StoresFragment;

public class TabAdapterChild extends FragmentPagerAdapter {
    private Context myContext;
    int totalTabs;

    public TabAdapterChild(Fragment browseFragment, FragmentManager parentFragment, int tabCount) {
        super(parentFragment);
        myContext = browseFragment.getContext();
        this.totalTabs = tabCount;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new BestDealsFragment();
            case 1:
                return new NewDealsFragment();
            case 2:
                return new StoresFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
