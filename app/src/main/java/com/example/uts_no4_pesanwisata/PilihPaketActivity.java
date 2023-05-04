package com.example.uts_no4_pesanwisata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class PilihPaketActivity extends AppCompatActivity {
    private String namaKota;
    private int imageKota;
    private ImageView ivImageKota;
    private TextView tvNamaKota;
    private Button btBackToPilihKota;
    private ListView lvPilihPaket;
    private ListPaketAdapter adPilihPaket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_paket);
        namaKota = getIntent().getStringExtra("eNamaKota");
        imageKota = getIntent().getIntExtra("eImageKota", 0);
        ivImageKota = findViewById(R.id.pilihPaket_ivImageKota);
        tvNamaKota = findViewById(R.id.pilihPaket_tvNamaKota);
        ivImageKota.setImageResource(imageKota);
        tvNamaKota.setText(namaKota);

        ArrayList<ListPaketItem> listPaket = new ArrayList<>();
        listPaket.add(new ListPaketItem(
                "Paket 1 Hari",
                " - Kawah Putih\n - Glamping Lakeside\n - RancaUpas Deer Conservation\n - Strawberry Farm\n - Dll.",
                "Rp 400.000"
                ));
        listPaket.add(new ListPaketItem(
                "Paket 2 Hari",
                " - Kawah Putih\n - Glamping Lakeside\n - RancaUpas Deer Conservation\n - Strawberry Farm\n - Dll.",
                "Rp 400.000"
                ));
        listPaket.add(new ListPaketItem(
                "Paket 3 Hari",
                " - Kawah Putih\n - Glamping Lakeside\n - RancaUpas Deer Conservation\n - Strawberry Farm\n - Dll.",
                "Rp 400.000"
                ));
        listPaket.add(new ListPaketItem(
                "Paket 4 Hari",
                " - Kawah Putih\n - Glamping Lakeside\n - RancaUpas Deer Conservation\n - Strawberry Farm\n - Dll.",
                "Rp 400.000"
                ));
        listPaket.add(new ListPaketItem(
                "Paket 5 Hari",
                " - Kawah Putih\n - Glamping Lakeside\n - RancaUpas Deer Conservation\n - Strawberry Farm\n - Dll.",
                "Rp 400.000"
                ));
        listPaket.add(new ListPaketItem(
                "Paket Honeymoon",
                " - Kawah Putih\n - Glamping Lakeside\n - RancaUpas Deer Conservation\n - Strawberry Farm\n - Dll.",
                "Rp 400.000"
                ));


        lvPilihPaket = findViewById(R.id.lvPilihPaket);
        adPilihPaket = new ListPaketAdapter(this.getApplicationContext(),
                R.layout.list_item_paket, listPaket);
        lvPilihPaket.setAdapter(adPilihPaket);
        lvPilihPaket.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(view.getContext(), PemesananActivity.class);
                intent.putExtra("eNamaPaket", listPaket.get(position).getNama());
                intent.putExtra("eHarga", listPaket.get(position).getHarga());
                intent.putExtra("eNamaKota", namaKota);
                startActivity(intent);
//                Toast.makeText(PilihPaketActivity.this, listPaket.get(position).getNama(), Toast.LENGTH_SHORT).show();
            }
        });

        btBackToPilihKota = findViewById(R.id.btBackToPilihKota);
        btBackToPilihKota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), PilihKotaActivity.class);
                startActivity(intent);
            }
        });
    }
}