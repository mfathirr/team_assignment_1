// Membuat class PlaylistOOP
public class Lagu {
    // Membuat atribut yang private dan hanya bisa diakses menggunakan setter / getter
    private String judul;
    private String artis;
    private double durasi;

    // Consturctor untuk inisialisasi data
    public Lagu(String judul, String artis, double durasi) {
        this.judul = judul;
        this.artis = artis;
        this.durasi = durasi;
    }

    // Setter untuk atribut judul
    public void judulSetter(String judul) {
        this.judul = judul;
    }

    // Getter untuk atribut judul
    public String judulGetter() {
        return judul;
    }

    // Setter untuk atribut artis
    public void artisSetter(String artis) {
        this.artis = artis;
    }

    // Getter untuk atribut artis
    public String artisGetter() {
        return artis;
    }

    // Setter untuk atribut durasi
    public void durasiSetter(double durasi) {
        this.durasi = durasi;
    }

    // Getter untuk atribut durasi
    public double durasiGetter() {
        return durasi;
    }

    // private method untuk membuat durasi menjadi lebih textual dan jelas
    private String konversiDurasi() {
        int menit = (int) durasi;
        int detik = (int) ((durasi - menit) * 60);

        return menit + " Menit " + detik + " Detik";
    }

    // Public method untuk menampilakan informasi lagu
    public void tampilkanInfo() {
        System.out.println("===== Informasi Lagu =====");
        System.out.println("Judul : " + judul);
        System.out.println("Artis : " + artis);
        System.out.println("Durasi : " + konversiDurasi());
        System.out.println("");
    }
}