package P09ExerciseDataTypesAndVariables;

import java.util.Scanner;

public class P09MoreSpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startFirstDay = Integer.parseInt(scanner.nextLine());
        int resoursesForNextDay = startFirstDay;
        int resoursesForWorkers = startFirstDay;
        int countResourse = 0;
        int countDays = 0;
        while (resoursesForNextDay >= 100) {
            countDays++;
            if (resoursesForWorkers >= 26) {
                resoursesForWorkers = resoursesForNextDay - 26;
            }
            countResourse += resoursesForWorkers;
            resoursesForNextDay -= 10;
        }
        countResourse -= 26;
        if (countResourse < 0) {
            countResourse = 0;
        }
        System.out.println(countDays);
        System.out.println(countResourse);
    }
}




