package P28TextProcessingExercise;

import java.util.Scanner;

public class P03ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fullPath = scanner.nextLine();
        String[] pathParts = fullPath.split("\\\\");

        String fullFileName = pathParts[pathParts.length -1];
        String fileName = fullFileName.split("\\.")[0];
                String extension = fullFileName.split("\\.")[1];
        System.out.printf("File name: %s%n", fileName);
        System.out.printf("File extension: %s", extension);
    }
}
