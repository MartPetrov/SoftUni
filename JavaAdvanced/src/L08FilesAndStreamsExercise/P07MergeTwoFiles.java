package L08FilesAndStreamsExercise;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class P07MergeTwoFiles {
    public static void main(String[] args) {

        String pathFileOne = "D:\\Работни\\IT_\\SoftUni\\JavaAdvanced\\src\\L08FilesAndStreamsExercise\\Resources\\inputOne.txt";
        String pathFileTwo = "D:\\Работни\\IT_\\SoftUni\\JavaAdvanced\\src\\L08FilesAndStreamsExercise\\Resources\\inputTwo.txt";

        try {
            PrintWriter write = new PrintWriter("D:\\Работни\\IT_\\SoftUni\\JavaAdvanced\\src\\L08FilesAndStreamsExercise\\outputMergeTwoFile.txt");
            List<String> allLineFileOne = Files.readAllLines(Paths.get(pathFileOne));
            allLineFileOne.forEach(write::println);
            List<String> allLineFileTwo = Files.readAllLines(Paths.get(pathFileTwo));
            allLineFileTwo.forEach(write::println);
            write.close();

        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}
