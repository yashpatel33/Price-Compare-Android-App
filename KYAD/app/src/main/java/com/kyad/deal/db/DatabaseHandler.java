package com.kyad.deal.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final String DB_NAME = "KYAD";
    private static final int DB_VERSION = 1;
    public static final String TABLE_NAME = "ECOM";

    public static final String ID = "ID";
    public static final String STORE_NAME= "STORE_NAME";
    public static final String Product_Name= "Product_Name";

    public static final String Logo= "Logo";
    public static final String Start_Date = "Start_Date";
    public static final String Rnd_Date= "Rnd_Date";

    public static final String Image= "Image";
    public static final String Descriotions= "Descriotions";
    public static final String Deals_Type= "Deals_Type";

    public static final String Product_Type= "Product_Type";
    public static final String Isfavourites = "isfavourites";
    public static final String IsInshoplist= "isInshoplist";

    public static final String Discount= "discount";


    public  DatabaseHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " (" +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                STORE_NAME + " TEXT, " +
                Product_Name + " TEXT, " +
                Logo     + " INTEGER, " +
                Start_Date     + " TEXT, " +
                Rnd_Date     + " TEXT, " +
                Image     + " TEXT, " +
                Descriotions     + " TEXT, " +
                Deals_Type     + " TEXT, " +
                Product_Type     + " TEXT, " +
                Isfavourites     + " INTEGER, " +
                IsInshoplist     + " INTEGER, " +
                Discount + " INTEGER); ";
        db.execSQL(query);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS TABLE_NAME");
        onCreate(db);
    }

}
