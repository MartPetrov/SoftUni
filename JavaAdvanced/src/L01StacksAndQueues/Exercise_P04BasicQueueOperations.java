package L01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class Exercise_P04BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int x = scanner.nextInt();

        ArrayDeque<Integer> queues = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            queues.offer(scanner.nextInt());
        }
        for (int i = 1; i <= s; i++) {
            queues.poll();
        }

        if (queues.contains(x)) {
            System.out.println("true");
        } else {
            if (queues.size() == 0) {
                System.out.println("0");
            } else {
                System.out.println(Collections.min(queues));
            }
        }

    }
}
