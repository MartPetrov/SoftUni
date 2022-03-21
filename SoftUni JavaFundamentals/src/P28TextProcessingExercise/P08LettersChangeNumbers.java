package P28TextProcessingExercise;

import java.util.Scanner;

public class P08LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String [] passwords = input.split("\\s+");

        double totalSum = 0;
        for (String password : passwords) {
            double modifiedNumber = gedModifiedNumber (password);
            totalSum += modifiedNumber;
        }
        System.out.printf("%.2f", totalSum);
    }

    private static double gedModifiedNumber(String password) {
        char firstLetter = password.charAt(0);
        char secondLetter = password.charAt(password.length() - 1);
        StringBuilder builder = new StringBuilder(password);
        double number = Double.parseDouble(builder.deleteCharAt(0).deleteCharAt(builder.length() - 1).toString());

        if (Character.isUpperCase(firstLetter)) {
            int positionUpperLetter = (int)firstLetter - 64;
                    number /= positionUpperLetter ;
        } else {
            int positionLowerLetter = (int)firstLetter - 96;
            number *= positionLowerLetter;
        }
        if (Character.isUpperCase(secondLetter)) {
            int positionUpperLetter = (int)secondLetter - 64;
            number -= positionUpperLetter ;
        } else {
            int positionLowerLetter = (int)secondLetter - 96;
            number += positionLowerLetter;
        }
        return number;
    }
}
