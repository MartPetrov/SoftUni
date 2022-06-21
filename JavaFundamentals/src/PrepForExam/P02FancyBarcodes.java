package com.PrepForExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n =  Integer.parseInt(scanner.nextLine());

        for (int i = 0; i <n ; i++) {
            String text = scanner.nextLine();
            Pattern pattern = Pattern.compile("(@#+)(?<product>[A-Z][A-Za-z0-9]{4,}[A-Z])(@#+)");
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()) {
                String group = "";
                group = group(matcher.group("product"));
                System.out.printf("Product group: %s%n",group);
            } else {
                System.out.printf("Invalid barcode%n");
            }
        }
    }

    private static String group(String product) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < product.length(); i++) {
            if (Character.isDigit(product.charAt(i))){
                sb.append(product.charAt(i));
            }
        }
        if (sb.length() ==0) {
            sb.append("00");
        }
        return sb.toString();
    }
}
