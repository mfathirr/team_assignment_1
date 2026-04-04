public class Member extends User {

    public Member(String nama) {
        super(nama);
    }

    @Override
    public void tampilkanAkses() {
        System.out.println("Member dapat melihat dan mencari lagu");
    }

    // traversal show semua lagu
    public void tampilkanSemuaLagu(Lagu[] playlist, int jumlahLagu) {

        if (jumlahLagu == 0) {
            System.out.println("Playlist kosong");
            return;
        }

        System.out.println("\n=== Daftar Lagu ===");

        for (int i = 0; i < jumlahLagu; i++) {
            playlist[i].tampilkanInfo();
        }
    }

    // searching pakai linear search
    public void cariLagu(Lagu[] playlist, int jumlahLagu, String judul) {

        boolean ditemukan = false;

        for (int i = 0; i < jumlahLagu; i++) {

            if (playlist[i].judulGetter().equalsIgnoreCase(judul)) {

                System.out.println("Lagu ditemukan:");
                playlist[i].tampilkanInfo();
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Lagu tidak ditemukan");
        }
    }

    // Mengurutkan lagu berdasarkan durasi (ASC)
    // Dimulai dari durasi terpendek
    public void urutkanLaguBerdasarkanDurasi(Lagu[] playlist, int jumlahLagu) {
        for (int i = 0; i < jumlahLagu - 1; i++) {
            for (int j = 0; j < jumlahLagu - i - 1; j++) {

                if (playlist[j].durasiGetter() > playlist[j + 1].durasiGetter()) {

                    Lagu temp = playlist[j];
                    playlist[j] = playlist[j + 1];
                    playlist[j + 1] = temp;
                }
            }
        }

        tampilkanSemuaLagu(playlist, jumlahLagu);
    }
}