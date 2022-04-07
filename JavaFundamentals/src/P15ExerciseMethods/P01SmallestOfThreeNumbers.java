package P15ExerciseMethods;

import java.util.Scanner;

public class P01SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber =  Integer.parseInt(scanner.nextLine());
        int secondNumber =  Integer.parseInt(scanner.nextLine());
        int thirdNumber =  Integer.parseInt(scanner.nextLine());
        int smalestNumber = getSmalestNumber(firstNumber, secondNumber, thirdNumber);
        System.out.println(smalestNumber);
    }

    public static int getSmalestNumber (int number1, int number2, int number3) {
        if (number1 <=  number2 && number1 <= number3) {
           return number1;

        } else if (number2 <=  number1 && number2 <= number3) {
            return number2;
        } else {
           return number3;
        }
    }
    public static void printSmalest (int smalestNum) {
        System.out.println(smalestNum);
    }
}
