package Task4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n=== MENU BENTUK ===");
            System.out.println("1. Bujursangkar");
            System.out.println("2. Lingkaran");
            System.out.println("3. Silinder");
            System.out.println("4. Demo polimorfisme");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilihan = in.nextInt();
            in.nextLine();

            switch (pilihan) {
                case 1: {
                    System.out.print("Sisi: ");
                    double sisi = in.nextDouble(); in.nextLine();
                    System.out.print("Warna: ");
                    String warna = in.nextLine();
                    new BujurSangkar(sisi, warna).printInfo();
                    break;
                }
                case 2: {
                    System.out.print("Radius: ");
                    double r = in.nextDouble(); in.nextLine();
                    System.out.print("Warna: ");
                    String warna = in.nextLine();
                    new Lingkaran(r, warna).printInfo();
                    break;
                }
                case 3: {
                    System.out.print("Tinggi: ");
                    double t = in.nextDouble();
                    System.out.print("Radius: ");
                    double r = in.nextDouble(); in.nextLine();
                    System.out.print("Warna: ");
                    String warna = in.nextLine();
                    new Silinder(t, r, warna).printInfo();
                    break;
                }
                case 4:
                    demoPolimorfisme();
                    break;
                case 0:
                    System.out.println("Selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);

        in.close();
    }

    private static void demoPolimorfisme() {
        Bentuk[] daftar = {
            new Bentuk("Merah"),
            new BujurSangkar(4, "Biru"),
            new Lingkaran(7, "Hijau"),
            new Silinder(10, 7, "Kuning")
        };
        for (Bentuk b : daftar) {
            b.printInfo();
        }
    }
}