package src.main.java.dsaSchool;

public class QueueV2 {
    Node head;
    Node tail;

    private class Node {
        Integer item;
        Node next;

        private Node(Integer item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public QueueV2() {
        this.tail = null;
        this.head = null;
    }

    public void enqueue(Integer item) {
        Node newNode = new Node(item, null);

        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        }
        else {
            this.tail.next = newNode;
            this.tail = newNode;
        }

    }

    public Integer dequeue() {
        if (this.head == null) {
            return null;
        }

        Integer item = this.head.item;
        this.head = this.head.next;

        if (this.head == null) {
            this.tail = null;
        }

        return null;
    }
}