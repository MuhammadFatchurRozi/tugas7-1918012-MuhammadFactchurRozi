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

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainCreate extends AppCompatActivity {
    private MyDatabase db;
    private EditText Enama_makanan, Eharga;
    private String Snama_makanan, Sharga;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);
        db = new MyDatabase(this);

        Enama_makanan = (EditText) findViewById(R.id.create_nama_makanan);
        Eharga = (EditText) findViewById(R.id.create_harga);
        Button btnCreate = (Button) findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama_makanan = String.valueOf(Enama_makanan.getText());
                Sharga = String.valueOf(Eharga.getText());
                if (Snama_makanan.equals("")){
                    Enama_makanan.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan Isi Menu Makanan Anda", Toast.LENGTH_SHORT).show();
                }
                else if (Sharga.equals("")) {
                    Eharga.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan Masukan Harga Makanan", Toast.LENGTH_SHORT).show();
                }
                else {
                    Enama_makanan.setText("");
                    Eharga.setText("");
                    Toast.makeText(MainCreate.this, "Data telah ditambah", Toast.LENGTH_SHORT).show();
                    db.CreateSarimun(new Sarimun(null, Snama_makanan, Sharga));

                    Intent a = new Intent(MainCreate.this, MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}

