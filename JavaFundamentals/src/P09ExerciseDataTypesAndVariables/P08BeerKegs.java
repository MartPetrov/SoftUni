package P09ExerciseDataTypesAndVariables;

import java.util.Scanner;

public class P08BeerKegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        double volumeMax = Double.MIN_NORMAL;
        String modelMax = "";

        for (int i = 1; i <= n; i++) {
            String model = scanner.nextLine();
            double radius = Double.parseDouble(scanner.nextLine());
            int height = Integer.parseInt(scanner.nextLine());

            double volumeCurrent = Math.PI * Math.pow(radius, 2) * height;

            if (volumeCurrent > volumeMax) {
                volumeMax = volumeCurrent;
                modelMax = model;
            }

        }
        System.out.printf("%s", modelMax);

    }
}
