package com.PrepForExam;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        Pattern pattern = Pattern.compile("([#|])(?<product>[A-Za-z\\s]+)\\1(?<date>[0-9]{2}/[0-9]{2}/[0-9]{2})\\1(?<calories>[1-9][0-9]{0,3}|10000)\\1");
        Matcher matcher = pattern.matcher(text);
        int sumOfCalories = 0;
        List<Product> productList = new LinkedList<>();
        while (matcher.find()) {
            Product product = new Product(matcher.group("product"), matcher.group("date"), Integer.parseInt(matcher.group("calories")));
            productList.add(product);
            sumOfCalories += Integer.parseInt(matcher.group("calories"));
        }
        System.out.printf("You have food to last you for: %d days!%n", sumOfCalories / 2000);
        for (Product product : productList) {
            System.out.println(product);
        }

    }

    public static class Product {
        String name;
        String date;
        int calorie;

        public Product(String name, String date, int calorie) {
            this.name = name;
            this.date = date;
            this.calorie = calorie;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public int getCalorie() {
            return calorie;
        }

        public void setCalorie(int calorie) {
            this.calorie = calorie;
        }

        @Override
        public String toString() {
            return String.format("Item: %s, Best before: %s, Nutrition: %d",getName(),getDate(),getCalorie());
        }
    }
}
