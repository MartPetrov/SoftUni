package P18ExerciseLists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Integer> numList = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> bombNumAndPower = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt)
                .collect(Collectors.toList());
        int bombNum = bombNumAndPower.get(0);
        int powerNum = bombNumAndPower.get(1);
        bomb(numList, bombNum, powerNum);

        System.out.println(sum(numList));

    }

    public static void bomb(List<Integer> list, int bombNum, int powerNum) {
        while (list.contains(bombNum)) {
            int indexBomb = list.indexOf(bombNum);

            int left = Math.max(0, indexBomb - powerNum);
            int right = Math.min(list.size() - 1, indexBomb + powerNum);

            for (int i = left; i <= right; i++) {
                list.remove(left);
            }
        }
    }


    public static int sum(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).sum();
    }
}
