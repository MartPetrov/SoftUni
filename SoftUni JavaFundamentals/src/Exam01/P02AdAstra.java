package Exam01;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        Pattern patternFood = Pattern.compile("([|#])(?<product>[A-Za-z ]+)(\\1)(?<date>[0-9]{2}/[0-9]{2}/[0-9]{2})(\\1)(?<calories>([1-9][0-9]{0,3})|10000)(\\1)");
        Matcher matcher = patternFood.matcher(text);

        int sumOfCall = 0;
        List<String> productList = new ArrayList<>();
        List<String> date = new ArrayList<>();
        List<String> calories = new ArrayList<>();
        while (matcher.find()){
            productList.add(matcher.group("product"));
            date.add(matcher.group("date"));
            calories.add(matcher.group("calories"));
            sumOfCall += Integer.parseInt(matcher.group("calories"));
        }
        int days = sumOfCall / 2000;
        System.out.printf("You have food to last you for: %d days!%n", days);
        for (int i = 0; i < productList.size(); i++) {
            System.out.printf("Item: %s, Best before: %s, Nutrition: %s%n", productList.get(i),date.get(i),calories.get(i));
        }

    }
}
