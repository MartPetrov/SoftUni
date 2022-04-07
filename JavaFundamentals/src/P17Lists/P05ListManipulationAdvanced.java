package P17Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Integer> numList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            List<String> commandLine = Arrays.stream(input.split(" ")).collect(Collectors.toList());
            String command = commandLine.get(0);
            switch (command) {
                case "Contains":
                    int numToContains = Integer.parseInt(commandLine.get(1));
                    numList.contains(numToContains);
                    if (numList.contains(numToContains)) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");
                    }
                    break;
                case "Print":
                    if (commandLine.get(1).equals("even")) {
                        List<Integer> even = numList.stream().filter(e -> e % 2 == 0).collect(Collectors.toList());
                        printList(even, " ");
                    } else {
                        List<Integer> odd = numList.stream().filter(e -> e % 2 != 0).collect(Collectors.toList());
                        printList(odd, " ");
                    }
                    break;
                case "Get":
                    int sum = numList.stream().mapToInt(Integer::intValue).sum();
                    System.out.println(sum);
                    break;
                case "Filter":
                    String condition = commandLine.get(1);
                    int numFilter = Integer.parseInt(commandLine.get(2));
                    if (condition.equals(">")) {
                        List<Integer> fill =
                        numList.stream().filter(n -> n > numFilter).collect(Collectors.toList());
                        printList(fill, " ");
                    } else if (condition.equals("<")) {
                        List<Integer> fill =
                        numList.stream().filter(n -> n < numFilter).collect(Collectors.toList());
                        printList(fill, " ");
                    }else if (condition.equals("<=")) {
                        List<Integer> fill =
                        numList.stream().filter(n -> n <= numFilter).collect(Collectors.toList());
                        printList(fill, " ");
                    }else if (condition.equals(">=")) {
                        List<Integer> fill =
                        numList.stream().filter(n -> n >= numFilter).collect(Collectors.toList());
                        printList(fill, " ");
                    }
                    break;
            }

            input = scanner.nextLine();
        }

    }
    public static void printList (List<Integer> list, String delimiter) {
        System.out.println(list.toString().replaceAll("[\\[\\],]", ""));
    }
}

