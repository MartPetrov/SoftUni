package P08DataTypesAndVariables;

import java.util.Scanner;

public class P10SpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <=n ; i++) {
            int digit = 0;
            int first = i % 10;
            int second = i / 10;
            digit = first + second;

            if (digit == 5 || digit == 7 || digit == 11){

                System.out.printf("%d -> True%n", i);
            } else {
                System.out.printf("%d -> False%n", i);
            }
        }
    }
}
