package com.example.uts_no4_pesanwisata;

public class GridKotaItem {
    private String namaKota;
    private int imageKota;

    GridKotaItem(String namaKota, int imageKota) {
        this.namaKota = namaKota.substring(0, 1).toUpperCase() + namaKota.substring(1);
        this.imageKota = imageKota;
    }

    public String getNamaKota() {
        return namaKota;
    }

    public int getImageKota() {
        return imageKota;
    }
}
