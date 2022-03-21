package P14Methods;

import java.util.Arrays;
import java.util.Scanner;

public class P10MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Math.abs(Integer.parseInt(scanner.nextLine()));
        System.out.println(multipleOfEvenAndOddSum(num));
    }

    public static int multipleOfEvenAndOddSum (int num) {
        int evenSum = evenSum(num);
        int oddSum = oddSum(num);
        return evenSum * oddSum;
    }

    public static int evenSum(int num) {
        int evenSum = 0;
        String intToString = Integer.toString(num);
        int[] arr = Arrays.stream(intToString.split(""))
                .mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                evenSum += arr[i];
            }
        }
        return evenSum;
    }

    public static int oddSum(int num) {
        int oddSum = 0;
        String intToString = Integer.toString(num);
        int[] arr = Arrays.stream(intToString.split(""))
                .mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                oddSum += arr[i];
            }
        }
        return oddSum;
    }

}
