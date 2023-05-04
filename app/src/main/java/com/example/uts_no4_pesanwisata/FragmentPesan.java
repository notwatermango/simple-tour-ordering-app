package com.example.uts_no4_pesanwisata;

import android.content.Intent;
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
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class FragmentPesan extends Fragment {
    public static FragmentPesan newInstance(Bundle args) {
        FragmentPesan fragment = new FragmentPesan();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pesan, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText etNama = view.findViewById(R.id.pemesanan_etNama);
        EditText etEmail = view.findViewById(R.id.pemesanan_etEmail);
        EditText etPhone = view.findViewById(R.id.pemesanan_etPhone);
        EditText etJumlahPaket = view.findViewById(R.id.pemesanan_etJumlahPaket);
        TextView tvHargaPaket = view.findViewById(R.id.pemesanan_tvHargaPaket);
        RadioGroup rgJenisKelamin = view.findViewById(R.id.pemesanan_rgJenisKelamin);
        String hargaPaket = "0";
        
        Bundle extras = getArguments();
        if (extras != null) {
            hargaPaket = extras.getString("eHargaPaket");
        }
        tvHargaPaket.setText(hargaPaket);

        Button btPesan = view.findViewById(R.id.pemesanan_btPesan);
        String finalHargaPaket = hargaPaket;
        btPesan.setOnClickListener(v -> {
            String nama, email, phone, jumlahPaket, jenisKelamin;
            nama = etNama.getText().toString();
            email = etEmail.getText().toString();
            phone = etPhone.getText().toString();
            jumlahPaket = etJumlahPaket.getText().toString();
            int jenisKelaminId = rgJenisKelamin.getCheckedRadioButtonId();

            if (jenisKelaminId == -1 || nama.isEmpty() || phone.isEmpty() ||
                    jumlahPaket.isEmpty() || email.isEmpty()) {
                Toast.makeText(getContext(), "Please fill all forms", Toast.LENGTH_SHORT).show();
            } else {
                jenisKelamin = ((RadioButton) view.findViewById(jenisKelaminId)).getText().toString();

                Bundle args = new Bundle();
                args.putString("eNama", nama);
                args.putString("eEmail", email);
                args.putString("ePhone", phone);
                args.putString("eJumlahPaket", jumlahPaket);
                args.putString("eJenisKelamin", jenisKelamin);
                args.putString("eHargaPaket", finalHargaPaket);

                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.replace(R.id.fragmentContainerView, FragmentKonfirmasi.newInstance(args));
                fragmentTransaction.commit();
            }
        });

        Button btKembali = view.findViewById(R.id.pemesanan_btKembali);
        btKembali.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), PilihKotaActivity.class);
            startActivity(intent);
        });

    }
}