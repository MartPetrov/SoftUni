package ExamPrep.P02;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.IntStream;

public class P02CookingJourney {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[size][size];

        fillMatrix(scanner, size, matrix);

        int[] coordinate = new int[2];


        findPlayer(size, matrix, coordinate);
        int money = 0;
        boolean isOut = false;
        while (money < 50 && !isOut) {
            String command = scanner.nextLine();
            String current = "";
            switch (command) {
                case "up":
                    matrix[coordinate[0]][coordinate[1]] = "-";
                    coordinate[0]--;
                    if (isValidCoordinate(coordinate[0], coordinate[1], matrix)) {
                        current = matrix[coordinate[0]][coordinate[1]];
                        if (Character.isDigit(current.charAt(0))) {
                            money += Integer.parseInt(current);
                            matrix[coordinate[0]][coordinate[1]] = "S";
                        }
                        if (current.equals("P")) {
                            matrix[coordinate[0]][coordinate[1]] = "-";
                            for (int row = 0; row < size; row++) {
                                for (int col = 0; col < size; col++) {
                                    if (matrix[row][col].equals("P")) {
                                        matrix[row][col] = "S";
                                        coordinate[0] = row;
                                        coordinate[1] = col;
                                    }
                                }
                            }
                        }
                    } else if (!isValidCoordinate(coordinate[0], coordinate[1], matrix)) {
                        isOut = true;
                    }
                    break;
                case "down":
                    matrix[coordinate[0]][coordinate[1]] = "-";
                    coordinate[0]++;

                    if (isValidCoordinate(coordinate[0], coordinate[1], matrix)) {
                        current = matrix[coordinate[0]][coordinate[1]];
                        if (Character.isDigit(current.charAt(0))) {
                            money += Integer.parseInt(current);
                            matrix[coordinate[0]][coordinate[1]] = "S";
                        }
                        if (current.equals("P")) {
                            matrix[coordinate[0]][coordinate[1]] = "-";
                            for (int row = 0; row < size; row++) {
                                for (int col = 0; col < size; col++) {
                                    if (matrix[row][col].equals("P")) {
                                        matrix[row][col] = "S";
                                        coordinate[0] = row;
                                        coordinate[1] = col;
                                    }
                                }
                            }
                        }
                    } else if (!isValidCoordinate(coordinate[0], coordinate[1], matrix)) {
                        isOut = true;
                        break;
                    }
                    break;
                case "left":
                    matrix[coordinate[0]][coordinate[1]] = "-";
                    coordinate[1]--;

                    if (isValidCoordinate(coordinate[0], coordinate[1], matrix)) {
                        current = matrix[coordinate[0]][coordinate[1]];
                        if (Character.isDigit(current.charAt(0))) {
                            money += Integer.parseInt(current);
                            matrix[coordinate[0]][coordinate[1]] = "S";
                        }
                        if (current.equals("P")) {
                            matrix[coordinate[0]][coordinate[1]] = "-";
                            for (int row = 0; row < size; row++) {
                                for (int col = 0; col < size; col++) {
                                    if (matrix[row][col].equals("P")) {
                                        matrix[row][col] = "S";
                                        coordinate[0] = row;
                                        coordinate[1] = col;
                                    }
                                }
                            }
                        }
                    } else if (!isValidCoordinate(coordinate[0], coordinate[1], matrix)) {
                        isOut = true;
                        break;
                    }
                    break;
                case "right":
                    matrix[coordinate[0]][coordinate[1]] = "-";
                    coordinate[1]++;
                    if (isValidCoordinate(coordinate[0], coordinate[1], matrix)) {
                        current = matrix[coordinate[0]][coordinate[1]];
                        if (Character.isDigit(current.charAt(0))) {
                            money += Integer.parseInt(current);
                            matrix[coordinate[0]][coordinate[1]] = "S";
                        }
                        if (current.equals("P")) {
                            matrix[coordinate[0]][coordinate[1]] = "-";
                            for (int row = 0; row < size; row++) {
                                for (int col = 0; col < size; col++) {
                                    if (matrix[row][col].equals("P")) {
                                        matrix[row][col] = "S";
                                        coordinate[0] = row;
                                        coordinate[1] = col;
                                    }
                                }
                            }
                        }
                    } else if (!isValidCoordinate(coordinate[0], coordinate[1], matrix)) {
                        isOut = true;
                        break;
                    }
                    break;
            }

        }
        if (isOut) {
            System.out.println("Bad news! You are out of the pastry shop.");
        } else  {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }
        System.out.printf("Money: %d%n", money);
        for (String[] strings : matrix) {
            for (String string : strings) {
                System.out.print(string.replaceAll("[\\[\\],]", ""));
            }
            System.out.println();
        }
    }

    private static boolean isValidCoordinate(int rowCoord, int colCoord, String[][] matrix) {
        return rowCoord >= 0 && rowCoord < matrix.length && colCoord >= 0 && colCoord < matrix.length;
    }

    private static void findPlayer(int size, String[][] matrix, int[] coordinate) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (matrix[row][col].equals("S")) {
                    coordinate[0] = row;
                    coordinate[1] = col;
                }
            }
        }
    }

    private static void fillMatrix(Scanner scanner, int size, String[][] matrix) {
        IntStream.range(0, size).forEach(row -> {
            String[] inputMatrix = scanner.nextLine().split("");
            System.arraycopy(inputMatrix, 0, matrix[row], 0, size);
        });
    }
}
