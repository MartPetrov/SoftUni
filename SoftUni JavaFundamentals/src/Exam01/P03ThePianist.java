package Exam01;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P03ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfPieces = Integer.parseInt(scanner.nextLine());
        Map<String, String> composerOfPiece = new LinkedHashMap<>();
        Map<String, String> keyOfPiece = new LinkedHashMap<>();
        for (int i = 0; i < numOfPieces; i++) {
            String[] pieces = scanner.nextLine().split("\\|");
            composerOfPiece.put(pieces[0], pieces[1]);
            keyOfPiece.put(pieces[0],pieces[2]);
        }
        String commandLine = scanner.nextLine();
        while (!commandLine.equals("Stop")) {
            String[] command = commandLine.split("\\|");
            switch (command[0]){
                case "Add":
                    String pieceToAdd = command[1];
                    String composerToAdd = command[2];
                    String keyToAdd = command[3];
                    if (!composerOfPiece.containsKey(pieceToAdd)) {
                        composerOfPiece.put(pieceToAdd,composerToAdd);
                        keyOfPiece.put(pieceToAdd,keyToAdd);
                        System.out.printf("%s by %s in %s added to the collection!%n", pieceToAdd,composerToAdd,keyToAdd);
                    } else {
                        System.out.printf("%s is already in the collection!%n", pieceToAdd);
                    }
                    break;
                case "Remove":
                    String pieceToRemove = command[1];
                    if (composerOfPiece.containsKey(pieceToRemove)){
                        composerOfPiece.remove(pieceToRemove);
                        keyOfPiece.remove(pieceToRemove);
                        System.out.printf("Successfully removed %s!%n", pieceToRemove);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", pieceToRemove);
                    }
                    break;
                case "ChangeKey":
                    String pieceToChangeKey = command[1];
                    String newKey = command[2];
                    if (keyOfPiece.containsKey(pieceToChangeKey)){
                        keyOfPiece.replace(pieceToChangeKey,newKey);
                        System.out.printf("Changed the key of %s to %s!%n", pieceToChangeKey, newKey);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n",pieceToChangeKey);
                    }
                    break;
            }
            commandLine = scanner.nextLine();
        }

        composerOfPiece.entrySet().stream().
                forEach(entry -> System.out.printf("%s -> Composer: %s, Key: %s%n",entry.getKey(),entry.getValue(),keyOfPiece.get(entry.getKey())));


    }
}
