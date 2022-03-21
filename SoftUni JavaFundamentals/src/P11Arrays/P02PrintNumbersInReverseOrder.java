package P11Arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P02PrintNumbersInReverseOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Integer[] numbers = new Integer[n];
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            numbers[i] = number;
        }
        Arrays.sort(numbers);
//            System.out.print(Arrays.toString(numbers));

//        for(int i = 0; i < numbers.length / 2; i++)
//        {
//            int temp = numbers[i];
//            numbers[i] = numbers[numbers.length - i - 1];
//            numbers[numbers.length - i - 1] = temp;
//        }
        System.out.println(Arrays.toString(numbers).replaceAll("[\\[\\],]", ""));
    }
}
