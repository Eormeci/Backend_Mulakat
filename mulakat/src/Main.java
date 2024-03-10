import java.util.ArrayList;
import java.util.Random;

// Hayvan objesini tanımladım ve özelliklerini belirledim .
class Hayvan {
    String tur;
    String cinsiyet;
    int x;
    int y;
    private int hareketYonu;

    public Hayvan(String tur, String cinsiyet, int x, int y) {
        this.tur = tur;
        this.cinsiyet = cinsiyet;
        this.x = x;
        this.y = y;

        // Hayvan oluşturulduğunda rastgele bir yönde hareket etmesi için ufak bir kod yazdım .
        Random rand = new Random();
        hareketYonu = rand.nextInt(4);
    }

    // Hareket et methodunu özelleştirdim.
    public void hareketEt(int tarlaBoyut) {

        Random rand = new Random();

        // Rastgele bir yönde hareket et
        int hareketMiktari;
        switch (tur) {
            // Hangi hayvan kaç birim hareket edecek .
            case "Koyun":
                hareketMiktari = 2;
                break;
            case "Kurt":
                hareketMiktari = 3;
                break;
            case "Inek":
                hareketMiktari = 2;
                break;
            case "Tavuk":
                hareketMiktari = 1;
            case "Horoz":
                hareketMiktari = 1;
                break;
            case "Aslan":
                hareketMiktari = 4;
                break;
            case "Avci":
                hareketMiktari = 1;
                break;
            default:
                hareketMiktari = 3;
                break;
        }

        // Tarla boyutunu aşmaması için yazdığım kod.
        switch (hareketYonu) {
            case 0: // Yukarı
                if (y - hareketMiktari >= 0) {
                    y -= hareketMiktari;
                }
                break;
            case 1: // Aşağı
                if (y + hareketMiktari < tarlaBoyut) {
                    y += hareketMiktari;
                }
                break;
            case 2: // Sol
                if (x - hareketMiktari >= 0) {
                    x -= hareketMiktari;
                }
                break;
            case 3: // Sağ
                if (x + hareketMiktari < tarlaBoyut) {
                    x += hareketMiktari;
                }
                break;
        }

        // Rastgele bir sonraki hareket yönü belirle
        hareketYonu = rand.nextInt(4);
    }

