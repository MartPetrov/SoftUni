package ExamPrep.P02;

import java.util.Scanner;

public class P02Armory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sizeOfMatrix =  Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[sizeOfMatrix][sizeOfMatrix];

        for (int row = 0; row < matrix.length; row++) {
            String[] inputFillMatrix = scanner.nextLine().split("");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = inputFillMatrix[col];
            }
        }

    }
}
