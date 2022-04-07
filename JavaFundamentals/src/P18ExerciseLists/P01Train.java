package P18ExerciseLists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Integer> numList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt)
        .collect(Collectors.toList());
        int maxWagon =  Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            List<String> command = Arrays.stream(input.split(" ")).collect(Collectors.toList());
            if (command.contains("Add")) {
                add(Integer.parseInt(command.get(1)), numList);
            } else {
                allPassenger(numList,maxWagon,Integer.parseInt(command.get(0)));
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

    public static void add (int num, List<Integer> list) {
        list.add(num);

    }

    public  static void allPassenger ( List<Integer> list, int maxWagon, int num) {
        for (int i = 0; i < list.size(); i++) {
            int currentNum = list.get(i);
            if (currentNum + num <= maxWagon) {
                list.set(i, num + list.get(i));
                break;
            }
        }

    }
}
