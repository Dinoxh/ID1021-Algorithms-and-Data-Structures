package src.main.java.dsaSchool;

public class QueueV1 {
    Node head;

    private class Node {
        Integer item;
        Node next;

        private Node(Integer item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public QueueV1() {
        head = null;
    }

    public void enqueue(Integer item) {
        if (head == null) {
            head = new Node(item, null);
        } else {
            Node copyNode = head;
            while (copyNode.next != null) {
                copyNode = copyNode.next;
            }
            copyNode.next = new Node(item, null);
        }
    }

    public Integer dequeue() {
        if (head.item == null) {
            return null;
        }
        Integer item = head.item;
        head = head.next;

        return null;
    }
}