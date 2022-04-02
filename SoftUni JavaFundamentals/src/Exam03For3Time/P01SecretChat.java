package Exam03For3Time;

import java.util.Scanner;

public class P01SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder text = new StringBuilder(scanner.nextLine());

        String command = scanner.nextLine();
        while (!command.equals("Reveal")) {
            String[] commandArr = command.split(":\\|:");
            switch (commandArr[0]) {
                case "InsertSpace":
                    int index = Integer.parseInt(commandArr[1]);
                    insertSpace(text,index);
                    break;
                case "Reverse":
                    String substring = commandArr[1];
                    reverse(text,substring);
                    break;
                case "ChangeAll":
                    String substringToChange = commandArr[1];
                    String replacement = commandArr[2];
                    text = changeAll(text,substringToChange,replacement);
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.printf("You have a new text message: %s", text.toString());
    }

    private static StringBuilder changeAll(StringBuilder text, String substringToChange, String replacement) {
        text = new StringBuilder(text.toString().replaceAll(substringToChange, replacement));
        System.out.println(text);
        return text;
    }


    private static void reverse(StringBuilder text, String substring) {
        if (text.toString().contains(substring)){
            StringBuilder reverse = new StringBuilder(substring).reverse();
            int indexOf = text.indexOf(substring);
            text.delete(indexOf, indexOf + substring.length());
            text.append(reverse);
            System.out.println(text);
        } else {
            System.out.printf("error%n");
        }
    }

    private static void insertSpace(StringBuilder text,int index) {
        text.insert(index, " ");
        System.out.println(text);
    }
}
