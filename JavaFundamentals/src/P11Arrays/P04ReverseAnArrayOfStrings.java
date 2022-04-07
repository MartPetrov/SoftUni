package P11Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class P04ReverseAnArrayOfStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split( " ");
        int j = 0;

        String[] reverse = new String[input.length];

        for (int i = input.length - 1; i >= 0  ; i--) {
            String current = input [i];
            reverse[j] = current;
            j++;
        }
        System.out.println(Arrays.toString(reverse).replaceAll("[\\[\\],]", ""));
    }
}
