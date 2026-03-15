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

        while (pilihan != 3) {

            System.out.println("\n=== SISTEM PLAYLIST MUSIK ===");
            System.out.println("1. Login Admin");
            System.out.println("2. Login Member");
            System.out.println("3. Keluar");
            System.out.print("Pilih: ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    admin.tampilkanAkses();

                    String tambahLagi = "y";

                    while (tambahLagi.equalsIgnoreCase("y")) {

                        jumlahLagu = admin.tambahLagu(playlist, jumlahLagu, input);

                        System.out.print("Tambah lagu lagi? (y/n): ");
                        tambahLagi = input.nextLine();

                    }

                    break;
                case 2:
                    member.tampilkanAkses();
                    System.out.println("\nPlaylist Saat Ini:");
                    member.lihatPlaylist(playlist, jumlahLagu);
                    System.out.println("1. Cari Lagu");
                    System.out.println("2. Kembali");
                    System.out.print("Pilih: ");
                    int menu = input.nextInt();
                    input.nextLine();
                    if (menu == 1) {

                        System.out.print("Masukkan judul lagu: ");
                        String judul = input.nextLine();

                        member.cariLagu(playlist, jumlahLagu, judul);

                    }
                    break;
                case 3:
                    System.out.println("Program selesai");
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
                    break;
            }
        }
    }
}
