package P15ExerciseMethods;

import java.util.Scanner;

public class P08FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber =  Integer.parseInt(scanner.nextLine());
        int secondNumber =  Integer.parseInt(scanner.nextLine());

        double factorialFirst = factorial(firstNumber);
        double factorialSecond = factorial(secondNumber);

        double result = factorialFirst * 1.0 / factorialSecond;
        System.out.printf("%.2f", result);
    }

    public static double factorial (int number) {
        double factorial = 1;
        for (int index = 1; index <= number ; index++) {
            factorial *= index;
        }
        return factorial;
    }
}
