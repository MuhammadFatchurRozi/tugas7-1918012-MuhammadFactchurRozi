package com.example.bab7_sqlite_tugas;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static String DATABASE_NAME = "db_sarimun";

    private static final String tb_sarimun = "tb_sarimun";
    private static final String tb_sarimun_id = "id";
    private static final String tb_sarimun_nama_makanan = "nama_makanan";
    private static final String tb_sarimun_harga = "harga";

    private static final String CREATE_TABLE_SARIMUN = "CREATE TABLE " +
            tb_sarimun +"("
            + tb_sarimun_id + " INTEGER PRIMARY KEY ,"
            + tb_sarimun_nama_makanan + " TEXT ,"
            + tb_sarimun_harga + " TEXT " + ")";

    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null , DATABASE_VERSION);     }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_SARIMUN);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void CreateSarimun(Sarimun data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_sarimun_id, data.get_id());
        values.put(tb_sarimun_nama_makanan, data.get_nama_makanan());
        values.put(tb_sarimun_harga, data.get_harga());
        db.insert(tb_sarimun, null, values);
        db.close();
    }
    public List<Sarimun> ReadSarimun() {
        List<Sarimun> listMn = new ArrayList<Sarimun>();
        String selectQuery = "SELECT  * FROM " + tb_sarimun;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Sarimun data = new Sarimun();
                data.set_id(cursor.getString(0));
                data.set_nama_makanan(cursor.getString(1));
                data.set_harga(cursor.getString(2));
                listMn.add(data);
            }
            while (cursor.moveToNext());
        }
        db.close();
        return listMn;
    }

    public int UpdateSarimun (Sarimun data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_sarimun_nama_makanan, data.get_nama_makanan());
        values.put(tb_sarimun_harga, data.get_harga());

        return db.update(tb_sarimun, values, tb_sarimun_id + " = ?", new String[]{String.valueOf((data.get_id()))});     }
    public void DeleteSarimun(Sarimun data){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_sarimun,tb_sarimun_id+ " = ?", new String[]{String.valueOf(data.get_id())});
        db.close();
    }
}

