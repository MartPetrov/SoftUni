package L01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P05PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<String> fileRequest = new ArrayDeque<>();

        while (!input.equals("print")) {
            if (input.equals("cancel")) {
                if (fileRequest.isEmpty()) {
                    System.out.printf("Printer is on standby%n");
                } else {
                    String firstFile = fileRequest.poll();
                    System.out.printf("Canceled %s%n", firstFile);
                }
            } else {
                fileRequest.offer(input);
            }
            input = scanner.nextLine();
        }
        for (String elementInQueue : fileRequest) {
            System.out.println(elementInQueue);
        }
    }
}
