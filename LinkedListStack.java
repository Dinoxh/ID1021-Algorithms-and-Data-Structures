package src.main.java.dsaSchool;

import java.util.EmptyStackException;

class LinkedListStack {
    private Node top; // Points to the top of the stack
    private int size; // Keeps track of the size of the stack

    // Inner class representing a node in the linked list
    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Push an element onto the stack
    public void push(int val) {
        Node newNode = new Node(val);
        newNode.next = top;  // Point the new node to the previous top
        top = newNode;       // Make the new node the top of the stack
        size++;
    }

    // Pop an element off the stack
    public int pop() {
        if (top == null) {
            throw new EmptyStackException(); // Stack underflow
        }
        int poppedValue = top.data;
        top = top.next;  // Move the top pointer to the next node
        size--;
        return poppedValue;
    }

    // Peek at the top element of the stack
    public int peek() {
        if (top == null) {
            throw new EmptyStackException(); // Stack is empty
        }
        return top.data;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Get the size of the stack
    public int size() {
        return size;
    }
}

