package P09ExerciseDataTypesAndVariables;

import java.util.Scanner;

public class P02SumDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        int sumDigit = 0;

       while (num != 0){
            int digit = num % 10;
            sumDigit += digit;
           num = num / 10;
        }
        System.out.println(sumDigit);
    }
}
