import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02StickyFingers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size =  Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[size][size];


        List<String> command = Arrays.stream(scanner.nextLine().split(",")).collect(Collectors.toList());
        fillMatrix(scanner, size, matrix);

        int[] dilingerCoord = new int[2];
        findDilinger(matrix,size,dilingerCoord);

        int pocket = 0;
        boolean isFinish = false;
        boolean isCaught = false;
        while (!command.isEmpty()) {
            String currentCommand = command.remove(0);
            int currRow = dilingerCoord[0];
            int currCol = dilingerCoord[1];
            switch (currentCommand) {
                case "left":
                    dilingerCoord[1]--;
                    break;
                case "right":
                    dilingerCoord[1]++;
                    break;
                case "up":
                    dilingerCoord[0]--;
                    break;
                case "down":
                    dilingerCoord[0]++;
                    break;
            }
            if (isInvalidCoordinate(dilingerCoord[0],dilingerCoord[1],matrix)) {
                switch (currentCommand) {
                    case "left":
                        dilingerCoord[1]++;
                        break;
                    case "right":
                        dilingerCoord[1]--;
                        break;
                    case "up":
                        dilingerCoord[0]++;
                        break;
                    case "down":
                        dilingerCoord[0]--;
                        break;
                }
                System.out.println("You cannot leave the town, there is police outside!");
                matrix[dilingerCoord[0]][dilingerCoord[1]] = "D";
            } else {
                if (matrix[dilingerCoord[0]][dilingerCoord[1]].equals("$")) {
                    int currentRow = dilingerCoord[0];
                    int currentCol = dilingerCoord[1];
                    int currentMult = currentRow * currentCol;
                    pocket += currentMult;
                    System.out.printf("You successfully stole %d$.%n", currentMult);
                    matrix[currRow][currCol] = "+";
                    matrix[dilingerCoord[0]][dilingerCoord[1]] = "D";
                } else if (matrix[dilingerCoord[0]][dilingerCoord[1]].equals("P")) {
                    matrix[currRow][currCol] = "+";
                    matrix[dilingerCoord[0]][dilingerCoord[1]] = "#";
                    isCaught = true;
                    break;
                } else {
                    matrix[dilingerCoord[0]][dilingerCoord[1]] = "D";
                    matrix[currRow][currCol] = "+";
                }
            }


            if (command.isEmpty() && !matrix[dilingerCoord[0]][dilingerCoord[1]].equals("#")) {
                isFinish = true;
            }
        }

        if (isFinish) {
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", pocket);
        } else if (isCaught) {
            System.out.printf("You got caught with %d$, and you are going to jail.%n", pocket);
        }


        printMatrix(matrix);
//        for (String[] strings : matrix) {
//            for (String string : strings) {
//                System.out.print(string.replaceAll("[\\[\\],]", "") + " ");
//            }
//            System.out.println();
//        }

    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (col != matrix[row].length - 1) {
                    System.out.print(matrix[row][col] + " ");
                } else {
                    System.out.print(matrix[row][col]);
                }
            }
            System.out.println();
        }
    }

    private static boolean isInvalidCoordinate(int coord0, int coord1, String[][] matrix) {
        return coord0 < 0 || coord0 >= matrix.length || coord1 < 0 || coord1 >= matrix.length;
    }

    private static void fillMatrix(Scanner scanner, int size, String[][] matrix) {
        for (int row = 0; row < size; row++) {
            String[] line = scanner.nextLine().split(" ");
            for (int col = 0; col < size; col++) {
                matrix[row][col] = line[col];
            }
        }
    }


    private static void findDilinger(String[][] matrix, int size, int[] dilingerCoord) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (matrix[row][col].equals("D")) {
                    dilingerCoord[0] = row;
                    dilingerCoord[1] = col;
                    return;
                }
            }
        }
    }
}
