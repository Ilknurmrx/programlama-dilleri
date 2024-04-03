import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Eleman {

    int veri;
    int adres;

    public Eleman(int veri, int adres) {
        this.veri = veri;
        this.adres = adres;
    }
}

public class Bagli_Sirala {

    public static void main(String[] args) {
        // Dosya ismini klavyeden al
        Scanner scanner = new Scanner(System.in);
        System.out.print("Dosya adini giriniz: ");
        String dosyaAdi = scanner.nextLine();
        scanner.close();

        // Dosyadan veri okuma
        Eleman[] dizi = new Eleman[100];
        int index = 0; // Veri atanmış eleman sayısını tutmak için index değişkeni eklendi
        try {
            File dosya = new File(dosyaAdi);
            Scanner dosyaOkuyucu = new Scanner(dosya);

            // Dosyadaki her satırdaki sayıları diziye aktar
            while (dosyaOkuyucu.hasNextLine()) {
                int sayi = Integer.parseInt(dosyaOkuyucu.nextLine());
                dizi[index++] = new Eleman(sayi, index - 1); // Adresler dizinin indeksi olarak atanıyor
            }
            dosyaOkuyucu.close();

            // Konsolda sıralanmamış ve sıralanmış halleri yan yana olarak göster
        } catch (FileNotFoundException e) {
            System.out.println("Dosya bulunamadi.");
            e.printStackTrace();
        }

        Eleman[] siralanmis = new Eleman[index]; // index, veri atanmış elemanların sayısını tutar

        for(int i = 0; i < index; i++){
            siralanmis[i] = new Eleman(dizi[i].veri,i);
        }

        // Diğer işlemler aynen devam ediyor...

        int k = 0;
        Eleman[] sayilar = new Eleman[dizi.length];
        for (int i = 0; i < dizi.length; i++) {
            sayilar[i] = new Eleman(0, 0); // veya istediğiniz başlangıç değerleri
        }
        for (int i = 0; i < index; i++) { // Dizideki veri atanmış eleman sayısına kadar döngü çalışacak
            for (int j = 0; j < dizi.length; j++) {
                sayilar[j].veri = Integer.MAX_VALUE;
                sayilar[j].adres = 0;
            }
            
            for (int j = 0; j < index; j++) { // Dizideki veri atanmış eleman sayısına kadar döngü çalışacak
                if (siralanmis[i].veri < siralanmis[j].veri) {
                    sayilar[k].veri = dizi[j].veri;
                    sayilar[k++].adres = dizi[j].adres;
                }
            }
            
            siralanmis[i].adres = min(sayilar);
        }
        
        // En büyük ve en küçük elemanların indekslerini bul
        int enBuyukIndeks = 0;
        int enKucukIndeks = 0;
        for (int i = 0; i < index; i++) {
            if (siralanmis[i].veri > siralanmis[enBuyukIndeks].veri) {
                enBuyukIndeks = i;
            }
            if (dizi[i].veri < dizi[enKucukIndeks].veri) {
                enKucukIndeks = i;
            }
        }
        
        // En büyük elemanın adresini en küçük elemanın adresiyle değiştir
        siralanmis[enBuyukIndeks].adres = dizi[enKucukIndeks].adres;

        // Dizideki eleman sayısı yerine veri atanmış eleman sayısı kullanıldı
        System.out.println("Siralanmamis Hali\tSiralanmis Hali");
        System.out.println("\t");
        for (int i = 0; i < index; i++) {
            System.out.println(dizi[i].veri + " " + i + "\t\t\t" + siralanmis[i].veri + " " + siralanmis[i].adres);
        }
        
    }

    public static int min(Eleman[] sayilar) {
        int index = sayilar[0].adres;
        int min = sayilar[0].veri;
        for (int i = 0; i < sayilar.length; i++) {
            if (sayilar[i].veri < min) {
                min = sayilar[i].veri;
                index = sayilar[i].adres;
            }
        }
        return index;
    }
}