package L04FilesAndStreams;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Exercise_P04CountCharacterTypes {
    public static void main(String[] args) {


        String inPath = "D:\\Работни\\IT_\\SoftUni\\JavaAdvanced\\src\\L07FilesAndStreams\\Resources\\input.txt";


        try {
            List<String> allLine = Files.readAllLines(Paths.get(inPath));

            int vowelsCount = 0;
            int punctCount = 0;
            int consonantsCount = 0;

            Set<Character> vowels = getVowels();
            Set<Character> punctMarks = getPunkMarks();

            for (String line : allLine) {
                for (int index = 0; index < line.length(); index++) {
                    char currentSymbol = line.charAt(index);

                    if (currentSymbol == ' ') {
                        continue;
                    }

                    if (vowels.contains(currentSymbol)) {
                        vowelsCount++;
                    } else if (punctMarks.contains(currentSymbol)) {
                        punctCount++;
                    } else {
                        consonantsCount++;
                    }
                }

            }
            BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\Работни\\IT_\\SoftUni\\JavaAdvanced\\src\\L07FilesAndStreams\\outputCountChar.txt"));
            writer.write("Vowels: " + vowelsCount);
            writer.newLine();
            writer.write("Consonants: " + consonantsCount);
            writer.newLine();
            writer.write("Punctuation: " + punctCount);
            writer.close();

        } catch (IOException e) {
            System.out.println("Error");
        }


    }

    private static Set<Character> getPunkMarks() {
        Set<Character> marks = new HashSet<>();
        marks.add('!');
        marks.add('?');
        marks.add('.');
        marks.add(',');
        return marks;
    }

    private static Set<Character> getVowels() {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        return vowels;
    }
}
