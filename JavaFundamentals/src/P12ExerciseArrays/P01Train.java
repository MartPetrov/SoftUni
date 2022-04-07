package P12ExerciseArrays;

import java.util.Arrays;
import java.util.Scanner;

public class P01Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int wagons = Integer.parseInt(scanner.nextLine());

        int[] train = new int[wagons];
        for (int i = 0; i < wagons; i++) {
            train[i] = Integer.parseInt(scanner.nextLine());
            System.out.print(train[i] + " ");
        }
        int sum = Arrays.stream(train).sum();
        System.out.println();
        System.out.println(sum);
    }
}
