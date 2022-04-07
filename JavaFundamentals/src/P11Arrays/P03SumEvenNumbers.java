package P11Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class P03SumEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int sum1 = Arrays.stream(numbers).filter(e -> e % 2 == 0).sum();

//        for (int i = 0; i < numbers.length; i++) {
//            int number = numbers[i];
//            if (number % 2 ==0) {
//                sum+=number;
//            }
//        }
        System.out.println(sum1);
    }
}
