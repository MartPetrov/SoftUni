package ExamPrep.P01;

import java.util.ArrayDeque;
import java.util.Scanner;


public class P01Meeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputLineMale = scanner.nextLine().split(" ");
        String[] inputLineFemale = scanner.nextLine().split(" ");
        ArrayDeque<Integer>  stackOfMale = new ArrayDeque<>();
        ArrayDeque<Integer>  queueOfFemale = new ArrayDeque<>();

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
                equalOrBelow0 (currentMale, currentFemale, stackOfMale, queueOfFemale);
                continue;
            }

            if (currentMale == currentFemale) {
                queueOfFemale.poll();
                stackOfMale.pop();
                matches++;
            } else {
                queueOfFemale.poll();
                stackOfMale.pop();
                if (stackOfMale.isEmpty() || queueOfFemale.isEmpty()) {
                    stackOfMale.push(currentMale - 2);
                    for (int i = 0; i < queueOfFemale.size(); i++) {
                        int currentFemaleCheck = queueOfFemale.poll();
                        isDivisibleBy25(currentMale,currentFemaleCheck,stackOfMale,queueOfFemale);
                    }
                    break;
                } else {
                    stackOfMale.push(currentMale - 2);
                }

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
            stackOfMale.pop();
            stackOfMale.pop();
        }
        if (currentFemale % 25 == 0) {
            queueOfFemale.poll();
            queueOfFemale.poll();
        }
    }

    private static void equalOrBelow0(int currentMale, int currentFemale, ArrayDeque<Integer> stackOfMale, ArrayDeque<Integer> queueOfFemale) {

        if (currentMale <= 0) {
            stackOfMale.remove(currentMale);
        }
        if (currentFemale <= 0 ) {
            queueOfFemale.remove(currentFemale);
        }
    }
}
