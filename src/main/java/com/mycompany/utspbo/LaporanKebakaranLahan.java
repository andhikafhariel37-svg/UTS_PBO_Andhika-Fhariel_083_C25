/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.utspbo;

/**
 *
 * @author User
 */
// === [PENERAPAN INHERITANCE: Subclass Tipe 2] ===
// Subclass kedua untuk memenuhi kriteria minimal 2 tipe Inheritance
public class LaporanKebakaranLahan extends LaporanKebakaran {
    private String jenisLahan; // Contoh: Gambut, Perkebunan, Alang-alang

    public LaporanKebakaranLahan(String lokasi, String jenisLahan) {
        super(lokasi); // Memanggil constructor superclass
        this.jenisLahan = jenisLahan;
    }

    // === [PENERAPAN POLYMORPHISM: Method Overriding] ===
    // Menimpa method tampilkanDetail() milik superclass untuk spesifikasi Lahan
    @Override
    public void tampilkanDetail() {
        super.tampilkanDetail();
        System.out.println("Tipe Kebakaran : Lahan Non-Hutan");
        System.out.println("Jenis Lahan    : " + jenisLahan);
    }

    public String getJenisLahan() {
        return jenisLahan;
    }

    public void setJenisLahan(String jenisLahan) {
        this.jenisLahan = jenisLahan;
    }
}
