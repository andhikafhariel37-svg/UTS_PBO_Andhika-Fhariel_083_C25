/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.utspbo;

/**
 *
 * @author User
 */
// === [PENERAPAN INHERITANCE: Subclass Tipe 1] ===
// Memakai kata kunci 'extends' untuk mewarisi LaporanKebakaran
public class LaporanKebakaranHutan extends LaporanKebakaran {
    private String tingkatBahaya;

    public LaporanKebakaranHutan(String lokasi, String tingkatBahaya) {
        super(lokasi); // Memanggil constructor superclass
        this.tingkatBahaya = tingkatBahaya;
    }

    // === [PENERAPAN POLYMORPHISM: Method Overriding] ===
    // Menimpa method tampilkanDetail() milik superclass
    @Override
    public void tampilkanDetail() {
        super.tampilkanDetail();
        System.out.println("Tipe Kebakaran : Hutan");
        System.out.println("Tingkat Bahaya : " + tingkatBahaya);
    }

    public String getTingkatBahaya() {
        return tingkatBahaya;
    }

    public void setTingkatBahaya(String tingkatBahaya) {
        this.tingkatBahaya = tingkatBahaya;
    }
}