package com.example.bab7_sqlite_tugas;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainRead extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<Sarimun> ListMenu = new ArrayList<Sarimun>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, ListMenu);
        mListView = (ListView) findViewById(R.id.list_menu);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListMenu.clear();

        List<Sarimun> Sarimun = db.ReadSarimun();
        for (Sarimun mn : Sarimun) {
            Sarimun baru = new Sarimun();
            baru.set_id(mn.get_id());
            baru.set_nama_makanan(mn.get_nama_makanan());
            baru.set_harga(mn.get_harga());
            ListMenu.add(baru);

            if ((ListMenu.isEmpty()))
                Toast.makeText(MainRead.this, "Silahkan Masukan Data Dengan Benar", Toast.LENGTH_SHORT).show();             else {
            }
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        Sarimun detailMn = (Sarimun)o;
        String Sid = detailMn.get_id();
        String Snama_makanan = detailMn.get_nama_makanan();
        String Sharga = detailMn.get_harga();

        Intent goUpdel = new Intent(MainRead.this, MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Inama_makanan", Snama_makanan);
        goUpdel.putExtra("Iharga", Sharga);
        startActivity(goUpdel);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ListMenu.clear();
        mListView.setAdapter(adapter_off);

        List<Sarimun> Sarimun = db.ReadSarimun();
        for (Sarimun mn : Sarimun) {
            Sarimun baru = new Sarimun();
            baru.set_id(mn.get_id());
            baru.set_nama_makanan(mn.get_nama_makanan());
            baru.set_harga(mn.get_harga());
            ListMenu.add(baru);

            if ((ListMenu.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data", Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}

