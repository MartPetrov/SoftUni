package P33ExamPrepare;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02FancyBarcodes2Times {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numLines = Integer.parseInt(scanner.nextLine());
        Pattern pattern = Pattern.compile("@#+[A-Z][A-Za-z0-9]{4,}[A-Z]@#+");
        Matcher matcher = null;

        for (int i = 0; i < numLines; i++) {
            String text = scanner.nextLine();
            matcher = pattern.matcher(text);

            if (matcher.find()) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < text.length(); j++) {
                    char symbol = text.charAt(j);
                    if (Character.isDigit(symbol)) {
                        sb.append(symbol);
                    }
                }
                if (sb.length() == 0) {
                    System.out.println("Product group: 00");
                } else {
                    System.out.println("Product group: " + sb);
                }
            } else {
                System.out.println("Invalid barcode");
            }
        }
    }
}


