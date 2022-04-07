package P09ExerciseDataTypesAndVariables;

import java.util.Scanner;

public class P04SumOfChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int countChars = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        for (int i = 1; i <= countChars; i++) {
            char characters = scanner.nextLine().charAt(0);
            sum += (int) characters;
        }
        System.out.printf("The sum equals: %d", sum);
    }
}
