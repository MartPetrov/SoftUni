package P17Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02GaussTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList());

        int size = numList.size();

        for (int i = 0; i < size / 2; i++) {
            numList.set(i, numList.get(i) + numList.get(numList.size() - 1));
            numList.remove(numList.size() - 1);
        }
        System.out.println(numList.toString().replaceAll("[\\[\\],]", " "));
    }
}
