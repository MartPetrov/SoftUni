package L05SetsAndMapsAdvanced;

import java.util.*;
import java.util.stream.Collectors;

public class P03VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<Integer> firstPlayer = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));
        LinkedHashSet<Integer> secondPlayer = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));


        for (int round = 0; round < 50; round++) {
            if (firstPlayer.isEmpty()) {
                System.out.println("Second player win!");
                return;
            }
            if (secondPlayer.isEmpty()) {
                System.out.println("First player win!");
                return;
            }
            int currentCardFirstPlayer = firstPlayer.iterator().next();
            int currentCardSecondPlayer = secondPlayer.iterator().next();

            firstPlayer.remove(currentCardFirstPlayer);
            secondPlayer.remove(currentCardSecondPlayer);

            if (currentCardFirstPlayer > currentCardSecondPlayer) {
                firstPlayer.add(currentCardFirstPlayer);
                firstPlayer.add(currentCardSecondPlayer);
            } else if (currentCardFirstPlayer < currentCardSecondPlayer){
                secondPlayer.add(currentCardFirstPlayer);
                secondPlayer.add(currentCardSecondPlayer);
            } else {
                firstPlayer.add(currentCardFirstPlayer);
                secondPlayer.add(currentCardSecondPlayer);
            }
        }

        if (firstPlayer.size() > secondPlayer.size()) {
            System.out.println("First player win!");
        } else if (secondPlayer.size() > firstPlayer.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }

    }
}
