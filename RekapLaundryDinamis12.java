import java.util.Scanner;

public class RekapLaundryDinamis12 {
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
            System.out.printf(" %-10s", h);
        }
        System.out.println();

        for (int i = 0; i < layanan.length; i++) {
            System.out.printf("%-15s Rp%-10d", layanan[i], hargaPerKg[i]);
            for (int j = 0; j < hari.length; j++) {
                System.out.printf(" %-10d", data[i][j]);
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
        System.out.println("Total pendapatan seluruh layanan : Rp" + totalPendapatan);
    }

    public static void main(String[] args) {
        System.out.print("Masukkan jumlah layanan: ");
        int jumlahLayanan = sc.nextInt();
        System.out.print("Masukkan jumlah hari: ");
        int jumlahHari = sc.nextInt();
        sc.nextLine();

        String[] layanan = new String[jumlahLayanan];
        int[] hargaPerKg = new int[jumlahLayanan];
        String[] hari = new String[jumlahHari];
        int[][] data = new int[jumlahLayanan][jumlahHari];

        for (int j = 0; j < jumlahHari; j++) {
            hari[j] = "Hari ke-" + (j + 1);
        }

        for (int i = 0; i < jumlahLayanan; i++) {
            System.out.print("Nama layanan ke-" + (i + 1) + ": ");
            layanan[i] = sc.nextLine();
            System.out.print("Harga per kg untuk " + layanan[i] + ": ");
            hargaPerKg[i] = sc.nextInt();
            sc.nextLine();
        }

        inputBeratCucian(layanan, hari, data);
        tampilTabel(layanan, hargaPerKg, hari, data);
        tampilLayananTertinggi(layanan, data);

        int idxHariSibuk = hariTersibuk(data);
        System.out.println("Hari tersibuk                 : " + hari[idxHariSibuk]);

        tampilPendapatan(layanan, hargaPerKg, data);
        sc.close();
    }
}