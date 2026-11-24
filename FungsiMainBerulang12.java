public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n===== MENU KUBUS & LIMAS PERSEGI =====");
            System.out.println("1. Luas Persegi");
            System.out.println("2. Volume Kubus");
            System.out.println("3. Luas Permukaan Kubus");
            System.out.println("4. Volume Limas Persegi");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan panjang sisi (s): ");
                    int s1 = sc.nextInt();
                    System.out.println("Luas Persegi = " + luasPersegi(s1));
                    break;
                case 2:
                    System.out.print("Masukkan panjang sisi (s): ");
                    int s2 = sc.nextInt();
                    System.out.println("Volume Kubus = " + volumeKubus(s2));
                    break;
                case 3:
                    System.out.print("Masukkan panjang sisi (s): ");
                    int s3 = sc.nextInt();
                    System.out.println("Luas Permukaan Kubus = " + luasPermukaanKubus(s3));
                    break;
                case 4:
                    System.out.print("Masukkan panjang sisi alas (s): ");
                    int s4 = sc.nextInt();
                    System.out.print("Masukkan tinggi limas (t): ");
                    int t4 = sc.nextInt();
                    System.out.println("Volume Limas Persegi = " + volumeLimasPersegi(s4, t4));
                    break;
                case 0:
                    System.out.println("Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);

        sc.close();
    }