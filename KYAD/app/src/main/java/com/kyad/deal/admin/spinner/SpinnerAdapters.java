package com.kyad.deal.admin.spinner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.google.android.material.imageview.ShapeableImageView;
import com.kyad.deal.R;

public class SpinnerAdapters extends BaseAdapter {
    Context context;
    int flags[];
    String[] countryNames;
    LayoutInflater inflter;

    public SpinnerAdapters(Context applicationContext, String[] countryNames, int[] flags) {
        this.context = applicationContext;
        this.flags = flags;
        this.countryNames = countryNames;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return flags.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.spinner_view, null);
        ShapeableImageView icon =  view.findViewById(R.id.image);
        TextView names = view.findViewById(R.id.text);
        icon.setImageResource(flags[i]);
        names.setText(countryNames[i]);
        return view;
    }
}
