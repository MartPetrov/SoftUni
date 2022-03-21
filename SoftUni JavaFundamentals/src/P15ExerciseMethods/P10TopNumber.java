package P15ExerciseMethods;

import java.util.Scanner;

public class P10TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int number = 1; number <= n; number++) {
            if (isSumDigitDivisible(number) && holdsOddDigit(number)) {
                System.out.println(number);
            }

        }
    }
    // сумата от цифрите се дели на 8
    public static boolean isSumDigitDivisible(int number) {
        int sum = 0;
        while (number > 0) {
            int lastDigit = number % 10;
            sum += lastDigit;
            number /= 10;

        }
        return sum % 8 == 0;
    }
    public static boolean holdsOddDigit (int number ) {
        while (number > 0) {
            int lastDigit = number % 10;
            if (lastDigit % 2 == 1) {
                return true;
            }
            number /= 10;
        }
        return  false;
    }
}
