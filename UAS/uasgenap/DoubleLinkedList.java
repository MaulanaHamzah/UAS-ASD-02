package uasgenap;

class DoubleLinkedList {
    Node head;
    Node tail;

    void add(TransaksiPajak data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    void display() {
        Node current = head;
        while (current != null) {
            System.out.println("Kode Transaksi: " + current.data.kode);
            System.out.println("Nominal Bayar: " + current.data.nominalBayar);
            System.out.println("Denda: " + current.data.denda);
            System.out.println("Bulan Bayar: " + current.data.bulanBayar);
            System.out.println("Nomor TNKB: " + current.data.kendaraan.noTNKB);
            System.out.println("Nama Pemilik: " + current.data.kendaraan.nama);
            System.out.println("----------------------");
            current = current.next;
        }
    }

    void sortByOwnerNameASC() {
        if (head == null || head.next == null) {
            return;
        }
        boolean swapped;
        do {
            swapped = false;
            Node current = head;
            while (current.next != null) {
                if (current.data.kendaraan.nama.compareTo(current.next.data.kendaraan.nama) > 0) {
                    TransaksiPajak temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }

    TransaksiPajak findTransaksiByTNKB(String noTNKB) {
        Node current = head;
        while (current != null) {
            if (current.data.kendaraan.noTNKB.equals(noTNKB)) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }
}