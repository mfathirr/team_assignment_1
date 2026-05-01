import java.util.Scanner;

// Class Admin turunan dari class User 
public class Admin extends User {

    // Constructor Admin 
    public Admin(String nama) {
        super(nama);
    }

    // Method override dari class User untuk menampilkan akses
    @Override
    public void tampilkanAkses() {
        System.out.println("Admin dapat menambahkan lagu");
    }

    // Method untuk menambahkan lagu ke dalam playlist
    public int tambahLagu(Lagu[] playlist, int jumlahLagu, Scanner input) {

        // Mengecek apakah playlist sudah penuh
        if (jumlahLagu >= playlist.length) {
            System.out.println("Playlist sudah penuh");
            return jumlahLagu; // jika penuh, jumlah lagu tidak berubah
        }

        // Input data lagu
        System.out.print("Masukkan Judul Lagu: ");
        String judul = input.nextLine();

        System.out.print("Masukkan Artis     : ");
        String artis = input.nextLine();

        System.out.print("Masukkan Durasi    : ");
        double durasi = input.nextDouble();
        input.nextLine();

        // Membuat objek Lagu baru dan disimpan ke dalam array playlist
        playlist[jumlahLagu] = new Lagu(judul, artis, durasi);

        System.out.println("Lagu berhasil ditambahkan");

        playlist[jumlahLagu].tampilkanInfo();

        // jumlah lagu bertambah 1 setiap kali method tambahLagu dipanggil
        return jumlahLagu + 1;
    }

    //deletion
    public int hapusLagu(Lagu[] playlist, int jumlahLagu, String judul) {

        int index = -1;

        // cari index lagu (linear search)
        for (int i = 0; i < jumlahLagu; i++) {
            if (playlist[i].judulGetter().equalsIgnoreCase(judul)) {
                index = i;
                break;
            }
        }

        //cek lagu ada atau tidak
        if (index == -1) {
            System.out.println("Lagu tidak ditemukan!");
            return jumlahLagu;
        }

        // geser array
        for (int i = index; i < jumlahLagu - 1; i++) {
            playlist[i] = playlist[i + 1];
        }

        playlist[jumlahLagu - 1] = null;

        System.out.println("Lagu berhasil dihapus!");

        return jumlahLagu - 1;
    }
}