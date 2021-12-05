package com.example.bab7_sqlite_tugas;

import android.app.Activity;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Sarimun> Sarimun;
    public CustomListAdapter(Activity activity, List<Sarimun> Sarimun) {
        this.activity = activity;
        this.Sarimun = Sarimun;
    }

    @Override
    public int getCount() {
        return Sarimun.size();
    }

    @Override
    public Object getItem(int location) {
        return Sarimun.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list, null);
        TextView nama_makanan = (TextView) convertView.findViewById(R.id.text_nama_makanan);
        TextView harga = (TextView) convertView.findViewById(R.id.text_harga);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.iconid);
        Sarimun m = Sarimun.get(position);
        nama_makanan.setText("Nama Makanan : "+ m.get_nama_makanan());
        harga.setText("Harga : "+ m.get_harga());

        return convertView;
    }
}
