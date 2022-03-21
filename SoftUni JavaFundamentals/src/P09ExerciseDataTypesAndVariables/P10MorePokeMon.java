package P09ExerciseDataTypesAndVariables;

import java.util.Scanner;

public class P10MorePokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int power = Integer.parseInt(scanner.nextLine());
        int range = Integer.parseInt(scanner.nextLine());
        int exhaustionFactor = Integer.parseInt(scanner.nextLine());

        int pokeCount =0;
        int firstPower = power;

        while (true) {
            if (power >= range) {
                power -= range;
                pokeCount++;
            } else {
                break;
            }

            if (power ==  0.5 * firstPower) {
                if (exhaustionFactor != 0) {
                    power /= exhaustionFactor;
                }
            }
        }
        System.out.println(power);
        System.out.println(pokeCount);
    }
}
