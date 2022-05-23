package L01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P08BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> browserHistory = new ArrayDeque<>();
        ArrayDeque<String> forwardsQueue = new ArrayDeque<>();

        String input = scanner.nextLine();
        while (!input.equals("Home")) {
            if (input.equals("back")) {
                if (browserHistory.size() < 2) {
                    System.out.println("no previous URLs");
                } else {
                    String currentURL = browserHistory.pop();
                    forwardsQueue.push(currentURL);
                    System.out.println(browserHistory.peek());
                }
            } else if (input.equals("forward")) {
                if (forwardsQueue.isEmpty()){
                    System.out.println("no next URLs");
                } else {
                    String currentForward = forwardsQueue.pop();
                    System.out.println(currentForward);
                    browserHistory.push(currentForward);
                }

            } else {
                browserHistory.push(input);
                System.out.println(input);
                forwardsQueue.clear();
            }
            input = scanner.nextLine();
        }
    }
}
