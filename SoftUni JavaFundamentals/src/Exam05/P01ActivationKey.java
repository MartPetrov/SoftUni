package Exam05;

import java.util.Locale;
import java.util.Scanner;

public class P01ActivationKey {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String[] commandArr = scanner.nextLine().split(">>>");

        while (!commandArr[0].equals("Generate")) {
            StringBuilder sb = new StringBuilder();
            switch (commandArr[0]) {
                case "Contains":
                    String substring = commandArr[1];
                    if (text.contains(substring)) {
                        System.out.printf("%s contains %s%n", text, substring);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    String letter = commandArr[1];
                    int startIndex = Integer.parseInt(commandArr[2]);
                    int endIndex = Integer.parseInt(commandArr[3]);
                    String textSubs = text.substring(startIndex, endIndex);
                    if (letter.equals("Upper")) {
                        text = text.replace(textSubs, textSubs.toUpperCase());
                        System.out.println(text);
                    } else if (letter.equals("Lower")) {
                        text = text.replace(textSubs, textSubs.toLowerCase());
                        System.out.println(text);
                    }
                    break;
                case "Slice":
                    int startInd = Integer.parseInt(commandArr[1]);
                    int endInd = Integer.parseInt(commandArr[2]);
                    String textSub = text.substring(startInd,endInd);
                    text = text.replace(textSub,"");
                    System.out.println(text);
                    break;
            }

            commandArr = scanner.nextLine().split(">>>");
        }
        System.out.printf("Your activation key is: %s", text);
    }
}
