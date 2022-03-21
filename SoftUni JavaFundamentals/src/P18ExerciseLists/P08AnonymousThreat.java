package P18ExerciseLists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P08AnonymousThreat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<String> listSymbol = Arrays.stream(input.split(" ")).collect(Collectors.toList());

        while (!input.equals("3:1")) {
            List<String> command = Arrays.stream(input.split(" ")).collect(Collectors.toList());
            switch (command.get(0)) {

                case "merge":
                    if (listSymbol.size() >1) {
                        int startIndex = Integer.parseInt(command.get(1));
                        int endIndex = Integer.parseInt(command.get(2));
                        merge(listSymbol, startIndex, endIndex);
                    }
                    break;
                case "divide":
                    int index =  Integer.parseInt(command.get(1));
                    int partitions =  Integer.parseInt(command.get(2));
                    divide(listSymbol,index, partitions);
                    break;
            }

            input = scanner.nextLine();
        }
        replace(listSymbol);
    }

    public static void merge(List<String> list, int startIndex, int endIndex) {
        int start = Math.max(0, startIndex);
        int end = Math.min(list.size() - 1, endIndex);

        for (int i = start; i < end; i++) {
            list.set(start,list.get(start).concat(list.get(start + 1)));
            list.remove(start + 1);
        }

    }
    public static void divide (List<String> list, int index, int partitions) {


        List<String> dividedString = new ArrayList<>();
        String currentElement = list.get(index);
        int substringsLength = currentElement.length() / partitions;
        int count = 0;
        String separatedElement = "";
        int counterAdded = 0;

        for (int i = 0; i < currentElement.length(); i++) {

            char symbol = currentElement.charAt(i);
            separatedElement += symbol;
            count++;

            if (count == substringsLength && counterAdded + 1 < partitions) {
                dividedString.add(separatedElement);
                count = 0;
                counterAdded++;
                separatedElement = "";
            }
        }
        dividedString.add(separatedElement);
        list.remove(index);

        for (int i = dividedString.size() - 1; i >= 0; i--) {
            list.add(index, dividedString.get(i));
        }

    }



    public static List<String> replace(List<String> list) {
        System.out.println(list.toString()
                .replace("[", "")
                .replace("]", "")
                .trim()
                .replaceAll(",", "")
                .replaceAll("\\s+", " "));
        return list;

    }

}
