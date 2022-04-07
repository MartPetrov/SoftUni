package P18ExerciseLists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P04ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            List<String> command = Arrays.stream(input.split("\\s+")).collect(Collectors.toList());

            switch (command.get(0)) {
                case "Add":
                    int numToAdd = Integer.parseInt(command.get(1));
                    add(numList, numToAdd);
                    break;
                case "Remove":
                    int numToRemove = Integer.parseInt(command.get(1));
                    remove(numList, numToRemove);
                    break;
                case "Insert":
                    int numToInsert = Integer.parseInt(command.get(1));
                    int indexToInsert = Integer.parseInt(command.get(2));
                    insert(numList, numToInsert, indexToInsert);
                    break;
                case "Shift":
                    String position = command.get(1);
                    int numToShift = Integer.parseInt(command.get(2));
                    shift(numList, position, numToShift);
                    break;


            }

            input = scanner.nextLine();
        }
        numList.toString().trim()
                .replaceAll("[\\s+\\[\\],]", "");
        for (int i = 0; i < numList.size(); i++) {
            if (i < numList.size() - 1) {
                System.out.print(numList.get(i) + " ");
            } else if (i == numList.size() - 1) {
                System.out.print(numList.get(i));
            }

        }
    }

    public static void add(List<Integer> list, int number) {
        list.add(number);
    }

    public static void remove(List<Integer> list, int number) {
        if (number >= 0 && number < list.size()) {
            list.remove(number);
        } else {
            System.out.printf("Invalid index%n");
        }

    }

    public static void insert(List<Integer> list, int number, int index) {
        if (index >= 0 && index < list.size()) {
            list.add(index, number);
        } else {
            System.out.printf("Invalid index%n");
        }

    }

    public static void shift(List<Integer> list, String position, int count) {

            for (int i = 1; i <= count; i++) {
                if (position.equals("right")) {
                    int currentRight = list.get(list.size() - 1);
                    list.add(0,currentRight);
                    list.remove(list.size() - 1);
                } else if (position.equals("left")) {
                    int currentNum = list.get(0);
                    list.add(currentNum);
                    list.remove(0);
                }
            }


    }
}

