package com.PrepForExam;

import java.util.Scanner;

public class P01TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder encrypted = new StringBuilder(scanner.nextLine());
        String[] commandArr = scanner.nextLine().split("\\|");
        while (!commandArr[0].equals("Decode")) {
            switch (commandArr[0]) {
                case "Move":
                    int numLetters = Integer.parseInt(commandArr[1]);
                    move (encrypted,numLetters);
                    break;
                case "Insert":
                    int indexToInsert = Integer.parseInt(commandArr[1]);
                    String valueToInsert = commandArr[2];
                    insert (encrypted,indexToInsert,valueToInsert);
                    break;
                case "ChangeAll":
                    String substring = commandArr[1];
                    String replacement = commandArr[2];
                    encrypted = changeAll (encrypted,substring,replacement);
                    break;
            }

            commandArr = scanner.nextLine().split("\\|");
        }
        System.out.printf("The decrypted message is: %s",encrypted.toString());
    }

    private static StringBuilder changeAll(StringBuilder encrypted, String substring, String replacement) {
       encrypted=  new StringBuilder(encrypted.toString().replace(substring,replacement));
       return encrypted;
    }

    private static void insert(StringBuilder encrypted, int indexToInsert, String valueToInsert) {
        encrypted.insert(indexToInsert,valueToInsert);
    }

    private static void move(StringBuilder encrypted, int numLetters) {
        String substring = encrypted.substring(0, numLetters);
        encrypted.replace(0,numLetters,"");
        encrypted.append(substring);

    }
}
