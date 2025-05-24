import java.util.Scanner;

public class Main {
    static String[] filmler = new String[10];
    static int[] sureler = new int[10];
    static String[] turler = new String[10];
    static int filmSayisi = 0;

    static String[] musteriAdlari = new String[20];
    static String[] musteriMailleri = new String[20];
    static int musteriSayisi = 0;

    static boolean[][] biletler = new boolean[20][10];

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Sinema Müşteri Kayıt Sistemi ---");
            System.out.println("1. Film Ekle");
            System.out.println("2. Müşteri Ekle");
            System.out.println("3. Bilet Sat");
            System.out.println("4. Biletleri Listele");
            System.out.println("0. Çıkış");
            System.out.print("Seçiminiz: ");
            int secim = scanner.nextInt();
            scanner.nextLine();

            switch (secim) {
                case 1 -> filmEkle();
                case 2 -> musteriEkle();
                case 3 -> biletSat();
                case 4 -> biletleriListele();
                case 0 -> System.exit(0);
                default -> System.out.println("Geçersiz seçim!");
            }
        }
    }

    static void filmEkle() {
        if (filmSayisi >= 10) {
            System.out.println("Film listesi dolu!");
            return;
        }

        System.out.print("Film adı: ");
        filmler[filmSayisi] = scanner.nextLine();
        System.out.print("Süresi (dk): ");
        sureler[filmSayisi] = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Türü: ");
        turler[filmSayisi] = scanner.nextLine();

        filmSayisi++;
        System.out.println("Film eklendi.");
    }

    static void musteriEkle() {
        if (musteriSayisi >= 20) {
            System.out.println("Müşteri listesi dolu!");
            return;
        }

        System.out.print("Müşteri adı: ");
        musteriAdlari[musteriSayisi] = scanner.nextLine();
        System.out.print("Email: ");
        musteriMailleri[musteriSayisi] = scanner.nextLine();

        musteriSayisi++;
        System.out.println("Müşteri eklendi.");
    }

    static void biletSat() {
        System.out.println("Müşteriler:");
        for (int i = 0; i < musteriSayisi; i++) {
            System.out.println((i + 1) + ". " + musteriAdlari[i]);
        }

        System.out.print("Müşteri numarası: ");
        int mid = scanner.nextInt() - 1;

        System.out.println("Filmler:");
        for (int i = 0; i < filmSayisi; i++) {
            System.out.println((i + 1) + ". " + filmler[i]);
        }

        System.out.print("Film numarası: ");
        int fid = scanner.nextInt() - 1;

        if (mid >= 0 && mid < musteriSayisi && fid >= 0 && fid < filmSayisi) {
            biletler[mid][fid] = true;
            System.out.println("Bilet kaydedildi.");
        } else {
            System.out.println("Geçersiz seçim.");
        }
    }

    static void biletleriListele() {
        for (int i = 0; i < musteriSayisi; i++) {
            System.out.print(musteriAdlari[i] + " -> ");
            for (int j = 0; j < filmSayisi; j++) {
                if (biletler[i][j]) {
                    System.out.print(filmler[j] + " | ");
                }
            }
            System.out.println();
        }
    }
}