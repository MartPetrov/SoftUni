
package L01StacksAndQueues;

import java.util.ArrayDeque;

import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;

public class P07MathPotato {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] input = console.nextLine().split("\\s+");
        ArrayDeque<String> children = new ArrayDeque<>();
        Collections.addAll(children, input);
        int number = Integer.parseInt(console.nextLine());
        int primeCircle = 1;

        while (children.size() > 1) {
            for (int i = 1; i < number; i++) {
                children.offer(Objects.requireNonNull(children.poll()));
            }
            if (primeCircle == 1 || primeCircle == 4 || (primeCircle > 5 && (primeCircle % 2 == 0 || primeCircle % 3 == 0 || primeCircle % 5 == 0))) {
                System.out.println("Removed " + children.poll());
            } else {
                System.out.println("Prime " + children.peek());
            }
            primeCircle++;
        }
        System.out.println("Last is " + children.peek());
    }
}