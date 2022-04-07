package P12ExerciseArrays;

import java.util.Arrays;
import java.util.Scanner;

public class P02CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstArr = scanner.nextLine().split(" ");
        String[] secondArr = scanner.nextLine().split(" ");

        for (String secondElements : secondArr) {
            for (String firstElements : firstArr) {
                if (secondElements.equals(firstElements)) {
                    System.out.print(firstElements + " ");
                }
            }
        }
    }
}

