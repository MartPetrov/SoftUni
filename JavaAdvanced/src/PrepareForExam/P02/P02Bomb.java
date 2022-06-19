package PrepareForExam.P02;

import java.util.*;
import java.util.stream.Collectors;

public class P02Bomb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[size][size];
        List<String> command = Arrays.stream(scanner.nextLine().split(",")).collect(Collectors.toList());
        for (int row = 0; row < size; row++) {
            String[] line = scanner.nextLine().split("\\s+");
            for (int col = 0; col < size; col++) {
                matrix[row][col] = line[col];
            }
        }

        int[] sapperCoord = new int[2];
        int countAllBomb = 0;
        findSapper(matrix, size, sapperCoord);
        boolean isFoundEnd = false;
        for (String[] strings : matrix) {
            for (String string : strings) {
                if (string.equals("B")) {
                    countAllBomb++;
                }
            }
        }
        while (!command.isEmpty() && !isFoundEnd) {
            String currentCommand = command.remove(0);
            matrix[sapperCoord[0]][sapperCoord[1]] = "+";
            switch (currentCommand) {
                case "left":
                    sapperCoord[1]--;
                    break;
                case "right":
                    sapperCoord[1]++;
                    break;
                case "up":
                    sapperCoord[0]--;
                    break;
                case "down":
                    sapperCoord[0]++;
                    break;
            }

            if (isInvalidCoordinate(sapperCoord[0], sapperCoord[1], matrix)) {
                switch (currentCommand) {
                    case "left":
                        sapperCoord[1]++;
                        break;
                    case "right":
                        sapperCoord[1]--;
                        break;
                    case "up":
                        sapperCoord[0]++;
                        break;
                    case "down":
                        sapperCoord[0]--;
                        break;
                }
                matrix[sapperCoord[0]][sapperCoord[1]] = "s";
            }

            if (matrix[sapperCoord[0]][sapperCoord[1]].equals("B")) {
                countAllBomb--;
                System.out.println("You found a bomb!");
            }
            if (matrix[sapperCoord[0]][sapperCoord[1]].equals("e")) {
                isFoundEnd = true;
                break;
            }

        }

        if (countAllBomb == 0) {
            System.out.println("Congratulations! You found all bombs!");
        } else if (isFoundEnd) {
            System.out.printf("END! %d bombs left on the field%n", countAllBomb);
        } else {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", countAllBomb, sapperCoord[0], sapperCoord[1]);
        }
    }

    private static boolean isInvalidCoordinate(int coord0, int coord1, String[][] matrix) {
        return coord0 < 0 || coord0 >= matrix.length || coord1 < 0 || coord1 >= matrix.length;
    }

    private static void findSapper(String[][] matrix, int size, int[] sapperCoord) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (matrix[row][col].equals("s")) {
                    sapperCoord[0] = row;
                    sapperCoord[1] = col;
                }
            }
        }
    }

}
