// MUHAMMAD FATHIR - 2902730432
// DARA KANIA DAMANIK - 2902704314
// BRANDON RAPHAEL VALENTINO - 2902735635
// GERALDO JUAN YUHENDRI - 2902733434
// NAUFAL ARDHI RAMLAN - 2902697082

import java.util.Scanner;

public class PlaylistRekursif {

    // Menjumlahkan durasi dari index ke-n mundur hingga index ke 0
    static double totalDurasi(Lagu[] list, int n) {
        if (n == 0)
            return 0;
        return list[n - 1].durasiGetter() + totalDurasi(list, n - 1);
    }

    // Menampilkan lagu dari index terakhir mundur hingga index ke 0
    static void tampilkanMundur(Lagu[] list, int index) {
        if (index < 0)
            return;
        System.out.printf("%s - %s (%.2f menit)%n",
                list[index].judulGetter(),
                list[index].artisGetter(),
                list[index].durasiGetter());
        tampilkanMundur(list, index - 1);
    }

    // Membandingkan durasi tiap lagu untuk menemukan yang durasi yang terpanjang
    static double cariDurasiTerpanjang(Lagu[] list, int index) {
        if (index == 0)
            return list[0].durasiGetter();
        double maxSisanya = cariDurasiTerpanjang(list, index - 1);
        return Math.max(list[index].durasiGetter(), maxSisanya);
    }

    // Menampilkan lagu dari index 0 hingga akhir dengan urutan yg normal
    static void tampilkanNormal(Lagu[] list, int index, int n) {
        if (index >= n)
            return;
        System.out.printf("%d. %s - %s (%.2f menit)%n",
                index + 1,
                list[index].judulGetter(),
                list[index].artisGetter(),
                list[index].durasiGetter());
        tampilkanNormal(list, index + 1, n);
    }

    public static void main(String[] args) {
        Lagu[] playlist = {
                new Lagu("Viva La Vida", "Coldplay", 3.00),
                new Lagu("Shape of You", "Ed Sheeran", 3.07),
                new Lagu("Clocks", "Coldplay", 3.04),
                new Lagu("Perfect", "Ed Sheeran", 4.23),
                new Lagu("Shivers", "Ed Sheeran", 3.50),
                new Lagu("Fix You", "Coldplay", 4.52)
        };

        int n = playlist.length;
        Scanner input = new Scanner(System.in);
        int pilihan = 0;

        while (pilihan != 5) {
            System.out.println("\n=== MENU PLAYLIST REKURSIF ===");
            System.out.println("1. Tampilkan semua lagu");
            System.out.println("2. Hitung total durasi playlist");
            System.out.println("3. Tampilkan daftar lagu terbalik");
            System.out.println("4. Cari lagu dengan durasi terpanjang");
            System.out.println("5. Keluar");
            System.out.print("Pilih: ");

            pilihan = input.nextInt();

            if (pilihan == 1) {
                System.out.println("\nDaftar Lagu (Urutan Normal):");
                long mulai = System.nanoTime();
                tampilkanNormal(playlist, 0, n);
                long selesai = System.nanoTime();

                System.out.println("Waktu eksekusi          : " + (selesai - mulai) + " ns");
            } else if (pilihan == 2) {
                long mulai = System.nanoTime();
                double total = totalDurasi(playlist, n);
                long selesai = System.nanoTime();

                System.out.printf("%nTotal Durasi Playlist   = %.2f menit%n", total);
                System.out.println("Waktu eksekusi          : " + (selesai - mulai) + " ns");
            } else if (pilihan == 3) {
                System.out.println("\nDaftar Lagu (Terbalik):");
                long mulai = System.nanoTime();
                tampilkanMundur(playlist, n - 1);
                long selesai = System.nanoTime();

                System.out.println("Waktu eksekusi          : " + (selesai - mulai) + " ns");
            } else if (pilihan == 4) {
                long mulai = System.nanoTime();
                double maxDurasi = cariDurasiTerpanjang(playlist, n - 1);
                long selesai = System.nanoTime();

                // Setelah berhasil mendapatkan lagu dengan durasi terpanjang
                // Selanjutnya mencari nama dan artis dari durasi tersebut menggunakan foreach
                String judulTerpanjang = "";
                String artisTerpanjang = "";
                for (Lagu lagu : playlist) {
                    if (lagu.durasiGetter() == maxDurasi) {
                        judulTerpanjang = lagu.judulGetter();
                        artisTerpanjang = lagu.artisGetter();
                        break;
                    }
                }

                System.out.printf("%nLagu Terpanjang         : %s - %s (%.2f menit)%n", judulTerpanjang,
                        artisTerpanjang,
                        maxDurasi);
                System.out.println("Waktu eksekusi          : " + (selesai - mulai) + " ns");
            } else if (pilihan == 5) {
                System.out.println("Program selesai.");
            } else {
                System.out.println("Pilihan tidak valid, coba lagi.");
            }
        }

        input.close();
    }
}
