import java.util.Scanner;

public class RekapLaundry12 {
    static Scanner sc = new Scanner(System.in);

    static void inputBeratCucian(String[] layanan, String[] hari, int[][] data) {
        for (int i = 0; i < layanan.length; i++) {
            System.out.println("Input berat cucian (kg) untuk " + layanan[i] + ":");
            for (int j = 0; j < hari.length; j++) {
                System.out.print("  " + hari[j] + ": ");
                data[i][j] = sc.nextInt();
            }
        }
    }

    static void tampilTabel(String[] layanan, int[] hargaPerKg, String[] hari, int[][] data) {
        System.out.println("\n===== TABEL REKAP BERAT CUCIAN (KG) =====");
        System.out.printf("%-15s %-12s", "Layanan", "Harga/kg");
        for (String h : hari) {
            System.out.printf(" %-8s", h);
        }
        System.out.println();

        for (int i = 0; i < layanan.length; i++) {
            System.out.printf("%-15s Rp%-10d", layanan[i], hargaPerKg[i]);
            for (int j = 0; j < hari.length; j++) {
                System.out.printf(" %-8d", data[i][j]);
            }
            System.out.println();
        }
    }

    static int totalPerLayanan(int[][] data, int idxLayanan) {
        int total = 0;
        for (int j = 0; j < data[idxLayanan].length; j++) {
            total += data[idxLayanan][j];
        }
        return total;
    }

    static void tampilLayananTertinggi(String[] layanan, int[][] data) {
        int idxMax = 0;
        int maxTotal = totalPerLayanan(data, 0);

        for (int i = 1; i < layanan.length; i++) {
            int total = totalPerLayanan(data, i);
            if (total > maxTotal) {
                maxTotal = total;
                idxMax = i;
            }
        }
        System.out.println("\nLayanan total berat tertinggi : " + layanan[idxMax] + " (" + maxTotal + " kg)");
    }

    static int hariTersibuk(int[][] data) {
        int jumlahHari = data[0].length;
        int idxHariMax = 0;
        int maxBerat = 0;

        for (int i = 0; i < data.length; i++) {
            maxBerat += data[i][0];
        }

        for (int j = 1; j < jumlahHari; j++) {
            int totalHari = 0;
            for (int i = 0; i < data.length; i++) {
                totalHari += data[i][j];
            }
            if (totalHari > maxBerat) {
                maxBerat = totalHari;
                idxHariMax = j;
            }
        }
        return idxHariMax;
    }

    static void tampilPendapatan(String[] layanan, int[] hargaPerKg, int[][] data) {
        System.out.println("\n===== PENDAPATAN LAYANAN =====");
        int totalPendapatan = 0;
        for (int i = 0; i < layanan.length; i++) {
            int berat = totalPerLayanan(data, i);
            int pendapatan = berat * hargaPerKg[i];
            totalPendapatan += pendapatan;
            System.out.println(layanan[i] + " (" + berat + " kg x Rp" + hargaPerKg[i] + ") = Rp" + pendapatan);
        }
        System.out.println("Total pendapatan selama 6 hari : Rp" + totalPendapatan);
    }

    public static void main(String[] args) {
        String[] layanan = {"Cuci Kering", "Cuci Setrika", "Setrika Saja", "Express"};
        int[] hargaPerKg = {6000, 8000, 5000, 12000};
        String[] hari = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu"};
        int[][] data = {
            {12, 15, 10, 18, 20, 25},
            {20, 18, 22, 15, 30, 35},
            {8, 5, 10, 7, 6, 12},
            {3, 6, 2, 5, 8, 10}
        };

        System.out.print("Gunakan data rekap bawaan soal (y) atau input manual (n)? ");
        String pilih = sc.next();
        if (pilih.equalsIgnoreCase("n")) {
            inputBeratCucian(layanan, hari, data);
        }

        tampilTabel(layanan, hargaPerKg, hari, data);
        tampilLayananTertinggi(layanan, data);

        int idxHariSibuk = hariTersibuk(data);
        System.out.println("Hari tersibuk                 : " + hari[idxHariSibuk]);

        tampilPendapatan(layanan, hargaPerKg, data);
        sc.close();
    }
}