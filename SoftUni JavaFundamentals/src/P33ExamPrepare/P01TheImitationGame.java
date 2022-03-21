package P33ExamPrepare;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P01TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder encryptedText = new StringBuilder(scanner.nextLine());
        String command = scanner.nextLine();

        while (!command.equals("Decode")) {
            List<String> commandList = Arrays.asList(command.split("\\|"));
            switch (commandList.get(0)) {
                case "Move":
                    int numLetters = Integer.parseInt(commandList.get(1));
                    String textToAppend = encryptedText.substring(0,numLetters);
                        encryptedText.replace(0,numLetters,"");
                        encryptedText.append(textToAppend);
                    break;
                case "Insert":
                    int indexToInsert = Integer.parseInt(commandList.get(1));
                    String textToInsert = commandList.get(2);
                    encryptedText.insert(indexToInsert,textToInsert);
                    break;
                case "ChangeAll":
                    String subToChange = commandList.get(1);
                    String subToReplace = commandList.get(2);
                    for (int i = 0; i < encryptedText.length(); i++) {
                        if (encryptedText.toString().contains(subToChange)) {
                            int indexOfChar = encryptedText.indexOf(subToChange);
                            encryptedText.deleteCharAt(indexOfChar);
                            encryptedText.insert(indexOfChar,subToReplace);
                        }
                    }
                    break;
            }

            command = scanner.nextLine();
        }
        System.out.println("The decrypted message is: " +encryptedText);
    }
}
