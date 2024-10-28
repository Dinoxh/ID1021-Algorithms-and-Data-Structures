package src.main.java.dsaSchool;

import java.io.*;


public class HP35 {
    public static void main(String[] args) throws IOException {
        DynamicStack stack = new DynamicStack(10);
        System.out.println("HP-35 pocket calculator");

        boolean run = true;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(run) {
            System.out.print(" > ");
            String input = br.readLine();
            switch (input) {
                case "+":
                    stack.push(stack.pop() + stack.pop()); // pop two numbers, add and push result
                    break;
                case "-":
                    int nr1 = stack.pop();
                    int nr2 = stack.pop();
                    stack.push(nr2 - nr1);

                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "":
                    run = false;
                    break;
                default:
                    int nr = Integer.parseInt(input);
                    stack.push(nr);// push the number
                    break;
            }}
        System.out.printf("the result is: %d\n\n", stack.pop());
        System.out.printf("I love reversed polish notation, don't you?\n");
    }
}

// 423*4+4*+2-

////since pop takes top, it will go right to left.  1 + 2     pop 2   add  pop 1 = result
// issues: added everything before operand to stack, instead of pairs of numbers
// I did not update the capacity in the resize function. which lead to the capacity getting halved, but never increased