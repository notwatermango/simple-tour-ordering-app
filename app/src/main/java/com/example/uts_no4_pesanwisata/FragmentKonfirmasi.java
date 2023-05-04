package com.example.uts_no4_pesanwisata;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FragmentKonfirmasi extends Fragment {
    public static FragmentKonfirmasi newInstance(Bundle args) {
        FragmentKonfirmasi fragment = new FragmentKonfirmasi();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_konfirmasi, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView tvNama, tvEmail, tvPhone, tvJenisKelamin, tvJumlahPaket, tvHargaPaket, tvTotalHarga;
        tvNama = view.findViewById(R.id.konfirmasi_tvNama);
        tvEmail = view.findViewById(R.id.konfirmasi_tvEmail);
        tvPhone = view.findViewById(R.id.konfirmasi_tvPhone);
        tvJenisKelamin = view.findViewById(R.id.konfirmasi_tvJenisKelamin);
        tvJumlahPaket = view.findViewById(R.id.konfirmasi_tvJumlahPaket);
        tvHargaPaket = view.findViewById(R.id.konfirmasi_tvHargaPaket);
        tvTotalHarga = view.findViewById(R.id.konfirmasi_tvTotalHarga);

        Bundle extras = getArguments();
        if (extras != null) {
            String nama, email, phone, jenisKelamin, hargaPaket, totalHarga, jumlahPaket;
            nama = extras.getString("eNama");
            email = extras.getString("eEmail");
            phone = extras.getString("ePhone");
            jenisKelamin = extras.getString("eJenisKelamin");
            jumlahPaket = extras.getString("eJumlahPaket");
            hargaPaket = extras.getString("eHargaPaket");

            int i_jumlahPaket = Integer.parseInt(jumlahPaket);
            int i_hargaPaket = Integer.parseInt(hargaPaket.replaceAll("\\D",""));
            int i_totalHarga = i_jumlahPaket * i_hargaPaket;
            // format Rp
            totalHarga = String.format("%,d", i_totalHarga);
            totalHarga = totalHarga.replaceAll(",", ".");
            totalHarga = "Rp " + totalHarga;

            tvNama.setText(nama);
            tvEmail.setText(email);
            tvPhone.setText(phone);
            tvJenisKelamin.setText(jenisKelamin);
            tvJumlahPaket.setText(jumlahPaket);
            tvHargaPaket.setText(hargaPaket);
            tvTotalHarga.setText(totalHarga);
        }

        Button btBatal = view.findViewById(R.id.pemesanan_btBatal);
        btBatal.setOnClickListener(v -> {
            FragmentManager fragmentManager = getParentFragmentManager();
            fragmentManager.popBackStack();
        });

        Button btKonfirmasi = view.findViewById(R.id.pemesanan_btKonfirmasi);
        btKonfirmasi.setOnClickListener(v -> {
            FragmentManager fragmentManager = getParentFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.replace(R.id.fragmentContainerView, FragmentOrderSuccess.newInstance());
            fragmentTransaction.commit();
        });
    }
}