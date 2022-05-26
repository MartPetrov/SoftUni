package L04FilesAndStreams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Exercise_P01SumLines {
    public static void main(String[] args) throws IOException {
        String inPath = "D:\\Работни\\IT_\\SoftUni\\JavaAdvanced\\src\\L07FilesAndStreams\\Resources\\input.txt";
        List<String> allLines = Files.readAllLines(Paths.get(inPath));

//        for (String line : allLines) {
//            int sum = 0;
//            for (int index = 0; index < line.length(); index++) {
//                char currentSymbol = line.charAt(index);
//                sum += currentSymbol;
//            }
//            System.out.println(sum);
//        }

        allLines.stream().map(String::toCharArray).forEach(arr -> {
            int sum =0;
            for (char symbol: arr) {
                sum += symbol;
            }
            System.out.println(sum);
        });
    }
}
