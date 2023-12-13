
public class BangunRuang {

    int Tinggi;
    int Lebar;
    int Panjang;

    public int getTinggi() {
        return Tinggi;
    }

    public void setTinggi(int Tinggi) {
        this.Tinggi = Tinggi;
    }
    
    public int getLebar() {
        return Lebar;
    }

    public void setLebar(int Lebar) {
        this.Lebar = Lebar;
    }
    
    public int getPanjang() {
        return Panjang;
    }

    public void setPanjang(int Panjang) {
        this.Panjang = Panjang;
    }
    
    double LuasSegitiga() {
        double LuasSegitiga;
        LuasSegitiga = (Lebar * getTinggi()) / 2;
        return LuasSegitiga;
    }

    double LuasTabung() {
        double LuasTabung;
        LuasTabung = 2 * 3.14 * (Lebar * Lebar) * Tinggi;
        return LuasTabung;
    }

    double LuasPiramida() {
        double LuasPiramida = (Panjang * Lebar * Tinggi) / 3;
        return LuasPiramida;
    }

    double LuasBalok() {
        double volume = Panjang * Lebar * Tinggi;
        return volume;
    }
}
