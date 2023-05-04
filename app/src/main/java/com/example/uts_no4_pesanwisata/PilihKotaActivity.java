package com.example.uts_no4_pesanwisata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class PilihKotaActivity extends AppCompatActivity {
    private GridView gvKota;
    private GridKotaAdapter adKota;
    private String[] listNamaKota = {
            "jakarta", "bandung", "surabaya", "bali"
    };
    private ArrayList<GridKotaItem> listKota;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_kota);
        listKota = new ArrayList<>();
        for (String namaKota: listNamaKota) {
        listKota.add(new GridKotaItem(namaKota, getResources().getIdentifier(
                namaKota, "drawable", getPackageName())));
        }

        gvKota = findViewById(R.id.gvKotaTujuan);
        adKota = new GridKotaAdapter(this.getApplicationContext(),
                R.layout.grid_item_kota, listKota);

        gvKota.setAdapter(adKota);
        gvKota.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(view.getContext(), PilihPaketActivity.class);
                intent.putExtra("eNamaKota", listKota.get(position).getNamaKota());
                intent.putExtra("eImageKota", listKota.get(position).getImageKota());
                startActivity(intent);
            }
        });
    }
}