/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.utspbo;

/**
 *
 * @author User
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<LaporanKebakaran> daftarLaporan = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan = 0;

        // === [PENERAPAN LOOPING: do-while] ===
        // Mengulang menu utama selama pengguna belum memilih angka 5 (Keluar)
        do {
            System.out.println("\n=== SISTEM LAPORAN KEBAKARAN ===");
            System.out.println("1. Tambah Laporan");
            System.out.println("2. Lihat Semua Laporan");
            System.out.println("3. Ubah Laporan");
            System.out.println("4. Hapus Laporan");
            System.out.println("5. Keluar");
            System.out.print("Pilih Menu (1-5): ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            // === [PENERAPAN CONDITION: switch / if-else] ===
            switch (pilihan) {
                case 1:
                    tambahLaporan();
                    break;
                case 2:
                    lihatLaporan();
                    break;
                case 3:
                    ubahLaporan();
                    break;
                case 4:
                    hapusLaporan();
                    break;
                case 5:
                    System.out.println("Terima kasih, program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 5);
    }

    private static void tambahLaporan() {
        System.out.println("\nPilih Tipe Kebakaran:");
        System.out.println("1. Kebakaran Hutan");
        System.out.println("2. Kebakaran Lahan");
        System.out.print("Pilihan (1/2): ");
        int tipe = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Masukkan Lokasi: ");
        String lokasi = scanner.nextLine();

        // === [PENERAPAN CONDITION: if-else] ===
        // Menentukan objek subclass mana yang akan dibuat berdasarkan input
        if (tipe == 1) {
            System.out.print("Masukkan Tingkat Bahaya (Siaga/Bahaya): ");
            String bahaya = scanner.nextLine();
            
            // Instansiasi Subclass Tipe 1
            daftarLaporan.add(new LaporanKebakaranHutan(lokasi, bahaya));
            System.out.println("Laporan Kebakaran Hutan berhasil ditambahkan!");

        } else if (tipe == 2) {
            System.out.print("Masukkan Jenis Lahan (Gambut/Perkebunan): ");
            String jenis = scanner.nextLine();
            
            // Instansiasi Subclass Tipe 2
            daftarLaporan.add(new LaporanKebakaranLahan(lokasi, jenis));
            System.out.println("Laporan Kebakaran Lahan berhasil ditambahkan!");

        } else {
            System.out.println("Tipe tidak valid, pendaftaran dibatalkan.");
        }
    }

    private static void lihatLaporan() {
        System.out.println("\n=== DAFTAR LAPORAN ===");
        
        // === [PENERAPAN CONDITION: if-else] ===
        // Pengecekan kondisi apakah ArrayList kosong atau memiliki data
        if (daftarLaporan.isEmpty()) {
            System.out.println("Belum ada laporan yang terdaftar.");
        } else {
            // === [PENERAPAN LOOPING: for loop] ===
            // Mengiterasi dan mencetak seluruh objek di dalam ArrayList
            for (int i = 0; i < daftarLaporan.size(); i++) {
                System.out.println("\nLaporan Ke-" + (i + 1));
                
                // Polymorphism Overriding dipanggil secara otomatis sesuai tipe objeknya
                daftarLaporan.get(i).tampilkanDetail();
            }
        }
    }

    private static void ubahLaporan() {
        lihatLaporan();
        
        // === [PENERAPAN CONDITION: if-else] ===
        if (!daftarLaporan.isEmpty()) {
            System.out.print("\nMasukkan nomor laporan yang ingin diubah: ");
            int index = scanner.nextInt() - 1;
            scanner.nextLine();

            // Pengecekan validitas nomor indeks
            if (index >= 0 && index < daftarLaporan.size()) {
                System.out.print("Masukkan Lokasi Baru: ");
                String lokasiBaru = scanner.nextLine();
                
                LaporanKebakaran laporan = daftarLaporan.get(index);
                laporan.setLokasi(lokasiBaru);

                // === [PENERAPAN CONDITION: instanceof & Downcasting] ===
                // Mengecek tipe spesifik subclass dari objek yang disimpan di ArrayList
                if (laporan instanceof LaporanKebakaranHutan) {
                    System.out.print("Masukkan Tingkat Bahaya Baru: ");
                    String bahayaBaru = scanner.nextLine();
                    ((LaporanKebakaranHutan) laporan).setTingkatBahaya(bahayaBaru);
                } else if (laporan instanceof LaporanKebakaranLahan) {
                    System.out.print("Masukkan Jenis Lahan Baru: ");
                    String jenisBaru = scanner.nextLine();
                    ((LaporanKebakaranLahan) laporan).setJenisLahan(jenisBaru);
                }

                System.out.println("Laporan berhasil diperbarui!");
            } else {
                System.out.println("Nomor laporan tidak ditemukan!");
            }
        }
    }

    private static void hapusLaporan() {
        lihatLaporan();
        
        // === [PENERAPAN CONDITION: if-else] ===
        if (!daftarLaporan.isEmpty()) {
            System.out.print("\nMasukkan nomor laporan yang ingin dihapus: ");
            int index = scanner.nextInt() - 1;
            scanner.nextLine();

            if (index >= 0 && index < daftarLaporan.size()) {
                daftarLaporan.remove(index);
                System.out.println("Laporan berhasil dihapus!");
            } else {
                System.out.println("Nomor laporan tidak valid!");
            }
        }
    }
}
