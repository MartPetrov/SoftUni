package L01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Exercise_P01ReverseNumbersWithStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (String number : input) {
            stack.push(number);
        }
        while (stack.size() > 1) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println(stack.peek());
    }
}

