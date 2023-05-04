package com.example.uts_no4_pesanwisata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class PemesananActivity extends AppCompatActivity {
    String harga, namaKota, namaPaket;
    TextView tvNamaKota, tvNamaPaket;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pemesanan);
        harga = getIntent().getStringExtra("eHarga");
        namaKota = getIntent().getStringExtra("eNamaKota");
        namaPaket = getIntent().getStringExtra("eNamaPaket");

        tvNamaKota = findViewById(R.id.pemesanan_tvNamaKota);
        tvNamaPaket = findViewById(R.id.pemesanan_tvNamaPaket);

        tvNamaKota.setText(namaKota);
        tvNamaPaket.setText(namaPaket);

        if (savedInstanceState == null) {
            Bundle args = new Bundle();
            args.putString("eHargaPaket", harga);
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragmentContainerView, FragmentPesan.newInstance(args));
            fragmentTransaction.commit();
        }


    }
}