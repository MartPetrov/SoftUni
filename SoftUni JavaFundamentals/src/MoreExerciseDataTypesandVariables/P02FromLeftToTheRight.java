package MoreExerciseDataTypesandVariables;

import java.util.Scanner;

public class P02FromLeftToTheRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

//        int digit1 = 0;
//        int digit2 = 0;
        //    int sum1 = 0;
        //    int sum2 = 0;

        for (int i = 1; i <= n; i++) {
            long sum = 0;
            long num = 0;
            long firstNum = scanner.nextLong();
            long secondNum = scanner.nextLong();

            //       for (int j = 1; j <= n; j++) {
            if (secondNum > firstNum) {
                num = Math.abs(secondNum);
            } else {
                num = Math.abs(firstNum);
            }

            while (num != 0) {
                long    digit1 = num % 10;
                num /= 10;
                sum += digit1;
            }
            System.out.println(sum);
//            while (secondNum != 0) {
//                digit2 = secondNum % 10;
//                secondNum /= 10;
//                sum2 += digit2;
//            }

//                if (sum1 > sum2) {
//                    System.out.println(sum1);
//                    sum1 = 0;
//                    sum2 = 0;
//                } else {
//                    System.out.println(sum2);
//                    sum1 = 0;
//                    sum2 = 0;
//                }
//            firstNum = scanner.nextDouble();
//            secondNum = scanner.nextDouble();
        }
    }

}
