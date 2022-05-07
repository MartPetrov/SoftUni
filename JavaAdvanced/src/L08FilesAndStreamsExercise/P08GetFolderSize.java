package L08FilesAndStreamsExercise;

import java.io.File;


public class P08GetFolderSize {
    public static void main(String[] args) {

        String pathToFolder = "D:\\Работни\\IT_\\SoftUni\\JavaAdvanced\\src\\L08FilesAndStreamsExercise\\Resources\\Exercises Resources";
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
