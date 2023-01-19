package com.kyad.deal.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseManager {
    private Context context;
    private SQLiteDatabase database;
    private DatabaseHandler databaseHandler;

    public DatabaseManager(Context c) {
        this.context = c;
    }

    public DatabaseManager open() throws SQLException {
        this.databaseHandler = new DatabaseHandler(this.context);
        this.database = this.databaseHandler.getWritableDatabase();
        return this;
    }

    public void close() {
        this.databaseHandler.close();
    }

    public long insertData(String store, int logo, String product, String discount,
               String startDate, String  endDate,String image,
               String des,String dealType, String proType,int isFav,int isShoplist) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(DatabaseHandler.STORE_NAME, store);
        contentValue.put(DatabaseHandler.Logo, logo);
        contentValue.put(DatabaseHandler.Product_Name, product);
        contentValue.put(DatabaseHandler.Discount, discount);
        contentValue.put(DatabaseHandler.Start_Date, startDate);
        contentValue.put(DatabaseHandler.Rnd_Date, endDate);
        contentValue.put(DatabaseHandler.Image, image);
        contentValue.put(DatabaseHandler.Descriotions, des);
        contentValue.put(DatabaseHandler.Deals_Type, dealType);
        contentValue.put(DatabaseHandler.Product_Type, proType);
        contentValue.put(DatabaseHandler.Isfavourites, isFav);
        contentValue.put(DatabaseHandler.IsInshoplist, isShoplist);

        return this.database.insert(DatabaseHandler.TABLE_NAME, null, contentValue);
    }


    public Cursor getData() {
        Cursor cursor = this.database.query(DatabaseHandler.TABLE_NAME, new String[]{
                DatabaseHandler.ID, DatabaseHandler.STORE_NAME,
                DatabaseHandler.Logo, DatabaseHandler.Product_Name,
                DatabaseHandler.Discount, DatabaseHandler.Start_Date,
                DatabaseHandler.Rnd_Date, DatabaseHandler.Image,
                DatabaseHandler.Descriotions, DatabaseHandler.Deals_Type,
                DatabaseHandler.Product_Type, DatabaseHandler.Isfavourites,
                DatabaseHandler.IsInshoplist}, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

//    public Cursor getByID(String GetID) {
//        String selection =DatabaseHandler.ID + " = ?";
//        String[] selectionArgs = { GetID };
//        Cursor cursor = this.database.query(DatabaseHandler.TABLE_NAME, new String[]{DatabaseHandler.ID, DatabaseHandler.First_Name,
//                DatabaseHandler.Last_Name, DatabaseHandler.Course, DatabaseHandler.Credit, DatabaseHandler.Marks}, selection, selectionArgs, null, null, null);
//        if (cursor != null) {
//            cursor.moveToFirst();
//        }
//        return cursor;
//    }

//
//    public Cursor getByCode(String code) {
//        String selection =DatabaseHandler.Course + " = ?";
//        String[] selectionArgs = { code };
//        Cursor cursor = this.database.query(DatabaseHandler.TABLE_NAME, new String[]{DatabaseHandler.ID, DatabaseHandler.First_Name,
//                DatabaseHandler.Last_Name, DatabaseHandler.Course, DatabaseHandler.Credit, DatabaseHandler.Marks}, selection, selectionArgs, null, null, null);
//        if (cursor != null) {
//            cursor.moveToFirst();
//        }
//        return cursor;
//    }
}
