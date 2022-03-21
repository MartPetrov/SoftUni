package P33ExamPrepare;

import java.util.Scanner;

public class P01SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String secretMessage = scanner.nextLine();
        String commandFirst = scanner.nextLine();
        while (!commandFirst.equals("Reveal")) {
            String[] command = commandFirst.split(":\\|:");
            switch (command[0]) {
                case "InsertSpace":
                    int indexToInsert = Integer.parseInt(command[1]);
                    secretMessage = secretMessage.substring(0, indexToInsert).concat(" ").concat(secretMessage.substring(indexToInsert));
                    System.out.println(secretMessage);
                    break;
                case "Reverse":
                    String subString = command[1];
                    StringBuilder forReplays = new StringBuilder(subString);
                    if (secretMessage.contains(subString)) {
                        subString = forReplays.reverse().toString();
                        int startIndex = secretMessage.indexOf(command[1]);
                        int endIndex = startIndex + command[1].length();

                        StringBuilder updateString = new StringBuilder(secretMessage);
                        updateString.delete(startIndex, endIndex);
                        secretMessage = updateString.append(subString).toString();
                        System.out.println(secretMessage);
                    } else {
                        System.out.println("error");
                    }

                    break;
                case "ChangeAll":
                    String substring = command[1];
                    String replacement = command[2];
                    secretMessage = secretMessage.replace(substring, replacement);
                    System.out.println(secretMessage);
                    break;
            }
            commandFirst = scanner.nextLine();
        }
        System.out.println("You have a new text message: " + secretMessage);
    }
}