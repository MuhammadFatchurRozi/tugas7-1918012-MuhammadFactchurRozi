package com.example.bab7_sqlite_tugas;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
public class MainUpdel extends AppCompatActivity {
    private MyDatabase db;
    private String Sid, Snama_makanan, Sharga;
    private EditText Enama_makanan, Eharga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updel);
        db = new MyDatabase(this);

        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Snama_makanan = i.getStringExtra("Inama_makanan");
        Sharga = i.getStringExtra("Iharga");

        Enama_makanan = (EditText) findViewById(R.id.updel_nama_makanan);
        Eharga = (EditText) findViewById(R.id.updel_harga);
        Enama_makanan.setText(Snama_makanan);
        Eharga.setText(Sharga);

        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama_makanan = String.valueOf(Enama_makanan.getText());
                Sharga = String.valueOf(Eharga.getText());
                if (Snama_makanan.equals("")){
                    Enama_makanan.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan Masukan Nama Makanan", Toast.LENGTH_SHORT).show();
                }
                else if (Sharga.equals("")){
                    Eharga.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan Masukan Harga Makanan", Toast.LENGTH_SHORT).show();
                }
                else {
                    db.UpdateSarimun(new Sarimun(Sid, Snama_makanan, Sharga));
                    Toast.makeText(MainUpdel.this, "Data telah diupdate", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });

        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteSarimun(new Sarimun(Sid, Snama_makanan, Sharga));
                Toast.makeText(MainUpdel.this, "Data telah dihapus", Toast.LENGTH_SHORT).show();                 finish();
            }
        });
    }
}

