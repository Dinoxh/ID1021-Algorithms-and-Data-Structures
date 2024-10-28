package src.main.java.dsaSchool;

import java.util.EmptyStackException;

public class DynamicStack {
     int size;
     int[] stack;
     int capacity;

    public DynamicStack(int capacity){
        this.stack = new int[capacity];
        this.capacity = capacity;
    }

    public void push(int val){
        if(size >= capacity){
            reSize(capacity*2);
        }
        stack[size++] = val;
    }

    public int pop() {
        try {
            if (size <= 0) {
                throw new EmptyStackException(); // Throw exception if stack is empty
            }
        } catch (EmptyStackException e) {
            System.out.println("Stack is empty");
            return 0;
        }

        int poppedItem = stack[--size];
        if (size > 0 && size == stack.length / 4) {
            reSize(stack.length / 2);
        }

        return poppedItem;
    }

    //public int pop()

    public void reSize(int capacity){
        int[] copy = new int[capacity];
        this.capacity = capacity;

        for(int i = 0; i < size ; i++){
            copy[i] = stack[i];
        }
        stack = copy;
    }

    public int peek(){
        return stack[size - 1];
    }


}
