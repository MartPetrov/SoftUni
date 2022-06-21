package L01WorkingWithAbstraction.P05JediGalaxy_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        int currentElement = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = currentElement++;
            }
        }

        String command = scanner.nextLine();
        long sum = 0;
        while (!command.equals("Let the Force be with you")) {
            int[] playersCoordinate = Arrays.stream(command.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int[] evilsCoordinate = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int rowEvils = evilsCoordinate[0];
            int colEvils = evilsCoordinate[1];

            moveEvil(matrix, rowEvils, colEvils);

            int rowPlayer = playersCoordinate[0];
            int colPlayer = playersCoordinate[1];

            sum = movePlayer(matrix, sum, rowPlayer, colPlayer);

            command = scanner.nextLine();
        }
        System.out.println(sum);

    }

    private static long movePlayer(int[][] matrix, long sum, int rowPlayer, int colPlayer) {
        while (rowPlayer >= 0 && colPlayer < matrix[1].length) {
            if (rowPlayer < matrix.length && colPlayer >= 0 && colPlayer < matrix[0].length) {
                sum += matrix[rowPlayer][colPlayer];
            }

            colPlayer++;
            rowPlayer--;
        }
        return sum;
    }

    private static void moveEvil(int[][] matrix, int rowEvils, int colEvils) {
        while (rowEvils >= 0 && colEvils >= 0) {
            if (rowEvils < matrix.length && colEvils < matrix[0].length) {
                matrix[rowEvils][colEvils] = 0;
            }
            rowEvils--;
            colEvils--;
        }
    }
}
