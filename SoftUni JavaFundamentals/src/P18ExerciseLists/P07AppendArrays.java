package P18ExerciseLists;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P07AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine(); // 1 2 3 |4 5 6 |  7  8
        List<String> listSeparatedByPipe = Arrays.stream(input.split("\\|")).collect(Collectors.toList());
        Collections.reverse(listSeparatedByPipe);
        replace(listSeparatedByPipe);
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
