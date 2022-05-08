package ExamPrep.P02.MouseAndCheese;

import java.util.Scanner;

public class P02ThroneConquering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int energy = Integer.parseInt(scanner.nextLine());

        int rows = Integer.parseInt(scanner.nextLine());
        char[][] field = new char[rows][rows];

        for (int row = 0; row < rows; row++) {
            field[row] = scanner.nextLine().toCharArray();
        }
        int parisRow = 0;
        int parisCol = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < field[row].length; col++) {
                if (field[row][col] == 'P') {
                    parisRow = row;
                    parisCol = col;
                }
            }
        }

            while (true) {
                String command = scanner.nextLine();
                String direction = command.split(" ")[0];
                int enemyRow = Integer.parseInt(command.split(" ")[1]);
                int enemyCol = Integer.parseInt(command.split(" ")[2]);

                field[parisRow][parisCol] = '-';
                field[enemyRow][enemyCol] = 'S';

                switch (direction) {
                    case "up":
                        if (parisRow - 1 >= 0) {
                            parisRow--;
                        }
                        break;
                    case "down":
                        if (parisRow + 1 < field.length) {
                            parisRow++;
                        }
                        break;
                    case "left":
                        if (parisCol - 1 >= 0) {
                            parisCol--;
                        }
                        break;
                    case "right":
                        if (parisCol + 1 < field.length) {
                            parisCol++;
                        }
                        break;
                }
                energy--;
                if (energy <= 0) {
                    ParisDead(field, parisRow, parisCol);
                    return;
                }
                if (field[parisRow][parisCol] == 'S') {
                    energy -= 2;
                    if (energy <= 0) {
                        ParisDead(field, parisRow, parisCol);
                        return;
                    } else {
                        field[parisRow][parisCol] = '-';
                    }
                } else if (field[parisRow][parisCol] == 'H') {
                    field[parisRow][parisCol] = '-';
                    System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n", energy);
                    printField(field);
                    return;
                }
            }
        }

    public static void ParisDead(char[][] field, int parisRow, int parisCol) {
        field[parisRow][parisCol] = 'X';
        System.out.printf("Paris died at %d;%d.%n", parisRow, parisCol);
        printField(field);
    }


    private static void printField(char[][] field) {
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                System.out.print(field[row][col]);
            }
            System.out.println();
        }
    }
}