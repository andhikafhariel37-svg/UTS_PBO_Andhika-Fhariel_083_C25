/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.utspbo;

/**
 *
 * @author User
 */
public class LaporanKebakaran {
    protected String lokasi;

    public LaporanKebakaran(String lokasi) {
        this.lokasi = lokasi;
    }

    // === [PENERAPAN POLYMORPHISM: Method Overloading 1] ===
    // Method dasar tanpa parameter
    public void tampilkanDetail() {
        System.out.println("Lokasi         : " + lokasi);
    }

    // === [PENERAPAN POLYMORPHISM: Method Overloading 2] ===
    // Method dengan nama sama tetapi beda parameter (pesanTambahan)
    public void tampilkanDetail(String pesanTambahan) {
        System.out.println("Lokasi         : " + lokasi);
        System.out.println("Catatan        : " + pesanTambahan);
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }
}