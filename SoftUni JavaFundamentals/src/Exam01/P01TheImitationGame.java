package Exam01;

import java.util.Scanner;

public class P01TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String encryptedMessage = scanner.nextLine();
        String input = scanner.nextLine();

        while (!input.equals("Decode")) {
            String command = input.split("\\|")[0];
            StringBuilder sb = new StringBuilder(encryptedMessage);
            switch (command) {
                case "Move":
                    int numLetter = Integer.parseInt(input.split("\\|")[1]);
                    String substring = sb.substring(0,numLetter);
                    sb.delete(0,numLetter);
                    sb.append(substring);
                    encryptedMessage = sb.toString();
                    break;
                case "Insert":
                    int indexToInsert = Integer.parseInt(input.split("\\|")[1]);
                    String toInsert = input.split("\\|")[2];
                    sb.insert(indexToInsert,toInsert);
                    encryptedMessage = sb.toString();
                    break;
                case "ChangeAll":
                    String sub = input.split("\\|")[1];
                    String replacement = input.split("\\|")[2];
                    for (int i = 0; i < encryptedMessage.length(); i++) {
                        if (encryptedMessage.contains(sub)){
                            int indexToReplace = encryptedMessage.indexOf(sub);
                            sb.deleteCharAt(indexToReplace);
                            sb.insert(indexToReplace,replacement);
                            encryptedMessage = sb.toString();
                        }
                    }
                    break;
            }

            input = scanner.nextLine();
        }

        System.out.printf("The decrypted message is: %s",encryptedMessage);
    }
}
