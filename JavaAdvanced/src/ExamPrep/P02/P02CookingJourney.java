package ExamPrep.P02;

import java.util.Scanner;

public class P02CookingJourney {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[size][size];

        fillMatrix(matrix, scanner);
        int[] coordPlayer = new int[2];
        findPlayer(matrix, coordPlayer, size);

        int money = 0;
        boolean isOut = false;
        while (money < 50 && !isOut) {
            String command = scanner.nextLine();
            matrix[coordPlayer[0]][coordPlayer[1]] = "-";
            switch (command) {
                case "up":
                    coordPlayer[0]--;
                    break;
                case "down":
                    coordPlayer[0]++;
                    break;
                case "left":
                    coordPlayer[1]--;
                    break;
                case "right":
                    coordPlayer[1]++;
                    break;
            }

            if (isValidCoord(coordPlayer[0], coordPlayer[1], matrix)) {
                if (Character.isDigit(matrix[coordPlayer[0]][coordPlayer[1]].charAt(0))) {
                    money += Integer.parseInt(matrix[coordPlayer[0]][coordPlayer[1]]);
                    matrix[coordPlayer[0]][coordPlayer[1]] = "S";
                }
                if (matrix[coordPlayer[0]][coordPlayer[1]].equals("P")) {
                    matrix[coordPlayer[0]][coordPlayer[1]] = "-";
                    for (int row = 0; row < matrix.length; row++) {
                        for (int col = 0; col < matrix.length; col++) {
                            if (matrix[row][col].equals("P")) {
                                matrix[row][col] = "S";
                                coordPlayer[0] = row;
                                coordPlayer[1] = col;
                            }
                        }
                    }
                }

            } else {
                isOut = true;
                System.out.println("Bad news! You are out of the pastry shop.");
                break;
            }
        }


        if (!isOut) {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }
        System.out.printf("Money: %d%n",money);

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }

    }

    private static boolean isValidCoord(int coord0, int coord1, String[][] matrix) {
        return (coord0 >= 0 && coord0 < matrix.length && coord1 >= 0 && coord1 < matrix.length);
    }

    private static void findPlayer(String[][] matrix, int[] coordPlayer, int size) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (matrix[row][col].equals("S")) {
                    coordPlayer[0] = row;
                    coordPlayer[1] = col;
                }

            }

        }
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            String[] rowInput = scanner.nextLine().split("");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = rowInput[col];
            }
        }
    }


}