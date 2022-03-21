package P28TextProcessingExercise;

import java.util.Scanner;

public class P01ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] usernames = input.split(", ");

        for (String username : usernames) {

           if (isValidUsername(username)) {
               System.out.println(username);
           }
        }
    }

    private static boolean isValidUsername(String username) {
        if (username.length() < 3 || username.length() > 16) {
            return false;
        }
        for (char symbol : username.toCharArray()) {
            if (!(symbol == '-' || symbol == '_' || Character.isLetterOrDigit(symbol))) {
                return false;
            }
        }
        return true;
    }
}
