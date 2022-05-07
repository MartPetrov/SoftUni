package L08FilesAndStreamsExercise;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class P05LineNumbers {
    public static void main(String[] args) {
        String inPath = "D:\\Работни\\IT_\\SoftUni\\JavaAdvanced\\src\\L08FilesAndStreamsExercise\\Resources\\inputLineNumbers.txt";

        try {
            List<String> allLine = Files.readAllLines(Paths.get(inPath));
            PrintWriter writer = new PrintWriter("D:\\Работни\\IT_\\SoftUni\\JavaAdvanced\\src\\L08FilesAndStreamsExercise\\outputLine.txt");
            int number = 1;
            for (String line : allLine) {
                writer.println(number + ". " + line);
                number++;
            }
            writer.close();

        } catch (IOException e) {
            System.out.println("Error");
        }


    }
}

