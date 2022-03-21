package P18ExerciseLists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("end")) {
            String commandName = command.split(" ")[0];
            int element = Integer.parseInt(command.split(" ")[1]);
            if (commandName.equals("Delete")) {
                numList.removeAll(Arrays.asList(element));
            } else  if (commandName.equals("Insert")){
                int position = Integer.parseInt(command.split(" ")[2]);
                numList.add(position, element);

            }
                    command = scanner.nextLine();
        }

        printList(numList, " ");

    }
    public static void printList (List<Integer> list, String delimiter) {
        System.out.println(list.toString().replaceAll("[\\[\\],]", ""));
    }
}
