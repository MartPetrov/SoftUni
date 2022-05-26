package L04FilesAndStreams;

import java.io.File;


public class Exercise_P08GetFolderSize {
    public static void main(String[] args) {

        String pathToFolder = "D:\\Работни\\IT_\\SoftUni\\JavaAdvanced\\src\\L07FilesAndStreams\\Resources\\Exercises Resources";
        File folder = new File(pathToFolder);

        File[] allFiles = folder.listFiles();
        int folderSize = 0;
        assert allFiles != null;
        for (File file : allFiles) {
            folderSize += file.length();
        }

        System.out.println("Folder size: " + folderSize);
    }
}
