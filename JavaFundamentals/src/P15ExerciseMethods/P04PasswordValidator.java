package P15ExerciseMethods;

import java.util.Scanner;

public class P04PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();

        boolean isValidPassLength = isValidLength(password);
        if (!isValidPassLength) {
            System.out.println("Password must be between 6 and 10 characters");
        }
        boolean isValidPassContent = isValidContent(password);
        if (!isValidPassContent) {
            System.out.println("Password must consist only of letters and digits");
        }
        boolean isValidPassDigit = isValidDigit(password);
        if (!isValidPassDigit) {
            System.out.println("Password must have at least 2 digits");
        }

        if (isValidPassContent && isValidPassDigit && isValidPassLength) {
            System.out.println("Password is valid");
        }
    }

    public static boolean isValidLength(String password) {
        return password.length() >= 6 && password.length() <= 10;
    }

    public static boolean isValidContent(String password) {
        for (char symbol : password.toCharArray()) {
            if (!Character.isLetterOrDigit(symbol)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidDigit(String password) {
        int count = 0;
        for (char symbol : password.toCharArray()) {
            if (Character.isDigit(symbol)) {
                count++;
            }
        }
        return count >= 2;
    }
}
