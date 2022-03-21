package P11Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class P06EqualArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] firstArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] secondArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        printIfNotIdentical(firstArr, secondArr);

        System.out.printf("Arrays are identical. Sum: %d", Arrays.stream(firstArr).sum());
    }


    public static void printIfNotIdentical(int[] firstArr, int[] secondArr) {
        for (int i = 0; i < firstArr.length; i++) {
            int currentNumberFirst = firstArr[i];
            int currentNumberSecond = secondArr[i];

            if (currentNumberFirst != currentNumberSecond) {
                System.out.printf("Arrays are not identical. Found difference at %d index.", i);
                return;
            }
        }
    }
}
