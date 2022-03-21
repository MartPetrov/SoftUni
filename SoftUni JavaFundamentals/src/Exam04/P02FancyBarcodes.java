package Exam04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfLine =  Integer.parseInt(scanner.nextLine());

        Pattern patternForProduct = Pattern.compile("(@[#]+)(?<product>[A-Z][A-Za-z0-9]{4,}[A-Z])(@[#]+)");

        for (int i = 0; i < numberOfLine; i++) {
            String product = scanner.nextLine();
            Matcher matcherForProduct = patternForProduct.matcher(product);
            StringBuilder groupNum = new StringBuilder();
            if (matcherForProduct.find()){
                String current = matcherForProduct.group("product");
                for (int j = 0; j < current.length(); j++) {
                    char charAtIndex = current.charAt(j);
                    if (Character.isDigit(charAtIndex)){
                        groupNum.append(charAtIndex);
                    }
                }
            } else {
                System.out.printf("Invalid barcode%n");
                continue;
            }
            if (groupNum.length() == 0) {
                System.out.println("Product group: 00");
            } else {
                System.out.printf("Product group: %s%n", groupNum);
            }
        }
    }
}
