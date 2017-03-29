package com.project.lianda.hijabstylestore.Model;

import java.io.Serializable;

/**
 * Created by lenovo on 23/03/2017.
 */

public class hijabModel implements Serializable {

    private int gambar;
    private String nama;
    private String deskripsi;
    private  String harga;

    public hijabModel(int gambar, String nama, String deskripsi, String harga) {
        this.gambar = gambar;
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.harga = harga;
    }

    public int getGambar() {
        return gambar;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

}


