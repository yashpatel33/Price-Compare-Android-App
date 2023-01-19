package com.kyad.deal.top;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kyad.deal.R;
import com.kyad.deal.db.DatabaseManager;

import static com.kyad.deal.admin.AddproductActivity.logo;

public class StoresFragment extends Fragment {
    private DatabaseManager db;
    RecyclerView recyclerView;

    public StoresFragment() {
// Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root =  inflater.inflate(R.layout.fragment_stores, container, false);

        recyclerView = (RecyclerView) root.findViewById(R.id.recyclerView);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
//        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        StoreAdapter myAdapter = new StoreAdapter(logo);
        recyclerView.setAdapter(myAdapter);
        return  root;
    }

}