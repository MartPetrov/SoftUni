package L04FilesAndStreams;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Exercise_P02SumBytes {
    public static void main(String[] args) throws IOException {

        String inPath = "D:\\Работни\\IT_\\SoftUni\\JavaAdvanced\\src\\L07FilesAndStreams\\Resources\\input.txt";
        long sum = 0;
//
//        BufferedReader br = new BufferedReader(new FileReader(inPath));
//
//        String line = br.readLine();
//        while (line!= null) {
//            for (int index = 0; index < line.length(); index++) {
//                char currentSymbol = line.charAt(index);
//                sum += currentSymbol;
//            }
//            line = br.readLine();
//        }
//        System.out.println(sum);

        byte[] allBytes = Files.readAllBytes(Paths.get(inPath));
            for (byte ascii: allBytes) {
                if (ascii != 10 && ascii != 13) { // нов ред или ретърн №10 и №13 от аски таблицата
                    sum += ascii;
                }
            }
        System.out.println(sum);
    }
}
