package PrepareForExam.P01;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01OSPlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] tasksArr = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();
        int[] threadsArr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int valueOfTask = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> tasksStack = new ArrayDeque<>();
        for (int i = 0; i < tasksArr.length; i++) {
            tasksStack.push(tasksArr[i]);
        }
        ArrayDeque<Integer> threadsQueue = new ArrayDeque<>();
        for (int i = 0; i < threadsArr.length; i++) {
            threadsQueue.offer(threadsArr[i]);
        }

        while (tasksStack.size() != 0 && threadsQueue.size() != 0) {
            int currentTaskNum = tasksStack.peek();
            int currentThreadsNum = threadsQueue.peek();

            if (foundNumber(valueOfTask, threadsQueue, currentTaskNum, currentThreadsNum)) break;
            if (currentThreadsNum >= currentTaskNum) {
                tasksStack.pop();
                threadsQueue.poll();
            } else {
                threadsQueue.poll();
            }

        }
    }

    private static boolean foundNumber(int valueOfTask, ArrayDeque<Integer> threadsStacks, int currentTaskNum, int currentThreadsNum) {
        if (currentTaskNum == valueOfTask) {
            System.out.printf("Thread with value %d killed task %d%n", currentThreadsNum, valueOfTask);
            int sizeOfStacks = threadsStacks.size();
            for (int i = 0; i < sizeOfStacks; i++) {
                if (i != sizeOfStacks - 1) {
                    System.out.print(threadsStacks.poll() + " ");
                } else {
                    System.out.print(threadsStacks.poll());
                }
            }
            return true;
        }
        return false;
    }
}
