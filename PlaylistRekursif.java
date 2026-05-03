// MUHAMMAD FATHIR - 2902730432
// DARA KANIA DAMANIK - 2902704314
// BRANDON RAPHAEL VALENTINO - 2902735635
// GERALDO JUAN YUHENDRI - 2902733434
// NAUFAL ARDHI RAMLAN - 2902697082
// Kelas: isi sesuai kelas kalian

public class PlaylistRekursif {

    /*
     * Fungsi: Menghitung total durasi seluruh lagu secara rekursif.
     * Base case: jika n == 0, tidak ada lagu yang dijumlahkan sehingga return 0.
     * Recursive case: durasi lagu ke(n-1)+total durasi lagu sebelumnya.
     * Kompleksitas waktu:O(n), karena setiap lagu diproses satu kali.
     */
    static double totalDurasi(Lagu[] list, int n) {
        if (n == 0) {
            return 0;
        }
        return list[n - 1].durasiGetter() + totalDurasi(list, n - 1);
    }
    /*
     * Fungsi: Menampilkan daftar lagu dari akhir ke awal secara rekursif.
     * Base case: jika index<0, proses berhenti.
     * Recursive case: tampilkan lagu pada index saat ini, lalu panggil index - 1.
     * Kompleksitas waktu: O(n), karena setiap lagu ditampilkan satu kali.
     */
    static void tampilkanMundur(Lagu[] list, int index) {
        if (index < 0) {
            return;
        }
        System.out.printf("%d. %s - %s (%.2f menit)%n",
                index + 1,
                list[index].judulGetter(),
                list[index].artisGetter(),
                list[index].durasiGetter());

        tampilkanMundur(list, index - 1);
    }
    /*
     * Fungsi: Mencari durasi lagu terpanjang secara rekursif.
     * Base case: jika index == 0, return durasi lagu pertama.
     * Recursive case: bandingkan durasi lagu saat ini dengan durasi maksimum sebelumnya.
     * Kompleksitas waktu: O(n), karena setiap lagu dibandingkan satu kali.
     */
    static double cariDurasiTerpanjang(Lagu[] list, int index) {
        if (index == 0) {
            return list[0].durasiGetter();
        }
        double maxSebelumnya = cariDurasiTerpanjang(list, index - 1);
        return Math.max(list[index].durasiGetter(), maxSebelumnya);
    }
    /*
     * Fungsi tambahan: mencari objek lagu berdasarkan durasi terpanjang.
     * Kompleksitas waktu: O(n).
     */
    static Lagu cariLaguTerpanjang(Lagu[] list, double durasiTerpanjang) {
        for (Lagu lagu : list) {
            if (lagu.durasiGetter() == durasiTerpanjang) {
                return lagu;
            }
        }
        return null;
    }
    static double konversiMs(long nanoTime) {
        return nanoTime / 1_000_000.0;
    }
    public static void main(String[] args) {
        Lagu[] playlist = {
                new Lagu("Perfect", "Ed Sheeran", 4.23),
                new Lagu("Shivers", "Ed Sheeran", 3.50),
                new Lagu("Yellow", "Coldplay", 4.26),
                new Lagu("Fix You", "Coldplay", 4.52),
                new Lagu("Viva La Vida", "Coldplay", 3.54)
        };
        int n = playlist.length;
        System.out.println("=== ANALISIS REKURSIF PLAYLIST ===");
        System.out.println("Jumlah lagu : " + n);
        long startTotal = System.nanoTime();
        double total = totalDurasi(playlist, n);
        long endTotal = System.nanoTime();
        long startMax = System.nanoTime();
        double durasiMax = cariDurasiTerpanjang(playlist, n - 1);
        Lagu laguTerpanjang = cariLaguTerpanjang(playlist, durasiMax);
        long endMax = System.nanoTime();
        System.out.printf("Total durasi : %.2f menit%n", total);
        if (laguTerpanjang != null) {
            System.out.printf("Lagu terpanjang : \"%s\" - %s (%.2f menit)%n",
                    laguTerpanjang.judulGetter(),
                    laguTerpanjang.artisGetter(),
                    laguTerpanjang.durasiGetter());
        }
        System.out.println("\nDaftar lagu (ditampilkan terbalik):");
        long startMundur = System.nanoTime();
        tampilkanMundur(playlist, n - 1);
        long endMundur = System.nanoTime();
        System.out.printf("%nExecution Time (totalDurasi): %.4f ms%n", konversiMs(endTotal - startTotal));
        System.out.printf("Execution Time (tampilkanMundur): %.4f ms%n", konversiMs(endMundur - startMundur));
        System.out.printf("Execution Time (cariDurasiTerpanjang): %.4f ms%n", konversiMs(endMax - startMax));
    }
}
