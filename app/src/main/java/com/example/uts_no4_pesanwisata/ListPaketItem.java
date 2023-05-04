package com.example.uts_no4_pesanwisata;

public class ListPaketItem {
    private String nama, deskripsi, harga;

    ListPaketItem(String nama, String deskripsi, String harga) {
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public String getHarga() {
        return harga;
    }
}
