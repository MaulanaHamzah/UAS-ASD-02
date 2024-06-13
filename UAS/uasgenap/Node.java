package uasgenap;

class Node {
    TransaksiPajak data;
    Node prev;
    Node next;

    Node(TransaksiPajak data) {
        this.data = data;
    }
}
