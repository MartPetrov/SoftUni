package P11Arrays;

import java.util.Scanner;

public class P01DayOfWeek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        if (number <= 0 || number > 7) {
            System.out.print("Invalid day!");
            return;
        }
        String[] daysOfWeek = new String[] {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
//        int[] myIntArray = new int[]{1, 2, 3};

        System.out.println(daysOfWeek[number - 1]);
    }
}
