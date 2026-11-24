import java.util.Scanner;

public class BankSampah12 {
    static Scanner sc = new Scanner(System.in);

    static double[] inputSetoran(int n) {
        double[] setoran = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Masukkan berat setoran nasabah ke-" + (i + 1) + " (kg): ");
            setoran[i] = sc.nextDouble();
        }
        return setoran;
    }

    static void tampilSetoran(double[] setoran) {
        System.out.println("\n===== DATA SETORAN SAMPAH =====");
        for (int i = 0; i < setoran.length; i++) {
            System.out.println("Nasabah ke-" + (i + 1) + ": " + setoran[i] + " kg");
        }
    }

    static double totalSetoran(double[] setoran) {
        double total = 0;
        for (double kg : setoran) {
            total += kg;
        }
        return total;
    }

    static double hitungSaldo(double beratKg, double hargaPerKg) {
        return beratKg * hargaPerKg;
    }

    static int nasabahTerbanyak(double[] setoran) {
        int idxTerbanyak = 0;
        for (int i = 1; i < setoran.length; i++) {
            if (setoran[i] > setoran[idxTerbanyak]) {
                idxTerbanyak = i;
            }
        }
        return idxTerbanyak;
    }

    public static void main(String[] args) {
        double hargaPerKg = 3000;

        System.out.print("Masukkan jumlah nasabah (N): ");
        int n = sc.nextInt();

        double[] dataSetoran = inputSetoran(n);
        tampilSetoran(dataSetoran);

        System.out.println("\n===== SALDO SETIAP NASABAH (Rp3.000/kg) =====");
        for (int i = 0; i < dataSetoran.length; i++) {
            double saldo = hitungSaldo(dataSetoran[i], hargaPerKg);
            System.out.println("Nasabah ke-" + (i + 1) + ": Rp" + saldo);
        }

        double totalBerat = totalSetoran(dataSetoran);
        int idxTerbesar = nasabahTerbanyak(dataSetoran);

        System.out.println("\nTotal berat seluruh setoran : " + totalBerat + " kg");
        System.out.println("Setoran terbesar            : Nasabah ke-" + (idxTerbesar + 1) + " (" + dataSetoran[idxTerbesar] + " kg)");

        sc.close();
    }
}