package Exam03For2Time;

import java.util.Scanner;

public class P01SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String command = scanner.nextLine();
        while (!command.equals("Reveal")) {
            String[] commandArr = command.split(":\\|:");
            switch (commandArr[0]) {
                case "InsertSpace":
                    int indexToInsertSpace = Integer.parseInt(commandArr[1]);
                     text = insertSpaceToIndex (text,indexToInsertSpace);
                    System.out.println(text);
                    break;
                case "Reverse":
                    String substring = commandArr[1];
                    if (text.contains(substring)) {
                        text = reverse (text,substring);
                        System.out.println(text);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "ChangeAll":
                    String substringToChange = commandArr[1];
                    String replacement = commandArr[2];
                    text = text.replace(substringToChange,replacement);
                    System.out.println(text);
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.printf("You have a new text message: %s", text);
    }

    private static String reverse(String text, String substring) {
        int indexOf = text.indexOf(substring);
        StringBuilder sbToReverse = new StringBuilder(text);
        String toAppend = sbToReverse.substring(indexOf,indexOf+substring.length());
        StringBuilder sbSubStrReverse = new StringBuilder(toAppend).reverse();
        sbToReverse.replace(indexOf,indexOf+substring.length(), "");
        sbToReverse.append(sbSubStrReverse);
        text = sbToReverse.toString();
        return text;
    }

    private static String insertSpaceToIndex(String text, int indexToInsertSpace) {
        StringBuilder sb = new StringBuilder(text);
        sb.insert(indexToInsertSpace," ");
        text = sb.toString();
        return text;
    }
}