    public static void kurtYer(ArrayList<Hayvan> hayvanlar, String avlananHayvanTur) {

        // Kurt ve hayvan kaldı mı ?
        int kurtIndex = -1;
        int avlananHayvanIndex = -1;


        for (int i = 0; i < hayvanlar.size(); i++) {
            Hayvan hayvan = hayvanlar.get(i);
            if (hayvan.tur.equals("Kurt")) {
                kurtIndex = i;
            } else if (hayvan.tur.equals(avlananHayvanTur)) {
                avlananHayvanIndex = i;
            }
        }

        // Kurt ve avlanan hayvan bulundu mu?
        if (kurtIndex != -1 && avlananHayvanIndex != -1) {
            // Kurt ile avlanan hayvan arasındaki x-y ekseni farkını kontrol et
            Hayvan kurt = hayvanlar.get(kurtIndex);
            Hayvan avlananHayvan = hayvanlar.get(avlananHayvanIndex);

            int xFarki = Math.abs(kurt.x - avlananHayvan.x);
            int yFarki = Math.abs(kurt.y - avlananHayvan.y);

            if (xFarki <= 4 || yFarki <= 4) {
                hayvanlar.remove(avlananHayvanIndex);
                //System.out.println("Kurt " + avlananHayvanTur + " yedi!");
            }
        }
    }
    public static void aslanYer(ArrayList<Hayvan> hayvanlar, String avlananHayvanTur) {

        int aslanIndex = -1;
        int avlananHayvanIndex = -1;


        for (int i = 0; i < hayvanlar.size(); i++) {
            Hayvan hayvan = hayvanlar.get(i);
            if (hayvan.tur.equals("Aslan")) {
                aslanIndex = i;
            } else if (hayvan.tur.equals(avlananHayvanTur)) {
                avlananHayvanIndex = i;
            }
        }

        if (aslanIndex != -1 && avlananHayvanIndex != -1) {

            Hayvan aslan = hayvanlar.get(aslanIndex);
            Hayvan avlananHayvan = hayvanlar.get(avlananHayvanIndex);

            int xFarki = Math.abs(aslan.x - avlananHayvan.x);
            int yFarki = Math.abs(aslan.y - avlananHayvan.y);

            if (xFarki <= 5 || yFarki <= 5) {
                hayvanlar.remove(avlananHayvanIndex);
                //System.out.println("Aslan " + avlananHayvanTur + " yedi!");
            }
        }
    }
    public static void avciAvlar(ArrayList<Hayvan> hayvanlar, String avlananHayvanTur) {
        int avciIndex = -1;
        int avlananHayvanIndex = -1;

        for (int i = 0; i < hayvanlar.size(); i++) {
            Hayvan hayvan = hayvanlar.get(i);
            if (hayvan.tur.equals("Avci")) {
                avciIndex = i;
            } else if (hayvan.tur.equals(avlananHayvanTur)) {
                avlananHayvanIndex = i;
            }
        }

        if (avciIndex != -1 && avlananHayvanIndex != -1) {

            Hayvan avci = hayvanlar.get(avciIndex);
            Hayvan avlananHayvan = hayvanlar.get(avlananHayvanIndex);

            int xFarki = Math.abs(avci.x - avlananHayvan.x);
            int yFarki = Math.abs(avci.y - avlananHayvan.y);

            if (xFarki <= 8 || yFarki <= 8) {
                hayvanlar.remove(avlananHayvanIndex);
                //System.out.println("Avci " + avlananHayvanTur + " avladi!");
            }
        }
    }
    public static void ciftlesme(ArrayList<Hayvan> hayvanlar, String ciftlesecekTur) {
        int ciftlesecekErkekIndex = -1;
        int ciftlesecekDisiIndex = -1;


        // Disi ve erkek hayvanın bulunması .
        for (int i = 0; i < hayvanlar.size(); i++) {
            Hayvan hayvan = hayvanlar.get(i);
            if (hayvan.tur.equals(ciftlesecekTur) && hayvan.cinsiyet.equals("Erkek")) {
                ciftlesecekErkekIndex = i;
            } else if (hayvan.tur.equals(ciftlesecekTur) && hayvan.cinsiyet.equals("Dişi")) {
                ciftlesecekDisiIndex = i;
            }
        }

        if (ciftlesecekErkekIndex != -1 && ciftlesecekDisiIndex != -1) {
            Hayvan erkek = hayvanlar.get(ciftlesecekErkekIndex);
            Hayvan disi = hayvanlar.get(ciftlesecekDisiIndex);

            int xFarki = Math.abs(erkek.x - disi.x);
            int yFarki = Math.abs(erkek.y-disi.y);

            if (xFarki<=3 || yFarki<=3 ){

                // Yeni doğan hayvanın koordinatı anne babanın koordinatının ortalaması olarak belirlenir.
                int yeniDoganX = (erkek.x + disi.x) / 2;
                int yeniDoganY = (erkek.y + disi.y) / 2;

                // Yeni doğanın cinsiyeti random belirleniyor.
                String yeniDoganCinsiyet = Math.random() < 0.5 ? "Erkek" : "Dişi";

                // Yeni doğan hayvan listeye eklenir .
                hayvanlar.add(new Hayvan(ciftlesecekTur, yeniDoganCinsiyet, yeniDoganX, yeniDoganY));
                // Kontrol amaçlı yazdığım kodlar .
                //System.out.println("Çiftleşme oldu. Yeni doğan " + ciftlesecekTur + " eklendi. Cinsiyeti: " + yeniDoganCinsiyet);
                //System.out.println("Yeni doganın koordinatları : " +yeniDoganX + " " + yeniDoganY );
            }

        }
    }




}