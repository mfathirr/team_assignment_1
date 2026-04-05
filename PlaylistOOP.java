// MUHAMMAD FATHIR - 2902730432
// DARA KANIA DAMANIK - 2902704314
// BRANDON RAPHAEL VALENTINO - 2902735635
// GERALDO JUAN YUHENDRI - 2902733434
// NAUFAL ARDHI RAMLAN - 2902697082

import java.util.Scanner;

public class PlaylistOOP {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Lagu[] playlist = new Lagu[10];

        // Lagu awal dalam playlist
        playlist[0] = new Lagu("Membasuh", "Hindia", 4.5);
        playlist[1] = new Lagu("Tarot", "Feast", 5.0);
        playlist[2] = new Lagu("Sewindu", "Tulus", 4.2);

        int jumlahLagu = 3;

        Admin admin = new Admin("Admin");
        Member member = new Member("Member");

        int pilihan = 0;

        while (pilihan != 6) {

            System.out.println("\n=== MENU PLAYLIST MUSIK ===");
            System.out.println("1. Tampilkan semua lagu");
            System.out.println("2. Tambah lagu baru");
            System.out.println("3. Hapus lagu berdasarkan judul");
            System.out.println("4. Cari lagu berdasarkan judul");
            System.out.println("5. Urut lagu berdasarkan durasi (Bubble Sort)");
            System.out.println("6. Urut lagu berdasarkan durasi (Selection Sort)");
            System.out.println("7. Keluar");
            System.out.print("Pilih: ");

            pilihan = input.nextInt();
            input.nextLine();

            if (pilihan == 1) {
                member.tampilkanSemuaLagu(playlist, jumlahLagu);

            } else if (pilihan == 2) {
                String lagi = "y";

                while (lagi.equalsIgnoreCase("y")) {
                    jumlahLagu = admin.tambahLagu(playlist, jumlahLagu, input);

                    System.out.print("Tambah lagu lagi? (y/n): ");
                    lagi = input.nextLine();
                }

            } else if (pilihan == 3) {
                System.out.print("Masukkan judul lagu yang ingin dihapus: ");
                String judul = input.nextLine();

                jumlahLagu = admin.hapusLagu(playlist, jumlahLagu, judul);

            } else if (pilihan == 4) {
                System.out.print("Masukkan judul lagu yang dicari: ");
                String judul = input.nextLine();

                member.cariLagu(playlist, jumlahLagu, judul);

            } else if (pilihan == 5) {
                member.urutkanLaguBerdasarkanDurasi(playlist, jumlahLagu);

            } else if (pilihan == 6) {
                member.urutkanLaguSelectionSort(playlist, jumlahLagu);

            } else if (pilihan == 7) {
                System.out.println("Program selesai");

            } else {
                System.out.println("Pilihan tidak valid");
            }
        }
    }
}
