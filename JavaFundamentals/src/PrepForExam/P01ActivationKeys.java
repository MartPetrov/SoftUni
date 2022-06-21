package com.PrepForExam;

import java.util.Scanner;

public class P01ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();
        String command = scanner.nextLine();

        while (!command.equals("Generate")) {
            String[] commandArr = command.split(">>>");
            switch (commandArr[0]) {
                case "Contains":
                    String substring = commandArr[1];
                    if (message.contains(substring)) {
                        System.out.printf("%s contains %s%n", message, substring);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    String type = commandArr[1];
                    int startIndex = Integer.parseInt(commandArr[2]);
                    int endIndex = Integer.parseInt(commandArr[3]);
                    String subStringFromTo = message.substring(startIndex,endIndex);
                    if (type.equals("Upper")) {
                        message = message.replace(subStringFromTo,subStringFromTo.toUpperCase());
                    } else if (type.equals("Lower")) {
                        message = message.replace(subStringFromTo,subStringFromTo.toLowerCase());
                    }
                    System.out.println(message);
                    break;
                case "Slice":
                    int startIndexToDelete = Integer.parseInt(commandArr[1]);
                    int endIndexToDelete = Integer.parseInt(commandArr[2]);
                    String subStringFromToToDelete = message.substring(startIndexToDelete,endIndexToDelete);
                    message = message.replace(subStringFromToToDelete,"");
                    System.out.println(message);
                    break;

            }
            command = scanner.nextLine();
        }
        System.out.printf("Your activation key is: %s", message);
    }
}
