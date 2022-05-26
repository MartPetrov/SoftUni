package L03MultidimensionalArrays;

import java.util.Scanner;

public class P02PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rowsCols = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(rowsCols[0]);
        int cols = Integer.parseInt(rowsCols[1]);
        int[][] matrix = new int[rows][cols];


        for (int row = 0; row <rows ; row++) {
            String[] rowData = scanner.nextLine().split(" ");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Integer.parseInt(rowData[col]);
            }
        }
        int number =  Integer.parseInt(scanner.nextLine());
        boolean weFoundIt = false;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == number) {
                    System.out.printf("%d %d%n", row,col);
                    weFoundIt=true;
                }
            }
        }
        if (!weFoundIt) {
            System.out.println("not found");
        }
    }
}
