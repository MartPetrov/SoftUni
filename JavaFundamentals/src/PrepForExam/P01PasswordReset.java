package com.PrepForExam;

import java.util.Scanner;

public class P01PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder text = new StringBuilder(scanner.nextLine());
        String command = scanner.nextLine();

        while (!command.equals("Done")) {
            String[] commandArr = command.split(" ");
            switch (commandArr[0]) {
                case "TakeOdd":
                    text =takeOdd(text);
                    System.out.println(text.toString());
                    break;
                case "Cut":
                    int index = Integer.parseInt(commandArr[1]);
                    int length = Integer.parseInt(commandArr[2]);
                    text = cut(text,index,length);
                    System.out.println(text.toString());
                    break;
                case "Substitute":
                    String substring = commandArr[1];
                    String substitute = commandArr[2];
                    text = substitute(text,substring,substitute);
                    break;
            }

            command = scanner.nextLine();
        }
        System.out.printf("Your password is: %s", text.toString());
    }

    private static StringBuilder substitute(StringBuilder text, String substring, String substitute) {
        String textStr = text.toString();
        if (textStr.contains(substring)) {
           textStr = textStr.replace(substring,substitute);
            System.out.println(textStr);
        } else {
            System.out.println("Nothing to replace!");
        }
        text = new StringBuilder(textStr);
        return text;
    }

    private static StringBuilder cut(StringBuilder text, int index, int length) {
        text.replace(index,index+length,"");
        return text;
    }


    private static StringBuilder takeOdd(StringBuilder text) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < text.length(); i= i+2) {
            sb.append(text.charAt(i));
        }
        return sb;
    }
}
