package ExamPrepare.P02;

import java.util.Scanner;

public class P02FormulaOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sizeOfMatrix = Integer.parseInt(scanner.nextLine());
        int commandsCount = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[sizeOfMatrix][sizeOfMatrix];

        FillMatrix(scanner, sizeOfMatrix, matrix);

        int rowPlayer = -1;
        int colPlayer = -1;
        for (int row = 0; row < sizeOfMatrix; row++) {
            for (int col = 0; col < sizeOfMatrix; col++) {
                if (matrix[row][col].equals("P")) {
                    rowPlayer = row;
                    colPlayer = col;
                }
            }
        }

        boolean isFinish = false;
        while (commandsCount-- > 0) {
            String command = scanner.nextLine();
            int oldRow = rowPlayer;
            int oldCol = colPlayer;
            switch (command) {
                case "up":
                    rowPlayer--;
                    break;
                case "down":
                    rowPlayer++;
                    break;
                case "left":
                    colPlayer--;
                    break;
                case "right":
                    colPlayer++;
                    break;
            }
            if (!isInBound(rowPlayer, colPlayer, sizeOfMatrix)) {
                if (rowPlayer < 0) {
                    rowPlayer = sizeOfMatrix - 1;
                } else if (rowPlayer >= sizeOfMatrix) {
                    rowPlayer = 0;
                } else if (colPlayer < 0) {
                    colPlayer = sizeOfMatrix - 1;
                } else if (colPlayer >= sizeOfMatrix) {
                    colPlayer = 0;
                }
                matrix[rowPlayer][colPlayer] = "P";
                matrix[oldRow][oldCol] = ".";
            }

            if (matrix[rowPlayer][colPlayer].equals("F")) {
                isFinish = true;
                matrix[rowPlayer][colPlayer] = "P";
                matrix[oldRow][oldCol] = ".";
                System.out.println("Well done, the player won first place!");
                break;
            } else if (matrix[rowPlayer][colPlayer].equals("B")) {
                switch (command) {
                    case "up":
                        rowPlayer--;
                        if (rowPlayer < 0) {
                            rowPlayer = sizeOfMatrix - 1;
                        }
                        break;
                    case "down":
                        rowPlayer++;
                        if (rowPlayer >= sizeOfMatrix) {
                            rowPlayer = 0;
                        }
                        break;
                    case "left":
                        colPlayer--;
                        if (colPlayer < 0) {
                            colPlayer = sizeOfMatrix - 1;
                        }
                        break;
                    case "right":
                        colPlayer++;
                        if (colPlayer >= sizeOfMatrix) {
                            colPlayer = 0;
                        }
                        break;
                }
            } else if (matrix[rowPlayer][colPlayer].equals("T")) {
                switch (command) {
                    case "up":
                        break;
                    case "down":
                        rowPlayer--;
                        break;
                    case "left":
                        colPlayer++;
                        break;
                    case "right":
                        colPlayer--;
                        break;
                }
            }
            matrix[rowPlayer][colPlayer] = "P";
            matrix[oldRow][oldCol] = ".";
        }
        if (!isFinish) {
            System.out.println("Oh no, the player got lost on the track!");
        }

        for (String[] strings : matrix) {
            for (String string : strings) {
                System.out.print(string.replaceAll("[\\[\\],]", ""));
            }
            System.out.println();
        }

    }

    private static boolean isInBound(int rowPlayer, int colPlayer, int size) {
        return rowPlayer >= 0 && rowPlayer < size && colPlayer >= 0 && colPlayer < size;
    }


    private static void FillMatrix(Scanner scanner, int sizeOfMatrix, String[][] matrix) {
        for (int row = 0; row < sizeOfMatrix; row++) {
            String[] inputMatrixRow = scanner.nextLine().split("");
            System.arraycopy(inputMatrixRow, 0, matrix[row], 0, sizeOfMatrix);
        }
    }
}
