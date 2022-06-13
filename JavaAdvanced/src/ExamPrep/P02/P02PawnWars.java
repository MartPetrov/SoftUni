package ExamPrep.P02;

import java.util.Scanner;

public class P02PawnWars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] matrix = new String[8][8];

        fillMatrix(scanner, matrix);

        int rowsWhite = -1;
        int colsWhite = -1;
        int rowsBlack = -1;
        int colsBlack = -1;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("w")) {
                    rowsWhite = row;
                    colsWhite = col;
                }
                if (matrix[row][col].equals("b")) {
                    rowsBlack = row;
                    colsBlack = col;
                }
            }
        }

        int move = 0;

        String coordinateFinal = "";
        while (rowsWhite != 0 && rowsBlack != 7) {
            if (isDiagonal(rowsWhite, rowsBlack, colsWhite, colsBlack)) {
                if (move % 2 != 0) {
                    coordinateFinal =  winnerCoordinate (rowsWhite,colsWhite);
                    System.out.printf("Game over! Black capture on %s.%n", coordinateFinal);
                    break;
                } else {
                    coordinateFinal =  winnerCoordinate (rowsBlack,colsBlack);
                    System.out.printf("Game over! White capture on %s.%n", coordinateFinal);
                    break;
                }
            }
            move++;
            if (move % 2 != 0) {
                int oldRow = rowsWhite;
                rowsWhite--;
                matrix[oldRow][colsWhite] = "-";
                matrix[rowsWhite][colsWhite] = "w";

            } else {
                int oldRow = rowsBlack;
                rowsBlack++;
                matrix[oldRow][colsBlack] = "-";
                matrix[rowsBlack][colsBlack] = "b";
            }


            if (rowsWhite == 0) {
                coordinateFinal = winnerCoordinate(rowsWhite, colsWhite);
                System.out.printf("Game over! White pawn is promoted to a queen at %s.%n", coordinateFinal);
            }
            if (rowsBlack == 7) {
                coordinateFinal = winnerCoordinate(rowsBlack, colsBlack);
                System.out.printf("Game over! Black pawn is promoted to a queen at %s.%n", coordinateFinal);
            }
        }



    }


    private static String winnerCoordinate(int rows, int cols) {
        String coordinateFinalcol = "";
        String coordinateFinalrow = "";
        switch (cols) {
            case 0:
                coordinateFinalcol = "a";
                break;
            case 1:
                coordinateFinalcol = "b";
                break;
            case 2:
                coordinateFinalcol = "c";
                break;
            case 3:
                coordinateFinalcol = "d";
                break;
            case 4:
                coordinateFinalcol = "e";
                break;
            case 5:
                coordinateFinalcol = "f";
                break;
            case 6:
                coordinateFinalcol = "g";
                break;
            case 7:
                coordinateFinalcol = "h";
                break;
        }
        switch (rows) {
            case 0:
                coordinateFinalrow = "8";
                break;
            case 1:
                coordinateFinalrow = "7";
                break;
            case 2:
                coordinateFinalrow = "6";
                break;
            case 3:
                coordinateFinalrow = "5";
                break;
            case 4:
                coordinateFinalrow = "4";
                break;
            case 5:
                coordinateFinalrow = "3";
                break;
            case 6:
                coordinateFinalrow = "2";
                break;
            case 7:
                coordinateFinalrow = "1";
                break;
        }
return coordinateFinalcol + coordinateFinalrow;
    }

    private static boolean isDiagonal(int rowsWhite, int rowsBlack, int colsWhite, int colsBlack) {
        if ((rowsWhite == rowsBlack - 1 || rowsWhite - 1 == rowsBlack) && (colsBlack == colsWhite + 1 || colsBlack == colsWhite - 1)) {
            return true;
        } else {
            return false;
        }
    }

    private static void fillMatrix(Scanner scanner, String[][] matrix) {
        for (int row = 0; row < 8; row++) {
            String[] inputRow = scanner.nextLine().split("");
            for (int col = 0; col < 8; col++) {
                matrix[row][col] = inputRow[col];
            }
        }
    }

}
