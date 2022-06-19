package ExamPrepare.P02;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class P02Python {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];
        String[] commandLine = scanner.nextLine().split(", ");
        List<String> listOfCommand = new LinkedList<>(Arrays.asList(commandLine));


        fillMatrix(scanner, matrix);

        int[] coordinateSnake = new int[2];

        findSnake(matrix, coordinateSnake);

        int lengthSnake = 1;
        boolean isdead = false;

        while (!listOfCommand.isEmpty()) {
            String currentCommand = listOfCommand.remove(0);

            char currentChar = 0;
            if (currentCommand.equals("left")) {
                coordinateSnake[1]--;
                if (checkCoordinate(coordinateSnake[1], matrix)) {
                    currentChar = checkWhatIsInThisCoord(coordinateSnake[0], coordinateSnake[1], matrix);
                    matrix[coordinateSnake[0]][coordinateSnake[1]] = 's';
                    matrix[coordinateSnake[0]][coordinateSnake[1] + 1] = '*';
                } else {
                    coordinateSnake[1] = size - 1;
                    currentChar = checkWhatIsInThisCoord(coordinateSnake[0], coordinateSnake[1], matrix);
                    matrix[coordinateSnake[0]][0] = '*';
                    matrix[coordinateSnake[0]][coordinateSnake[1]] = 's';
                }
            } else if (currentCommand.equals("right")) {
                coordinateSnake[1]++;
                if (checkCoordinate(coordinateSnake[1], matrix)) {
                    currentChar = checkWhatIsInThisCoord(coordinateSnake[0], coordinateSnake[1], matrix);
                    matrix[coordinateSnake[0]][coordinateSnake[1]] = 's';
                    matrix[coordinateSnake[0]][coordinateSnake[1] - 1] = '*';
                } else {
                    coordinateSnake[1] = 0;
                    currentChar = checkWhatIsInThisCoord(coordinateSnake[0], coordinateSnake[1], matrix);
                    matrix[coordinateSnake[0]][size - 1] = '*';
                    matrix[coordinateSnake[0]][coordinateSnake[1]] = 's';
                }
            } else if (currentCommand.equals("up")) {
                coordinateSnake[0]--;
                if (checkCoordinate(coordinateSnake[0], matrix)) {
                    currentChar = checkWhatIsInThisCoord(coordinateSnake[0], coordinateSnake[1], matrix);
                    matrix[coordinateSnake[0]][coordinateSnake[1]] = 's';
                    matrix[coordinateSnake[0] + 1][coordinateSnake[1]] = '*';
                } else {
                    coordinateSnake[0] = size - 1;
                    currentChar = checkWhatIsInThisCoord(coordinateSnake[0], coordinateSnake[1], matrix);
                    matrix[0][coordinateSnake[1]] = '*';
                    matrix[size - 1][coordinateSnake[1]] = 's';
                }
            } else if (currentCommand.equals("down")) {
                coordinateSnake[0]++;
                if (checkCoordinate(coordinateSnake[0], matrix)) {
                    currentChar = checkWhatIsInThisCoord(coordinateSnake[0], coordinateSnake[1], matrix);
                    matrix[coordinateSnake[0]][coordinateSnake[1]] = 's';
                    matrix[coordinateSnake[0] - 1][coordinateSnake[1]] = '*';
                } else {
                    coordinateSnake[0] = 0;
                    currentChar = checkWhatIsInThisCoord(coordinateSnake[0], coordinateSnake[1], matrix);
                    matrix[size - 1][coordinateSnake[1]] = '*';
                    matrix[coordinateSnake[0]][coordinateSnake[1]] = 's';
                }

            }

            if (currentChar == 'f') {
                lengthSnake++;
            }
            if (currentChar == 'e') {
                isdead = true;
                break;
            }
        }

        int foodCount = 0;
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                if (aChar == 'f') {
                    foodCount++;
                }
            }
        }

        if (foodCount == 0) {
            System.out.printf("You win! Final python length is %d", lengthSnake);
        } else if (isdead) {
            System.out.println("You lose! Killed by an enemy!");
        } else {
            System.out.printf("You lose! There is still %d food to be eaten.", foodCount);
        }
    }


    private static char checkWhatIsInThisCoord(int rowCoord, int colCoord, char[][] matrix) {
        return matrix[rowCoord][colCoord];
    }

    private static boolean checkCoordinate(int coordinate, char[][] matrix) {
        return coordinate >= 0 && coordinate < matrix.length;
    }

    private static void findSnake(char[][] matrix, int[] coordinateSnake) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] == 's') {
                    coordinateSnake[0] = row;
                    coordinateSnake[1] = col;
                }
            }
        }
    }

    private static void fillMatrix(Scanner scanner, char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            String[] inputLineMatrix = scanner.nextLine().split(" ");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = inputLineMatrix[col].charAt(0);
            }
        }
    }
}
