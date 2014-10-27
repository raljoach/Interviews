package careercup.datastructures.linkedlist.yr130404;

public class LinkedList {
    public static Node create(int[] vals) {
        Node head = null;
        Node prev = null;
        for (int v : vals) {
            if (prev == null) {
                head = new Node(v);
                prev = head;
            } else {
                Node newNode = new Node(v);
                prev.next = newNode;
                prev = newNode;
            }
        }
        return head;
    }

}
