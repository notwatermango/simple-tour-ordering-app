package com.example.uts_no4_pesanwisata;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentOrderSuccess extends Fragment {
    public static FragmentOrderSuccess newInstance() {
        FragmentOrderSuccess fragment = new FragmentOrderSuccess();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_order_success, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btSelesai = view.findViewById(R.id.berhasil_btSelesai);
        btSelesai.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), PilihKotaActivity.class);
            startActivity(intent);
        });
    }
}