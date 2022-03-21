package P11Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class P07CondenseArrayToNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

      int [] numbers = Arrays.stream(scanner.nextLine().split(" "))
                      .mapToInt(Integer::parseInt).toArray();
      int counter = numbers.length;

      while (counter > 1) {
          for (int i = 0; i < numbers.length - 1 ; i++) {
              numbers[i] = numbers[i] + numbers[i + 1];
          }
          counter--;
      }

        System.out.println(numbers[0]);
    }
}
