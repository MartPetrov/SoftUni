package L03MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class P06PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sizeOfMatrix = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[sizeOfMatrix][sizeOfMatrix];

        for (int row = 0; row < sizeOfMatrix; row++) {
            int[] rowData = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            matrix[row] = rowData;
        }
        firstDiagonal(sizeOfMatrix, matrix);
        System.out.println();

        secondDiagonal(sizeOfMatrix, matrix);

    }

    private static void firstDiagonal(int n, int[][] matrix) {
        for (int i = 0; i < n; i++) {
            System.out.print(matrix[i][i] + " ");
        }
    }

    private static void secondDiagonal(int n, int[][] matrix) {
        int row = n - 1;
        int col = 0;
        while (isInBounds(row, col, matrix)) {
            System.out.print(matrix[row][col] + " ");
            row--;
            col++;
        }
    }

    private static boolean isInBounds(int row, int col, int[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static boolean isOutBounds(int row, int col, int[][] matrix) {
        return !isInBounds(row, col, matrix);
    }
}
