package uasgenap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DoubleLinkedList transaksiList = new DoubleLinkedList();

        Kendaraan kendaraan1 = new Kendaraan("S 4567 YV", "Basko", "Mobil", 2000, 2012, 4);
        Kendaraan kendaraan2 = new Kendaraan("N 4511 VS", "Arta", "Mobil", 2500, 2015, 3);
        Kendaraan kendaraan3 = new Kendaraan("AB 4321 A", "Wisnu", "Motor", 125, 2010, 2);
        Kendaraan kendaraan4 = new Kendaraan("B 1234 AG", "Sisa", "Motor", 150, 2020, 1);

        TransaksiPajak transaksi1 = new TransaksiPajak(350000, 200000, 5, kendaraan1);
        TransaksiPajak transaksi2 = new TransaksiPajak(300000, 100000, 4, kendaraan2);
        TransaksiPajak transaksi3 = new TransaksiPajak(450000, 200000, 6, kendaraan3);
        TransaksiPajak transaksi4 = new TransaksiPajak(500000, 250000, 3, kendaraan4);


        transaksiList.add(transaksi1);
        transaksiList.add(transaksi2);
        transaksiList.add(transaksi3);
        transaksiList.add(transaksi4);

        Scanner input = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Menu");
            System.out.println("1. Daftar Kendaraan");
            System.out.println("2. Bayar Pajak");
            System.out.println("3. Tampilkan seluruh transaksi");
            System.out.println("4. Urutkan transaksi berdasarkan nama pemilik (ASC)");
            System.out.println("5. Keluar");
            System.out.print("Pilih (1-5): ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("| Nomer TNKB | Nama Pemilik | Jenis | CC Kendaraan | Tahun | Bulan harus bayar");
                    Node current = transaksiList.head;
                    while (current != null) {
                        Kendaraan kendaraan = current.data.kendaraan;
                        System.out.format("| %-11s| %-13s| %-6s| %-13s| %-6d| %-15d%n",
                            kendaraan.noTNKB, kendaraan.nama, kendaraan.jenis,
                            kendaraan.cc, kendaraan.tahun, kendaraan.bulanHarusBayar);
                        current = current.next;
                    }
                    break;
                case 2:
                    System.out.print("Masukkan nomor TNKB: ");
                    input.nextLine();
                    String noTNKB = input.nextLine();
                    TransaksiPajak transaksi = transaksiList.findTransaksiByTNKB(noTNKB);
                    if (transaksi != null) {
                        Kendaraan kendaraan = transaksi.kendaraan;
                        System.out.println("Detail Kendaraan:");
                        System.out.println("| Nomer TNKB | Nama Pemilik | Jenis | CC Kendaraan | Tahun | Bulan harus bayar");
                        System.out.format("| %-11s| %-13s| %-6s| %-13d| %-6d| %-15d%n",
                            kendaraan.noTNKB, kendaraan.nama, kendaraan.jenis,
                            kendaraan.cc, kendaraan.tahun, kendaraan.bulanHarusBayar);
                        System.out.print("Masukkan bulan bayar: ");
                        int bulanBayar = input.nextInt();
                        transaksi.bulanBayar = bulanBayar;
                        System.out.println("Pembayaran pajak berhasil untuk kendaraan dengan nomor TNKB " + noTNKB);
                    } else {
                        System.out.println("Kendaraan dengan nomor TNKB tersebut tidak ditemukan.");
                    }
                    break;
                case 3:
                    System.out.println("Seluruh Transaksi:");
                    transaksiList.display();
                    break;
                case 4:
                    System.out.println("Transaksi setelah diurutkan berdasarkan nama pemilik (ASC):");
                    transaksiList.sortByOwnerNameASC();
                    transaksiList.display();
                    break;
                case 5:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (choice != 5);

        input.close();
    }
}