package L01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P04MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String inputLine = scanner.nextLine();
        String[] input = inputLine.split("");
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int currentChar = 0; currentChar < input.length; currentChar++) {
            if (input[currentChar].equals("(")) {
                stack.push(currentChar);
            } else if (input[currentChar].equals(")")) {
                int startIndex = stack.pop();
                String content = inputLine.substring(startIndex, currentChar + 1);
                System.out.println(content);
            }
        }
    }
}
