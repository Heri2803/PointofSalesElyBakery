public class Aritmatika {

    public Aritmatika() {

    }

    public Aritmatika(int Panjang, int Lebar) {
        this.Panjang = Panjang;
        this.Lebar = Lebar;
    }

    public int Panjang;
    public int getPanjang() {
        return Panjang;
    }

    public void setPanjang(int Panjang) {
        this.Panjang = Panjang;
    }

    public int getLebar() {
        return Lebar;
    }

    public void setLebar(int Lebar) {
        this.Lebar = Lebar;
    }

    public int Lebar;

    public int Luas() {
        int Luas = 0;
        Luas = Panjang * Lebar;
        return Luas;
    }

    public int Keliling() {
        int Keliling;
        Keliling = 2 * (Lebar * Panjang);
        return Keliling;
    }
}






