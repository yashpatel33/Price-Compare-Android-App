package com.kyad.deal.list;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kyad.deal.R;
import com.kyad.deal.db.DatabaseHandler;
import com.kyad.deal.db.DatabaseManager;
import com.kyad.deal.top.Model;
import com.kyad.deal.top.MyAdapter;
import com.kyad.deal.top.StoreAdapter;

import java.util.ArrayList;

import static com.kyad.deal.admin.AddproductActivity.logo;

public class FavoriteFragment extends Fragment {
    private DatabaseManager db;
    RecyclerView recyclerView;
    public FavoriteFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root= inflater.inflate(R.layout.fragment_favorite, container, false);
        db = new DatabaseManager(getContext());
        db.open();
        recyclerView = (RecyclerView) root.findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        ShowRecord();

        return  root;
    }


    @SuppressLint("Range")
    public void ShowRecord() {
        Cursor cursor = db.getData();
        ArrayList<Model> modelList = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                Log.i("asd", cursor.getString(1));
                Model model = new Model();

                model.setID(Integer.parseInt(cursor.getString(cursor.getColumnIndex(DatabaseHandler.ID))));

                model.setSTORE_NAME(cursor.getString(cursor.getColumnIndex(DatabaseHandler.STORE_NAME)));
                model.setProduct_Name(cursor.getString(cursor.getColumnIndex(DatabaseHandler.Product_Name)));
                model.setLogo(Integer.parseInt(cursor.getString(cursor.getColumnIndex(DatabaseHandler.Logo))));

                model.setStart_Date(cursor.getString(cursor.getColumnIndex(DatabaseHandler.Start_Date)));
                model.setRnd_Date(cursor.getString(cursor.getColumnIndex(DatabaseHandler.Rnd_Date)));
                model.setImage(cursor.getString(cursor.getColumnIndex(DatabaseHandler.Image)));

                model.setDescriotions(cursor.getString(cursor.getColumnIndex(DatabaseHandler.Descriotions)));
                model.setDeals_Type(cursor.getString(cursor.getColumnIndex(DatabaseHandler.Deals_Type)));
                model.setProduct_Type(cursor.getString(cursor.getColumnIndex(DatabaseHandler.Product_Type)));

                model.setIsfavourites(Integer.parseInt(cursor.getString(cursor.getColumnIndex(DatabaseHandler.Isfavourites))));
                model.setIsInshoplist(Integer.parseInt(cursor.getString(cursor.getColumnIndex(DatabaseHandler.IsInshoplist))));
                model.setDiscount(Integer.parseInt(cursor.getString(cursor.getColumnIndex(DatabaseHandler.Discount))));

                modelList.add(model);
            } while (cursor.moveToNext());
        }
        if (modelList.size() != 0) {
            // bind adapter
            MyAdapter myAdapter = new MyAdapter(modelList,0);
            recyclerView.setAdapter(myAdapter);
        } else {
            Toast.makeText(getContext(), "No record found", Toast.LENGTH_SHORT).show();
        }
    }

}
