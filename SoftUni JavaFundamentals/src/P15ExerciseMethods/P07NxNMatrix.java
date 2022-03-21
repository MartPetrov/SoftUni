package P15ExerciseMethods;

import java.util.Scanner;

public class P07NxNMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        matrix(n);
    }

    public static void matrix(int n) {
        for (int line = 1; line <= n; line++) {

            for (int i = 1; i <= n; i++) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
}
