package L01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Exercise_P03MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int numCommand = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numCommand; i++) {
            String[] commandLine = scanner.nextLine().split(" ");
            int command = Integer.parseInt(commandLine[0]);
            if (command == 1) {
                int number = Integer.parseInt(commandLine[1]);
                stack.push(number);
            } else if (command == 2) {
                stack.pop();
            } else if (command == 3) {
                stack.stream().max(Integer::compareTo).ifPresent(System.out::println);
            }

        }
    }
}
