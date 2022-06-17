package ExamPrep.P01;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P01MagicBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arrFirst = scanner.nextLine().split(" ");
        String[] arrSecond = scanner.nextLine().split(" ");

        ArrayDeque<Integer> firstBox = new ArrayDeque<>();
        ArrayDeque<Integer> secondBox = new ArrayDeque<>();

        for (int i = 0; i < arrFirst.length; i++) {
            firstBox.offer(Integer.parseInt(arrFirst[i]));
        }
        for (int i = 0; i < arrSecond.length; i++) {
            secondBox.push(Integer.parseInt(arrSecond[i]));
        }
        int sumClaimed = 0;

        while (!firstBox.isEmpty() && !secondBox.isEmpty()) {
            int currentFirst = firstBox.peek();
            int currentSecond = secondBox.peek();
            int sum = currentFirst + currentSecond;
            if (sum % 2 == 0) {
                sumClaimed += sum;
                firstBox.poll();
                secondBox.pop();
            } else {
                int toAddLast = secondBox.pop();
                firstBox.offer(toAddLast);
            }
        }

        if (firstBox.isEmpty()) {
            System.out.println("First magic box is empty.");
        }
        if (secondBox.isEmpty()) {
            System.out.println("Second magic box is empty.");
        }

        if (sumClaimed >= 90) {
            System.out.printf("Wow, your prey was epic! Value: %d%n", sumClaimed);
        } else {
            System.out.printf("Poor prey... Value: %d%n", sumClaimed);
        }
    }
}
