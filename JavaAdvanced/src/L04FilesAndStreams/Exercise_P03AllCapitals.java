package L04FilesAndStreams;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Exercise_P03AllCapitals {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String inPath = "D:\\Работни\\IT_\\SoftUni\\JavaAdvanced\\src\\L07FilesAndStreams\\Resources\\input.txt";
        BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\Работни\\IT_\\SoftUni\\JavaAdvanced\\src\\L07FilesAndStreams\\outputAllCapital.txt"));

//        List<String> allLine = Files.readAllLines(Paths.get(inPath));
//
//        for (String line: allLine) {
//            writer.write(line.toUpperCase());
//            writer.newLine();
//        }
//        writer.close();


        BufferedReader reader = new BufferedReader(new FileReader(inPath));
        String line = reader.readLine();
        while (line != null) {
            writer.write(line.toUpperCase());
            writer.newLine();
            line = reader.readLine();
        }
        writer.close();
    }
}
