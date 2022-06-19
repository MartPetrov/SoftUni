package PrepareForExam.P01;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P01Bouquets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arrInputDaffodils = scanner.nextLine().split(", ");
        String[] arrInputTulips = scanner.nextLine().split(", ");

        ArrayDeque<Integer> daffodils = new ArrayDeque<>();
        ArrayDeque<Integer> tulips = new ArrayDeque<>();
        for (int i = 0; i < arrInputDaffodils.length; i++) {
            int current = Integer.parseInt(arrInputDaffodils[i]);
            daffodils.push(current);
        }

        for (int i = 0; i < arrInputTulips.length; i++) {
            int current = Integer.parseInt(arrInputTulips[i]);
            tulips.offer(current);
        }


        int bouquet = 0;
        int flowersLeft = 0;
        while (!daffodils.isEmpty() && !tulips.isEmpty()) {
            int currentDaff = daffodils.peek();
            int currentTull = tulips.peek();
            int currentSum = currentDaff + currentTull;
            if (currentSum < 15) {
                tulips.poll();
                daffodils.pop();
                flowersLeft += currentDaff + currentTull;
            } else if (currentSum == 15) {
                bouquet++;
                daffodils.pop();
                tulips.poll();
            } else {
                daffodils.pop();
                daffodils.push(currentDaff - 2);
            }
        }
        int moreBouquet = flowersLeft / 15;
        bouquet += moreBouquet;

        if (bouquet >= 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!", bouquet);
        } else {
            System.out.printf("You failed... You need more %d bouquets.", 5 - bouquet);
        }
    }
}
