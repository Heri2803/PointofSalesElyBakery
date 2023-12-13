
public class Utama {

    public static void main(String[] args) {

        BangunRuang bangunRuang = new BangunRuang();
        Aritmatika aritmatika = new Aritmatika();

        int[] panjang = {10, 20, 10, 30, 15, 20, 16, 19, 20};
        int[] lebar = {12, 21, 10, 15, 15, 20, 17, 18, 20};
        int[] tinggi = {10, 9, 8, 5, 12, 10, 12, 11, 11};

        double[] arrayLuas = new double[panjang.length];

        for (int i = 0; i < arrayLuas.length; i++) {

            if (panjang[i] == lebar[i]) {
                bangunRuang.setPanjang(panjang[i]);
                bangunRuang.setLebar(lebar[i]);
                arrayLuas[i] = bangunRuang.LuasBalok();
            } else if (panjang[i] % 2 == 1) {
                bangunRuang.setTinggi(tinggi[i]);
                bangunRuang.setLebar(lebar[i]);
                bangunRuang.setPanjang(panjang[i]);
                arrayLuas[i] = bangunRuang.LuasPiramida();
            } else {
                bangunRuang.setTinggi(tinggi[i]);
                bangunRuang.setLebar(lebar[i]);
                bangunRuang.setPanjang(panjang[i]);
                arrayLuas[i] = bangunRuang.LuasTabung();
            }
        }

        for (int i = 0; i < arrayLuas.length; i++) {
            System.out.println("Luas Bangun Ruang ke " + (i + 1) + " adalah " + arrayLuas[i]);
        }
    }
}
