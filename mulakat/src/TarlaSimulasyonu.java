import java.util.ArrayList;
import java.util.Random;

public class TarlaSimulasyonu {

    public static void main(String[] args) {
        int tarlaBoyut = 500;
        int hayvanSayisi = 30 + 10 + 10 + 10 + 10 + 8 + 1; // Toplam canlı sayısı
        int iterasyonSayisi = 1000;

        ArrayList<Hayvan> hayvanlar = new ArrayList<>();

        // Hayvanlara rastgele koordinat atanıyor.
        Random rand = new Random();

        for (int i = 0; i < hayvanSayisi; i++) {
            int x = rand.nextInt(tarlaBoyut);
            int y = rand.nextInt(tarlaBoyut);
            String cinsiyet = i % 2 == 0 ? "Erkek" : "Dişi";

            if (i < 30) {
                hayvanlar.add(new Hayvan("Koyun", cinsiyet, x, y));
            } else if (i < 40) {
                hayvanlar.add(new Hayvan("İnek", cinsiyet, x, y));
            } else if (i < 50) {
                hayvanlar.add(new Hayvan("Tavuk", cinsiyet, x, y));
            } else if (i < 60) {
                hayvanlar.add(new Hayvan("Kurt", cinsiyet, x, y));
            } else if (i < 70) {
                hayvanlar.add(new Hayvan("Horoz", cinsiyet, x, y));
            } else if (i < 78) {
                hayvanlar.add(new Hayvan("Aslan", cinsiyet, x, y));
            }
            else if (i == hayvanSayisi - 1) {
                // Sonuncu hayvanı Avcı olarak seçtim ve cinsiyetini rastgele seçtim.
                String avciCinsiyet = rand.nextBoolean() ? "Erkek" : "Dişi";
                hayvanlar.add(new Hayvan("Avci", avciCinsiyet, x, y));
            }
        }
        // İterasyonlar
        for (int iterasyon = 1; iterasyon <= iterasyonSayisi; iterasyon++) {
            // System.out.println("Iterasyon " + iterasyon + ":\n");

            for (Hayvan hayvan : hayvanlar) {
                hayvan.hareketEt(tarlaBoyut);
                // Alttaki kodu kontrol amaçlı yazdım.
                // System.out.println(hayvan.tur + " - C : " + hayvan.cinsiyet + " - K : (" + hayvan.x + ", " + hayvan.y + ")");
            }

            //Fonksiyonları tek tek çağırdım .

            String[] avlananHayvanlar = {"Koyun", "Kurt", "İnek", "Tavuk", "Horoz", "Aslan"};

            for (String avlananHayvan : avlananHayvanlar) {
                Hayvan.avciAvlar(hayvanlar, avlananHayvan);
            }

            String[] kurtYiyenler = {"Tavuk", "Horoz", "Koyun"};
            for (String kurtYiyen : kurtYiyenler) {
                Hayvan.kurtYer(hayvanlar, kurtYiyen);
            }

            String[] aslanYiyenler = {"İnek", "Koyun"};
            for (String aslanYiyen : aslanYiyenler) {
                Hayvan.aslanYer(hayvanlar, aslanYiyen);
            }

            String[] ciftlesenler = {"Kurt", "Koyun", "İnek", "Tavuk", "Horoz", "Aslan"};
            for (String ciftlesenecekTur : ciftlesenler) {
                Hayvan.ciftlesme(hayvanlar, ciftlesenecekTur);
            }

            // System.out.println("\n----------------\n");
        }

        System.out.println("Son durumda toplam hayvan sayısı: " + hayvanlar.size());

    }
}