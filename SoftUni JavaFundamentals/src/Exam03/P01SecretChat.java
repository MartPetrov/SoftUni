package Exam03;

import java.util.Scanner;

public class P01SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();
        String command = scanner.nextLine();
        while (!command.equals("Reveal")) {
            String[] commandArr = command.split(":\\|:");
            switch (commandArr[0]) {
                case "InsertSpace":
                    int indexToInsertSpace = Integer.parseInt(commandArr[1]);
                    StringBuilder sb = new StringBuilder(message);
                    sb.insert(indexToInsertSpace, " ");
                    message = sb.toString();
                    System.out.println(message);
                    break;
                case "Reverse":
                    String substring = commandArr[1];
                    if (message.contains(substring)) {
                        int indexOf = message.indexOf(substring);
                        StringBuilder sbToReverse = new StringBuilder(message);
                        String toAppend = sbToReverse.substring(indexOf,indexOf+substring.length());
                        StringBuilder sbSubStrReverse = new StringBuilder(toAppend).reverse();
                        sbToReverse.replace(indexOf,indexOf+substring.length(), "");
                        sbToReverse.append(sbSubStrReverse);
                        message = sbToReverse.toString();
                        System.out.println(message);
                    } else {
                        System.out.printf("error%n");
                    }
                    break;
                case "ChangeAll":
                    String subStringToChange = commandArr[1];
                    String replacement = commandArr[2];
                    if (message.contains(subStringToChange)) {
                        message = message.replaceAll(subStringToChange, replacement);
                        System.out.println(message);
                    }
                    break;
            }

            command = scanner.nextLine();
        }
        System.out.printf("You have a new text message: %s", message);
    }
}
