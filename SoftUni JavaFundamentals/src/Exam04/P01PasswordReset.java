package Exam04;

import java.util.Scanner;

public class P01PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String commandLine = scanner.nextLine();

        while (!commandLine.equals("Done")) {
            String[] command = commandLine.split(" ");
            StringBuilder sb = new StringBuilder();
            switch (command[0]) {
                case "TakeOdd":
                    for (int i = 0; i < text.length(); i++) {
                       if (i % 2 != 0) {
                           sb.append(text.charAt(i));
                       }
                    }
                    text = sb.toString();
                    System.out.println(text);
                    break;
                case "Cut":
                    int indexToCut = Integer.parseInt(command[1]);
                    int length = Integer.parseInt(command[2]);
                    StringBuilder forCut = new StringBuilder(text);
                    forCut.delete(indexToCut, indexToCut + length);
                    text = forCut.toString();
                    System.out.println(text);
                    break;
                case "Substitute":
                    String substring = command[1];
                    String substitute = command[2];
                    StringBuilder substituteSb = new StringBuilder(text);
                    int indexOfLength = substring.length();
                    if (substituteSb.toString().contains(substring)) {
                        while (substituteSb.toString().contains(substring)) {
                            int indexTosub = Integer.parseInt(String.valueOf(substituteSb.indexOf(substring)));
                            substituteSb.delete(indexTosub, indexTosub + indexOfLength);
                            substituteSb.insert(indexTosub, substitute);
                        }
                        text= substituteSb.toString();
                        System.out.println(text);
                    } else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }

            commandLine = scanner.nextLine();
        }
        System.out.printf("Your password is: %s", text);
    }
}
