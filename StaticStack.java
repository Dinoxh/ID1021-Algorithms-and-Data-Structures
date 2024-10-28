package src.main.java.dsaSchool;

import java.util.EmptyStackException;

//convert variables to same as DynamicStack
public class StaticStack {
    int[] stack;
    int top = -1; //-1 to show stack is empty

    public StaticStack(int size) {
        this.stack = new int[size];
    }

    public void push(int val) {
        if (top >= stack.length - 1) {
            System.out.println("Stack is full");
        }
        else {
            stack[++top] = val;
        }


    }

    public int pop() {

        try {
            if (top <= 0) {
                throw new EmptyStackException(); // Throw exception if stack is empty
            }
            return stack[top--]; // Return the top element and decrement top
        }
        catch (EmptyStackException e) {
            System.out.println("Error: Stack is empty. Cannot pop."); // Handle exception
            return -1; // Return an invalid value or handle differently
        }
    }
}