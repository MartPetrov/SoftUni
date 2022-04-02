package Exam01For2Time;

import java.util.Scanner;

public class P01TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        StringBuilder encrypted = new StringBuilder(scanner.nextLine());
        String[] inputCommand = scanner.nextLine().split("\\|");
        while (!inputCommand[0].equals("Decode")) {
            switch (inputCommand[0]) {
                case "Move":
                    int numLetter = Integer.parseInt(inputCommand[1]);
                    move(encrypted,numLetter);
                    break;
                case "Insert":
                    int indexToInsert = Integer.parseInt(inputCommand[1]);
                    String toInsert = inputCommand[2];
                    insert (encrypted,indexToInsert,toInsert);
                    break;
                case "ChangeAll":
                    String substring = inputCommand[1];
                    String replacement = inputCommand[2];
                    encrypted = new StringBuilder(encrypted.toString().replace(substring,replacement));
                    break;
            }
            inputCommand = scanner.nextLine().split("\\|");
        }
        System.out.printf("The decrypted message is: %s", encrypted.toString());
    }


    private static void insert(StringBuilder encrypted, int indexToInsert, String toInsert) {
        encrypted.insert(indexToInsert,toInsert);
    }

    private static void move(StringBuilder encrypted, int numLetter) {
        for (int i = 0; i < numLetter; i++) {
            char current = encrypted.charAt(0);
            encrypted.deleteCharAt(0);
            encrypted.append(current);
        }
    }
}
