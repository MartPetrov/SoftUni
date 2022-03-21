package P33ExamPrepare;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String activationKey = scanner.nextLine();
        String inputLine = scanner.nextLine();

        while (!inputLine.equals("Generate")) {
            String[] commandArr = inputLine.split(">>>");
            String command = commandArr[0];
            switch (command) {
                case "Contains":
                    String substring = commandArr[1];
                    if (activationKey.contains(substring)) {
                        System.out.printf("%s contains %s%n", activationKey, substring);
                    } else {
                        System.out.printf("Substring not found!%n");
                    }
                    break;
                case "Flip":
                    String criteria = commandArr[1];
                    int startIndex = Integer.parseInt(commandArr[2]);
                    int endIndex = Integer.parseInt(commandArr[3]);
                    String substringToReplace = activationKey.substring(startIndex,endIndex);
                    if (criteria.equals("Upper")) {
                        activationKey = activationKey.replace(substringToReplace, substringToReplace.toUpperCase());
                        System.out.println(activationKey);
                    } else {
                        activationKey = activationKey.replace(substringToReplace, substringToReplace.toLowerCase());
                        System.out.println(activationKey);
                    }
                    break;
                case "Slice":
                    int startInd = Integer.parseInt(commandArr[1]);
                    int endInd = Integer.parseInt(commandArr[2]);
                    String substringToRemove = activationKey.substring(startInd,endInd);
                    activationKey = activationKey.replace(substringToRemove,"");
                    System.out.println(activationKey);
                    break;
            }

            inputLine = scanner.nextLine();
        }
        System.out.printf("Your activation key is: %s", activationKey);
    }
}
