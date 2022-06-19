package ExamPrepare.P01;

import java.util.ArrayDeque;
import java.util.Scanner;


public class P01Meeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputLineMale = scanner.nextLine().split(" ");
        String[] inputLineFemale = scanner.nextLine().split(" ");


        ArrayDeque<Integer> stackOfMale = new ArrayDeque<>();
        ArrayDeque<Integer> queueOfFemale = new ArrayDeque<>();

        for (int i = 0; i < inputLineMale.length; i++) {
            stackOfMale.push(Integer.parseInt(inputLineMale[i]));
        }
        for (int i = 0; i < inputLineFemale.length; i++) {
            queueOfFemale.offer(Integer.parseInt(inputLineFemale[i]));
        }
        int matches = 0;

        while (!queueOfFemale.isEmpty() && !stackOfMale.isEmpty()) {
            int currentMale = stackOfMale.peek();
            int currentFemale = queueOfFemale.peek();

            if (currentMale <= 0 || currentFemale <= 0) {
                equalOrBelow0(currentMale, currentFemale, stackOfMale, queueOfFemale);
                continue;
            }
            if (currentMale % 25 == 0 || currentFemale % 25 == 0) {
                isDivisibleBy25(currentMale, currentFemale, stackOfMale, queueOfFemale);
                continue;
            }
            if (currentMale == currentFemale) {
                stackOfMale.pop();
                queueOfFemale.poll();
                matches++;
            } else {
                queueOfFemale.poll();
                stackOfMale.pop();
                stackOfMale.push(currentMale - 2);
            }


        }
        System.out.printf("Matches: %d%n", matches);
        System.out.print("Males left: ");
        if (!stackOfMale.isEmpty()) {
            for (Integer integer : stackOfMale) {
                System.out.print(integer.toString());
                stackOfMale.pop();
                if (!stackOfMale.isEmpty()) {
                    System.out.print(", ");
                }
            }
        } else {
            System.out.print("none");
        }

        System.out.println();
        System.out.print("Females left: ");
        if (!queueOfFemale.isEmpty()) {
            for (Integer integer : queueOfFemale) {
                System.out.print(integer.toString());
                queueOfFemale.poll();
                if (!queueOfFemale.isEmpty()) {
                    System.out.print(", ");
                }
            }
        } else {
            System.out.print("none");
        }
    }

    private static void isDivisibleBy25(int currentMale, int currentFemale, ArrayDeque<Integer> stackOfMale, ArrayDeque<Integer> queueOfFemale) {
        if (currentMale % 25 == 0) {
            if (stackOfMale.size() >= 1) {
                stackOfMale.pop();
            }
            if (stackOfMale.size() >= 1) {
                stackOfMale.pop();
            }

        }
        if (currentFemale % 25 == 0) {
            if (queueOfFemale.size() >= 1) {
                queueOfFemale.poll();
            }
            if (queueOfFemale.size() >= 1) {
                queueOfFemale.poll();
            }
        }
    }

    private static void equalOrBelow0(int currentMale, int currentFemale, ArrayDeque<Integer> stackOfMale, ArrayDeque<Integer> queueOfFemale) {

        if (currentMale <= 0) {
            stackOfMale.pop();
        }
        if (currentFemale <= 0) {
            queueOfFemale.poll();
        }
    }
}
