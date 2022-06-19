package PrepareForExam.P02;


import java.util.Arrays;
import java.util.Scanner;

public class P02ThroneConquering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int parisEnergy = Integer.parseInt(scanner.nextLine());
        int rows = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[rows][];

        fillMatrix(scanner, rows, matrix);

        int[] parisCoordinate = new int[2];
        int[] helenCoordinate = new int[2];

        findParisAndHelen(matrix, parisCoordinate, helenCoordinate);


        while (parisEnergy > 0) {
            parisEnergy--;
            String[] commandLine = scanner.nextLine().split("\\s+");
            String command = commandLine[0];
            int rowSpartan = Integer.parseInt(commandLine[1]);
            int colSpartan = Integer.parseInt(commandLine[2]);
            matrix[rowSpartan][colSpartan] = "S";

            switch (command) {
                case "up":
                    matrix[parisCoordinate[0]][parisCoordinate[1]] = "-";
                    parisCoordinate[0]--;
                    if (!isValidCoordinate(parisCoordinate[0], matrix)) {
                        parisCoordinate[0]++;
                        matrix[parisCoordinate[0]][parisCoordinate[1]] = "P";
                        continue;
                    }
                    parisEnergy = onNewCoordinate(parisCoordinate[0], parisCoordinate[1], matrix, parisEnergy);
                    if (parisEnergy > 0) {
                        matrix[parisCoordinate[0]][parisCoordinate[1]] = "P";
                        matrix[parisCoordinate[0] + 1][parisCoordinate[1]] = "-";
                    }
                    break;
                case "down":
                    matrix[parisCoordinate[0]][parisCoordinate[1]] = "-";
                    parisCoordinate[0]++;
                    if (!isValidCoordinate(parisCoordinate[0], matrix)) {
                        parisCoordinate[0]--;
                        matrix[parisCoordinate[0]][parisCoordinate[1]] = "P";
                        continue;
                    }
                    parisEnergy = onNewCoordinate(parisCoordinate[0], parisCoordinate[1], matrix, parisEnergy);
                    if (parisEnergy > 0) {
                        matrix[parisCoordinate[0]][parisCoordinate[1]] = "P";
                        matrix[parisCoordinate[0] - 1][parisCoordinate[1]] = "-";
                    }

                    break;
                case "left":
                    matrix[parisCoordinate[0]][parisCoordinate[1]] = "-";
                    parisCoordinate[1]--;
                    if (!isValidCoordinate(parisCoordinate[1], matrix)) {
                        parisCoordinate[1]++;
                        matrix[parisCoordinate[0]][parisCoordinate[1]] = "P";
                        continue;
                    }
                    parisEnergy = onNewCoordinate(parisCoordinate[0], parisCoordinate[1], matrix, parisEnergy);
                    if (parisEnergy > 0) {
                        matrix[parisCoordinate[0]][parisCoordinate[1]] = "P";
                        matrix[parisCoordinate[0]][parisCoordinate[1] + 1] = "-";
                    }

                    break;
                case "right":
                    matrix[parisCoordinate[0]][parisCoordinate[1]] = "-";
                    parisCoordinate[1]++;
                    if (!isValidCoordinate(parisCoordinate[1], matrix)) {
                        parisCoordinate[1]--;
                        matrix[parisCoordinate[0]][parisCoordinate[1]] = "P";
                        continue;
                    }
                    parisEnergy = onNewCoordinate(parisCoordinate[0], parisCoordinate[1], matrix, parisEnergy);
                    if (parisEnergy > 0) {
                        matrix[parisCoordinate[0]][parisCoordinate[1]] = "P";
                        matrix[parisCoordinate[0]][parisCoordinate[1] - 1] = "-";
                    }
                    break;
            }


            if (parisEnergy <= 0) {
                matrix[parisCoordinate[0]][parisCoordinate[1]] = "X";
                System.out.printf("Paris died at %d;%d.%n", parisCoordinate[0], parisCoordinate[1]);
            }
            if (isFoundHelen(parisCoordinate, helenCoordinate)) {
                matrix[parisCoordinate[0]][parisCoordinate[1]] = "-";
                System.out.println("Paris has successfully abducted Helen! Energy left: " + parisEnergy);
                break;
            }

        }

        for (String[] strings : matrix) {
            for (String string : strings) {
                System.out.print(string.replaceAll("[\\[\\],]", ""));
            }
            System.out.println();
        }

    }

    private static int onNewCoordinate(int rowParis, int colParis, String[][] matrix, int parisEnergy) {
        if (matrix[rowParis][colParis].equals("S")) {
            parisEnergy -= 2;
        }
        return parisEnergy;
    }

    private static boolean isValidCoordinate(int coordinate, String[][] matrix) {
        return coordinate >= 0 && coordinate < matrix.length;
    }

    private static boolean isFoundHelen(int[] parisCoordinate, int[] helenCoordinate) {
        return Arrays.equals(parisCoordinate, helenCoordinate);
    }


    private static void findParisAndHelen(String[][] matrix, int[] parisCoordinate, int[] helenCoordinate) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("P")) {
                    parisCoordinate[0] = row;
                    parisCoordinate[1] = col;
                }
                if (matrix[row][col].equals("H")) {
                    helenCoordinate[0] = row;
                    helenCoordinate[1] = col;
                }

            }
        }
    }

    private static void fillMatrix(Scanner scanner, int rows, String[][] matrix) {
        for (int row = 0; row < rows; row++) {
            String[] currentRow = scanner.nextLine().split("");
            for (int col = 0; col < currentRow.length; col++) {
                matrix[row] = currentRow;
            }
        }
    }
}