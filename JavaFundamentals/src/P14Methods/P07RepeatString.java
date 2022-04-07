package P14Methods;

import java.util.Scanner;

public class P07RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        int n = Integer.parseInt(scanner.nextLine());

        System.out.println(repeatString(text, n));
    }
    public static String repeatString(String textToRepeat, int n) {
        String result = "";
        for (int i = 1; i <= n; i++) {
            result += textToRepeat;
        }
    return result;
    }
}
