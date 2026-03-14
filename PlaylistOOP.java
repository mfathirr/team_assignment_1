// MUHAMMAD FATHIR - 2902730432
public class PlaylistOOP {
    public static void main(String[] args) {
        // Array untuk menyimpan playlist
        Lagu[] playlist = new Lagu[10];
        // Membuat objek admin dan member
        Admin admin = new Admin("Admin Musik");
        Member member = new Member("User Musik");
        // Menampilkan akses masing-masing user
        admin.tampilakanAkses();
        member.tampilakanAkses();
        // Admin menambahkan lagu ke playlist
        admin.tambahLagu(playlist, new Lagu("Risk it all", "Bruno Mars", 3.3), 0);
        admin.tambahLagu(playlist, new Lagu("All I Ask", "Adele", 3.5), 1);
        admin.tambahLagu(playlist, new Lagu("Don't You Remember", "Adele", 4.2), 2);
        // Member melihat daftar lagu
        member.lihatPlaylist(playlist);
        // Member mencari lagu
        member.cariLagu(playlist, "Risk it all");
        // Member menghitung rata-rata durasi lagu
        member.ratarataDurasi(playlist);
    }
}
