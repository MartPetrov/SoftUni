package P17Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P04ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Integer> numList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt)
        .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            List<String> commandLine = Arrays.stream(input.split(" ")).collect(Collectors.toList());
            String command = commandLine.get(0);
            switch (command) {
                case "Add":
                    int numToAdd = Integer.parseInt(commandLine.get(1));
                    numList.add(numToAdd);
                    break;
                case "Remove":
                    int numRemove = Integer.parseInt(commandLine.get(1));
                    numList.remove(Integer.valueOf(numRemove));
                    break;
                case "RemoveAt":
                    int indexRemove = Integer.parseInt(commandLine.get(1));
                    numList.remove(indexRemove);
                    break;
                case "Insert":
                    int numInsert = Integer.parseInt(commandLine.get(1));
                    int indexInsert = Integer.parseInt(commandLine.get(2));
                    numList.add(indexInsert, numInsert);
                    break;
            }

            input = scanner.nextLine();
        }

        System.out.println(numList.toString().replaceAll("[\\[\\],]", ""));
    }
}
