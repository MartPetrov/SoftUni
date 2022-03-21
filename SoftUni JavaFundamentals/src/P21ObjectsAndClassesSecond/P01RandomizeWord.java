package P21ObjectsAndClassesSecond;

import java.util.Random;
import java.util.Scanner;

public class P01RandomizeWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[]  wordsArr = input.split("\\s+");

        Random randomGenerator = new Random();

        for (int i = 0; i < wordsArr.length; i++) {

            int x = randomGenerator.nextInt(wordsArr.length);
            int y = randomGenerator.nextInt(wordsArr.length);


            String oldWordX = wordsArr[x];
            wordsArr[x] = wordsArr[y];
            wordsArr[y] = oldWordX;
        }

        System.out.println(String.join(System.lineSeparator(), wordsArr));
    }
}
