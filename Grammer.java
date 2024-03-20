import java.util.Scanner;

public class Grammer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Cumleyi girsen iyi olur: ");
        String cumle = scanner.nextLine().trim();
       
        scanner.close();

       
        String[] parts = cumle.split("\\s+");

        if (parts.length != 3) {
            System.out.println("HAYIR");
            return;
        }

        String ozne = parts[0];
        String nesne = parts[1];
        String yuklem = parts[2];

        String[] ozneGrubu = {"Ben", "Sen", "Hasan", "Nurşah", "Elif", "Abdulrezzak", "Şehribanu", "Zeynelabidin", "Naki"};
        String[] nesneGrubu = {"Bahçe", "Okul", "Park", "Sınıf", "Yarın", "Pazartesi", "Salı", "Çarşamba", "Perşembe", "Cuma",
                "Cumartesi", "Pazar", "Merkez", "Ev", "Kitap", "Defter", "Güneş", "Beydağı"};
        String[] yuklemGrubu = {"Gitmek", "Gelmek", "Okumak", "Yazmak", "Yürümek", "Görmek"};

        boolean ozneVar = false;
        boolean nesneVar = false;
        boolean yuklemVar = false;

        for (String s : ozneGrubu) {
            if (ozne.equalsIgnoreCase(s)) {
                ozneVar = true;
                break;
            }
        }

        for (String s : nesneGrubu) {
            if (nesne.equalsIgnoreCase(s)) {
                nesneVar = true;
                break;
            }
        }

        for (String s : yuklemGrubu) {
            if (yuklem.equalsIgnoreCase(s)) {
                yuklemVar = true;
                break;
            }
        }

        if (ozneVar && nesneVar && yuklemVar) {
            System.out.println("EVET");
        } else {
            System.out.println("HAYIR");
        }
    }
}
