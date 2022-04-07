package P09ExerciseDataTypesAndVariables;

import java.util.Scanner;

public class P11MoreSnowballs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        double maxVolume = Double.MIN_VALUE;
        int maxSnowBall = 0;
        int snowballSnowMax = 0;
        int snowballTimeMax = 0;
        int snowballQualityMax = 0;
        for (int i = 0; i < n; i++) {

            int snowballSnow = Integer.parseInt(scanner.nextLine());
            int snowballTime = Integer.parseInt(scanner.nextLine());
            int snowballQuality = Integer.parseInt(scanner.nextLine());

            double volumeCurrent = Math.pow((double) (snowballSnow / snowballTime), snowballQuality);
            // (snowballSnow / snowballTime) ^ snowballQuality

            if (volumeCurrent > maxVolume) {
                maxVolume = volumeCurrent;
                maxSnowBall = i;
                snowballSnowMax = snowballSnow;
                snowballTimeMax = snowballTime;
                snowballQualityMax=snowballQuality;
            }
        }
        System.out.printf("%d : %d = %.0f (%d)", snowballSnowMax, snowballTimeMax, maxVolume, snowballQualityMax);

    }
}
