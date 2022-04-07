package P08DataTypesAndVariables;

import java.util.Scanner;

public class P12RefactorSpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());
        int number = 0;
        int sum = 0;
        int numberSec = 0;
        boolean flag = false;
        for (int i = 1; i <= n; i++) {
                number = i % 10;
                numberSec = i / 10;
                sum = number + numberSec;
            if ((sum == 5) || (sum == 7) || (sum == 11)){
            System.out.printf("%d -> True%n", i);
            } else {
                System.out.printf("%d -> False%n", i);
            }

        }

    }
}
