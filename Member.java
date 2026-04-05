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

    // Mengurutkan lagu berdasarkan durasi (Bubble Sort)
    // Algoritma ini termasuk O(n²) karena menggunakan 2 loop yang saling bersarang
    public void urutkanLaguBerdasarkanDurasi(Lagu[] playlist, int jumlahLagu) {
        
        System.out.println("\n=== Sebelum Sorting ===");
        tampilkanSemuaLagu(playlist, jumlahLagu);

        // Bubble Sort: 2 loop bersarang = O(n²)
        for (int i = 0; i < jumlahLagu - 1; i++) {
            for (int j = 0; j < jumlahLagu - i - 1; j++) {

                if (playlist[j].durasiGetter() > playlist[j + 1].durasiGetter()) {

                    // Swap elemen
                    Lagu temp = playlist[j];
                    playlist[j] = playlist[j + 1];
                    playlist[j + 1] = temp;
                }
            }
        }

        System.out.println("\n=== Setelah Sorting (Bubble Sort - Ascending Durasi) ===");
        tampilkanSemuaLagu(playlist, jumlahLagu);
    }

    // Mengurutkan lagu berdasarkan durasi (Selection Sort)
    // Algoritma ini termasuk O(n²) karena menggunakan 2 loop yang saling bersarang
    public void urutkanLaguSelectionSort(Lagu[] playlist, int jumlahLagu) {
        
        System.out.println("\n=== Sebelum Sorting (Selection Sort) ===");
        tampilkanSemuaLagu(playlist, jumlahLagu);

        // Selection Sort: 2 loop bersarang untuk cari nilai terkecil = O(n²)
        for (int i = 0; i < jumlahLagu - 1; i++) {
            
            int indexMin = i;
            
            // Cari durasi terkecil dari elemen yang belum diurutkan
            for (int j = i + 1; j < jumlahLagu; j++) {
                
                if (playlist[j].durasiGetter() < playlist[indexMin].durasiGetter()) {
                    indexMin = j;
                }
            }
            
            // Tukar posisi jika ditemukan elemen yang lebih kecil
            Lagu temp = playlist[i];
            playlist[i] = playlist[indexMin];
            playlist[indexMin] = temp;
        }

        System.out.println("\n=== Setelah Sorting (Selection Sort - Ascending Durasi) ===");
        tampilkanSemuaLagu(playlist, jumlahLagu);
    }
}