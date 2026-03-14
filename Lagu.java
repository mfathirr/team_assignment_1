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


// Parent Class user
class User{
    protected String nama;
    public User(String nama){
        this.nama = nama;
    }
    // Polymorphism
    public void tampilkanakses(){
        System.out.println(" Akses pengguna ");
    }
}
// child class admin
class Admin extends User{
    public Admin(String nama){
        super(nama);
    }
    // implementasi yg beda
    @Override
    public void tampilkanakses(){
        System.out.println("Admin bisa untuk menambah dan melihat lagu");
    ;
    // Method untuk tambah lagu
    public void tambahLagu(Lagu[] playlist, Lagu laguBaru, int index) {
        if (index < playlist.length) {
            playlist[index] = laguBaru;
            System.out.println("Lagu ditambahkan.");
        } else {
            System.out.println("Playlist full.");
        }
    }
}
// Child class Member
class Member extends User {
    public Member(String nama) {
        super(nama);
    }
    // Polymorphism
    @Override
    public void tampilkanakses() {
        System.out.println("Member bisa melihat dan mencari lagu.");
    }
    // Method untuk menampilkan lagu
    public void lihatplaylist(Lagu[] playlist) {
        System.out.println("\nDaftar Lagu:");
        for (Lagu lagu :playlist) {
            if (lagu != null) {
                lagu.tampilkanInfo();
            }
        }
    }
    // Method mencari lagu dari judul
    public void carilagu(Lagu[] playlist, String judulCari) {
        boolean ditemukan = false;
        for (Lagu lagu : playlist){
            if (lagu != null && lagu.getJudul().equalsIgnoreCase(judulCari)){
                System.out.println("\nLagu ketemu:");
                lagu.tampilkanInfo();
                ketemu = true;
            }
        }
        if (!ketemu) {
            System.out.println("Lagu tidak ketemu.");
        }
    }
    // Method menghitung rata-rata durasi lagu
    public void ratarataDurasi(Lagu[] playlist){
        double total = 0;
        int jumlah = 0;
        for (Lagu lagu : playlist) {
            if (lagu != null) {
                total += lagu.getDurasi();
                jumlah++;
            }
        }
        if (jumlah > 0){
            System.out.println("Rata-rata durasi lagu: " +(total / jumlah) +" menit");
        } else {
            System.out.println("Playlist kosong.");
        }
    }
}
// Class utama
public class PlaylistOOP {
    public static void main(String[] args) {
        // Array untuk menyimpan playlist
        Lagu[] playlist = new Lagu[10];
        // Membuat objek admin dan member
        Admin admin = new Admin("Admin Musik");
        Member member = new Member("User Musik");
        // Menampilkan akses masing-masing user
        admin.tampilkanakses();
        member.tampilkanakses();
        // Admin menambahkan lagu ke playlist
        admin.tambahLagu(playlist, new Lagu("Risk it all", "Bruno Mars", 3.3), 0);
        admin.tambahLagu(playlist, new Lagu("All I Ask", "Adele", 3.5), 1);
        admin.tambahLagu(playlist, new Lagu("Don't You Remember", "Adele", 4.2), 2);
        // Member melihat daftar lagu
        member.lihatplaylist(playlist);
        // Member mencari lagu
        member.carilagu(playlist, "Risk it all");
        // Member menghitung rata-rata durasi lagu
        member.rataRataDurasi(playlist);
    }
}
