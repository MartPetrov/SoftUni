package L04FilesAndStreams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class P04ExtractIntegers {
    public static void main(String[] args) throws FileNotFoundException {

        String inPath = "D:\\Работни\\IT_\\SoftUni\\JavaAdvanced\\src\\L07FilesAndStreams\\Resources - Lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outPath = "D:\\Работни\\IT_\\SoftUni\\JavaAdvanced\\src\\L07FilesAndStreams\\Resources - Lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\04.ExtractIntegersOutput.txt";


        Scanner scanner = new Scanner(new FileInputStream(inPath));
        PrintWriter myFileOutPut = new PrintWriter(new FileOutputStream(outPath));

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                int myNumber = scanner.nextInt();
                myFileOutPut.println(myNumber);
            }
            scanner.next();
        }
        myFileOutPut.close();
    }
}
