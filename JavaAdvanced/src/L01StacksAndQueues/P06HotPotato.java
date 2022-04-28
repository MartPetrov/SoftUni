package L01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P06HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] children = scanner.nextLine().split(" ");
        int numberOfTurns =  Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> childrenQueue = new ArrayDeque<>();

        for (int i = 0; i < children.length; i++) {
        childrenQueue.offer(children[i]);
        }
        while (childrenQueue.size() != 1) {
            for (int i = 1; i < numberOfTurns ; i++) {
                String currentChild = childrenQueue.poll();
                childrenQueue.offer(currentChild);
            }
            String childToRemove = childrenQueue.poll();
            System.out.println("Removed " + childToRemove);
        }
        System.out.printf("Last is %s", childrenQueue.peek());
    }
}
