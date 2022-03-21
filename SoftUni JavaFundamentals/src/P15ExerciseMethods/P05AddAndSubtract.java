package P15ExerciseMethods;

import java.util.Scanner;

public class P05AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        int thirdNum = Integer.parseInt(scanner.nextLine());
        int sum = sum(firstNum, secondNum, thirdNum);
        System.out.println(sum);
    }
    public static int sum(int first, int second, int third) {
        int sum = first + second - third;
        return sum;
    }
}
