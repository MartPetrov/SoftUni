package P08DataTypesAndVariables;

import java.util.Scanner;

public class P06CharsToString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       String string1 = scanner.nextLine();
       String string2 = scanner.nextLine();
       String string3 = scanner.nextLine();

       char char1 = string1.charAt(0);
       char char2 = string2.charAt(0);
       char char3 = string3.charAt(0);

        System.out.println("" + char1 + char2 + char3);
    }
}
