package L04FilesAndStreams;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Exercise_P06WordCount {
    public static void main(String[] args) {

        String pathWords = "D:\\Работни\\IT_\\SoftUni\\JavaAdvanced\\src\\L07FilesAndStreams\\Resources\\words.txt";
        Map<String, Integer> countWords = new LinkedHashMap<>();

        try {
            List<String> allLinesWithWords = Files.readAllLines(Paths.get(pathWords));

            for (String lineWithWords : allLinesWithWords) {
                Arrays.stream(lineWithWords.split("\\s+")).forEach(
                        word -> {
                            countWords.put(word, 0);
                        });
            }
            // Знаем кои са думите, които ще търсим в другия файл;

            String pathText = "D:\\Работни\\IT_\\SoftUni\\JavaAdvanced\\src\\L07FilesAndStreams\\Resources\\text.txt";
            List<String> allLines = Files.readAllLines(Paths.get(pathText));
            for (String line : allLines) {
                Arrays.stream(line.split("\\s+")).forEach(word -> {
                        if (countWords.containsKey(word)) {
                            int currentCount = countWords.get(word);
                            countWords.put(word,currentCount + 1);
                        }
                        }
                );
            }
            PrintWriter writer = new PrintWriter("D:\\Работни\\IT_\\SoftUni\\JavaAdvanced\\src\\L08FilesAndStreamsExercise\\outputWordsCount.txt");
            countWords.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                    .forEach(entry -> writer.println(entry.getKey() + " - " + entry.getValue()));
            writer.close();
        } catch (IOException e) {
            System.out.println("Error");
        }

    }
}
