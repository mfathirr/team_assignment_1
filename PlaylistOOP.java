public class PlaylistOOP {
    public static void main(String[] args) {
        // Membuat Array untuk menampung object dari class PlaylistOOP
        Lagu[] playlist = new Lagu[5]; // Size 5

        // Memasukan data object ke dalam array playlist
        playlist[0] = new Lagu("Membasuh", "Hindia", 2.9);
        playlist[1] = new Lagu("Membasuh", "Hindia", 2.9);
        playlist[2] = new Lagu("Membasuh", "Hindia", 2.1);

        // Looping untuk menampilkan informasi lagu
        // TODO : Dihapus saja jika tidak dibutuhkan di soal berikutnya
        for (Lagu lagu : playlist) {
            // Pengecekan agar tidak terjadi NullPointerException
            if (lagu != null) {
                lagu.tampilkanInfo();
            }
        }
    }
}
