package com.kyad.deal.list;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.kyad.deal.bottom.SearchFragment;
import com.kyad.deal.top.BestDealsFragment;

public class ListTabAdapterChild extends FragmentPagerAdapter {
    private Context myContext;
    int totalTabs;

    public ListTabAdapterChild(Fragment browseFragment, FragmentManager parentFragment, int tabCount) {
        super(parentFragment);
        myContext = browseFragment.getContext();
        this.totalTabs = tabCount;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new FavoriteFragment();
            case 1:
                return new ShoppingListFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
