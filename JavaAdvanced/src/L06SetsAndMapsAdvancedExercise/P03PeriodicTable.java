package L06SetsAndMapsAdvancedExercise;

import java.util.*;
import java.util.stream.Collectors;

public class P03PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Set<String> elements = new TreeSet<>();
        for (int row = 1; row <= n; row++) {
            String[] chemicalElements = scanner.nextLine().split("\\s+");
            elements.addAll(Arrays.asList(chemicalElements));
        }

        elements.forEach(e -> System.out.printf("%s ", e));

    }
}
