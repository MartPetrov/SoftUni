package com.PrepForExam;

import java.util.Scanner;

public class P01SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder text = new StringBuilder(scanner.nextLine());
        String[] commandArr = scanner.nextLine().split(":\\|:");

        while (!commandArr[0].equals("Reveal")) {

            switch (commandArr[0]) {
                case "InsertSpace":
                    int indexToInsert =  Integer.parseInt(commandArr[1]);
                    insertSpace (text,indexToInsert);
                    System.out.println(text);
                    break;
                case "Reverse":
                    String substring = commandArr[1];
                    reverse (text,substring);
                    break;
                case "ChangeAll":
                    String substringToChange = commandArr[1];
                    String replacement = commandArr[2];
                    text = changeAll(text,substringToChange,replacement);
                    System.out.println(text);
                    break;
            }
            commandArr = scanner.nextLine().split(":\\|:");
        }
        System.out.printf("You have a new text message: %s", text);
    }

    private static void insertSpace(StringBuilder text, int indexToInsert) {
        text.insert(indexToInsert," ");
    }

    private static void reverse(StringBuilder text, String substring) {
        if (text.toString().contains(substring)) {
            StringBuilder toAdd = new StringBuilder(substring).reverse();
            int indexStart = text.indexOf(substring);
            int indexEnd = indexStart + substring.length();
            text.delete(indexStart,indexEnd);
            text.append(toAdd);
            System.out.println(text);
        } else {
            System.out.printf("error%n");
        }

    }

    private static StringBuilder changeAll(StringBuilder text, String substringToChange, String replacement) {
      return new StringBuilder(text.toString().replace(substringToChange,replacement));
    }

}
