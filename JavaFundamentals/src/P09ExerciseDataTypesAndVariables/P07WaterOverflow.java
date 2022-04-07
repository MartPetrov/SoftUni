package P09ExerciseDataTypesAndVariables;

import java.util.Scanner;

public class P07WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int tank = 0;
        for (int i = 0; i < n; i++) {
            int load = Integer.parseInt(scanner.nextLine());
            if (tank + load > 255) {
                System.out.printf("Insufficient capacity!%n");
                continue;
            }
            tank += load;
        }
        System.out.println(tank);
    }
}
