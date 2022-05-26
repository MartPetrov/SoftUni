package L04FilesAndStreams;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Exercise_P07MergeTwoFiles {
    public static void main(String[] args) {

        String pathFileOne = "D:\\Работни\\IT_\\SoftUni\\JavaAdvanced\\src\\L07FilesAndStreams\\Resources\\inputOne.txt";
        String pathFileTwo = "D:\\Работни\\IT_\\SoftUni\\JavaAdvanced\\src\\L07FilesAndStreams\\Resources\\inputTwo.txt";

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
