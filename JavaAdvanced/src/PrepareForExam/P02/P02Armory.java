package PrepareForExam.P02;

import java.util.Scanner;

public class P02Armory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sizeOfMatrix = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[sizeOfMatrix][sizeOfMatrix];

        fillTheMatrix(scanner, matrix);

        int gold = 0;

        int rowOfOfficer = -1;
        int colOfOfficer = -1;
        int firstMirrorRow = -1;
        int firstMirrorCol = -1;
        boolean isFindFirstMirror = false;
        int secondMirrorRow = -1;
        int secondMirrorCol = -1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("A")) {
                    rowOfOfficer = row;
                    colOfOfficer = col;
                }
                if (matrix[row][col].equals("M") && !isFindFirstMirror) {
                    firstMirrorRow = row;
                    firstMirrorCol = col;
                    isFindFirstMirror = true;
                    continue;
                }
                if (matrix[row][col].equals("M") && isFindFirstMirror) {
                    secondMirrorRow = row;
                    secondMirrorCol = col;
                }

            }
        }

        while (gold < 65) {
            String command = scanner.nextLine();
            switch (command) {
                case "up":
                    int oldRowUp = rowOfOfficer;
                    rowOfOfficer--;
                    matrix[oldRowUp][colOfOfficer] = "-";
                    break;
                case "down":
                    int oldRowDown = rowOfOfficer;
                    rowOfOfficer++;
                    matrix[oldRowDown][colOfOfficer] = "-";
                    break;
                case "left":
                    int oldColLeft = colOfOfficer;
                    colOfOfficer--;
                    matrix[rowOfOfficer][oldColLeft] = "-";
                    break;
                case "right":
                    int oldColRight = colOfOfficer;
                    colOfOfficer++;
                    matrix[rowOfOfficer][oldColRight] = "-";
                    break;
            }
            if (isLeave(sizeOfMatrix, rowOfOfficer, colOfOfficer)) break;
            if (Character.isDigit(matrix[rowOfOfficer][colOfOfficer].charAt(0))) {
                gold += Integer.parseInt(matrix[rowOfOfficer][colOfOfficer]);
            }
            if (matrix[rowOfOfficer][colOfOfficer].equals("M")) {
                if (firstMirrorRow == rowOfOfficer && firstMirrorCol == colOfOfficer) {
                    rowOfOfficer = secondMirrorRow;
                    colOfOfficer = secondMirrorCol;
                } else {
                    rowOfOfficer = firstMirrorRow;
                    colOfOfficer = firstMirrorCol;
                }
                matrix[firstMirrorRow][firstMirrorCol] = "-";
                matrix[secondMirrorRow][secondMirrorCol] = "-";
            }
            matrix[rowOfOfficer][colOfOfficer] = "A";

        }
        if (gold >= 65) {
            System.out.println("Very nice swords, I will come back for more!");
        }
        System.out.printf("The king paid %d gold coins.%n", gold);

        for (String[] strings : matrix) {
            for (String string : strings) {
                System.out.print(string.replaceAll("[\\[\\],]", ""));
            }
            System.out.println();
        }

    }

    private static boolean isLeave(int sizeOfMatrix, int rowOfOfficer, int colOfOfficer) {
        if (rowOfOfficer < 0 || rowOfOfficer == sizeOfMatrix || colOfOfficer < 0 || colOfOfficer == sizeOfMatrix) {
            System.out.println("I do not need more swords!");
            return true;
        }
        return false;
    }


    private static void fillTheMatrix(Scanner scanner, String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            String[] inputFillMatrix = scanner.nextLine().split("");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = inputFillMatrix[col];
            }
        }
    }
}
