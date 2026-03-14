// child class admin
public class Admin extends User {
    public Admin(String nama) {
        super(nama);
    }

    // implementasi yg beda
    @Override
    public void tampilakanAkses() {
        System.out.println("Admin bisa untuk menambah dan melihat lagu");
    }

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