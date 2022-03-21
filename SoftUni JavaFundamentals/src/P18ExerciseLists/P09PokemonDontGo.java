package P18ExerciseLists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P09PokemonDontGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> distance = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList());


        //1. index е в листа - премахваме си елемента на този индеь
        //2. ако е по-малък от нула - премахваме първия
        //3.  ако е по- голям от последния

        // спираме да го правим когато листът е празен

        // продължаваме когато има елементи в листа
        int sum = 0;
        while (!distance.isEmpty()) {
            int index = Integer.parseInt(scanner.nextLine());

            if (index >= 0 && index <= distance.size() - 1) {
                int removedElement = distance.get(index);
                sum += removedElement;
                distance.remove(index);

                changeelement(distance, removedElement);
            } else if (index < 0) {

                int removedFirstElement = distance.get(0);
                sum += removedFirstElement;
                int lastElement = distance.get(distance.size() - 1);
                distance.set(0, lastElement);
                changeelement(distance, removedFirstElement);

            } else if (index > distance.size() - 1) {

                int removedElementLast = distance.get(distance.size() - 1);
                sum += removedElementLast;
                int firstElement = distance.get(0);
                distance.set(distance.size() - 1, firstElement);
                changeelement(distance,removedElementLast);

            }
        }
        System.out.println(sum);

    }

    private static void changeelement(List<Integer> distance, int removedElement) {
        for (int listIndex = 0; listIndex <= distance.size() - 1; listIndex++) {
            int currentNumber = distance.get(listIndex);
            if (currentNumber <= removedElement) {
                currentNumber += removedElement;
            } else if (currentNumber > removedElement){
                currentNumber -= removedElement;
            }
            distance.set(listIndex, currentNumber);
        }
    }
}
