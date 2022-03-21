package P31RegularExpressionsExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P01Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<String> furnitureList = new ArrayList<>();
        String regex = ">>(?<furnitureName>\\w+)<<(?<price>\\d+.?\\d*)!(?<quantity>\\d+)";

        double totalSum = 0;
        Pattern pattern = Pattern.compile(regex);

        while (!input.equals("Purchase")) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                furnitureList.add(matcher.group("furnitureName"));
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));

                totalSum += price * quantity;
            }


            input = scanner.nextLine();
        }

        System.out.printf("Bought furniture:%n");
        for (String s : furnitureList) {
            System.out.println(s);
        }
        System.out.printf("Total money spend: %.2f",totalSum);
    }
}
