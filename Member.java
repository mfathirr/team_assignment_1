// Child class Member
public class Member extends User {
    public Member(String nama) {
        super(nama);
    }

    // Polymorphism
    @Override
    public void tampilakanAkses() {
        System.out.println("Member bisa melihat dan mencari lagu.");
    }

    // Method untuk menampilkan lagu
    public void lihatPlaylist(Lagu[] playlist) {
        System.out.println("\nDaftar Lagu:");
        for (Lagu lagu : playlist) {
            if (lagu != null) {
                lagu.tampilkanInfo();
            }
        }
    }

    // Method mencari lagu dari judul
    public void cariLagu(Lagu[] playlist, String judulCari) {
        System.out.println("Mencari Lagu : " + judulCari);
        boolean ditemukan = false;
        for (Lagu lagu : playlist) {
            if (lagu != null && lagu.judulGetter().equalsIgnoreCase(judulCari)) {
                System.out.println("\nLagu ketemu:");
                lagu.tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Lagu tidak ketemu.");
        }
    }

    // Method menghitung rata-rata durasi lagu
    public void ratarataDurasi(Lagu[] playlist) {
        double total = 0;
        int jumlah = 0;
        for (Lagu lagu : playlist) {
            if (lagu != null) {
                total += lagu.durasiGetter();
                jumlah++;
            }
        }
        if (jumlah > 0) {
            String roundedValue = String.format("%.1f", (total / jumlah));
            System.out.println("Rata-rata durasi lagu: " + roundedValue + " menit");
        } else {
            System.out.println("Playlist kosong.");
        }
    }
}
