package com.example.bab7_sqlite_tugas;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Sarimun{
    private String _id, _nama_makanan, _harga;

    public Sarimun   (String id, String nama_makanan, String harga) {
        this._id = id;
        this._nama_makanan = nama_makanan;
        this._harga = harga;
    }
    public Sarimun() {
    }      public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String get_nama_makanan() {
        return _nama_makanan;
    }
    public void set_nama_makanan(String _nama_makanan) {
        this._nama_makanan = _nama_makanan;
    }
    public String get_harga() {
        return _harga;
    }
    public void set_harga(String _harga) {
        this._harga = _harga;
    }
}

