package P33ExamPrepare;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        Pattern pattern = Pattern.compile("(?<surr>[#|])(?<food>[A-Za-z ]+)(\\1)(?<date>[0-9]{2}/[0-9]{2}/[0-9]{2})(\\1)(?<calories>[0-9]+)(\\1)");

        Matcher matcher = pattern.matcher(text);
        int sumCal = 0;
        List<String> food = new ArrayList<>();
        List<String> date = new ArrayList<>();
        List<String> cal = new ArrayList<>();

        while (matcher.find()){
            sumCal += Integer.parseInt(matcher.group("calories"));
            food.add(matcher.group("food"));
            date.add(matcher.group("date"));
            cal.add(matcher.group("calories"));
        }
        int days = sumCal / 2000;
        System.out.printf("You have food to last you for: %d days!%n", days);


        for (int i = 0; i < food.size(); i++) {
            System.out.printf("Item: %s, Best before: %s, Nutrition: %s%n", food.get(i),date.get(i),cal.get(i));
        }

    }
}
