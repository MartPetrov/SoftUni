package P18ExerciseLists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P07AppendArraysMine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> numLists = Arrays.stream(scanner.nextLine().split("\\|"))
                .collect(Collectors.toList());

            for (int i = 0; i < numLists.size() / 2; i++) {
                String currentFirst = numLists.get(i);
                String currentLast = numLists.get(numLists.size() - 1 - i);
                numLists.set(numLists.size() - 1 - i, currentFirst);
                numLists.set(i, currentLast);
            }
        replace(numLists);
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
