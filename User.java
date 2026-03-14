// Parent Class user
public class User {
    protected String nama;

    public User(String nama) {
        this.nama = nama;
    }

    // Polymorphism
    public void tampilakanAkses() {
        System.out.println(" Akses pengguna ");
    }
}
