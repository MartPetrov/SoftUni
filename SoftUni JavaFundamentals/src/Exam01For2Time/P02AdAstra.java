package Exam01For2Time;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        Pattern pattern = Pattern.compile("([#|])(?<product>[A-Za-z\\s+]+)\\1(?<date>[0-9]{2}\\/[0-9]{2}\\/[0-9]{2})\\1(?<calories>[1-9][0-9]{0,3}|10000)\\1");
        Matcher matcher = pattern.matcher(text);
        List<Food> listFood = new LinkedList<>();
        int sumOfCalories = 0;
        while (matcher.find()) {
            Food food = new Food(matcher.group("product"), matcher.group("date"),Integer.parseInt(matcher.group("calories")));
            listFood.add(food);
            sumOfCalories += Integer.parseInt(matcher.group("calories"));
        }
        System.out.printf("You have food to last you for: %d days!%n", sumOfCalories/2000);
        for (Food food:listFood) {
            System.out.println(food);
        }

    }
    public static class Food {
        String productName;
        String date;
        int calories;

        public Food(String productName, String date, int calories) {
            this.productName = productName;
            this.date = date;
            this.calories = calories;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public int getCalories() {
            return calories;
        }

        public void setCalories(int calories) {
            this.calories = calories;
        }

        @Override
        public String toString() {
            return String.format("Item: %s, Best before: %s, Nutrition: %d", getProductName(), getDate(),getCalories());
        }
    }
}
