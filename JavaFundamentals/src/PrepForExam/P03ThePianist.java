package com.PrepForExam;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P03ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numPiece = Integer.parseInt(scanner.nextLine());
        Map<String, Piece> pieceMap = new LinkedHashMap<>();
        for (int i = 0; i < numPiece; i++) {
            String[] pieceInfo = scanner.nextLine().split("\\|");
            Piece piece = new Piece(pieceInfo[0], pieceInfo[1], pieceInfo[2]);
            pieceMap.put(pieceInfo[0], piece);
        }

        String[] commandArr = scanner.nextLine().split("\\|");
        while (!commandArr[0].equals("Stop")) {
            switch (commandArr[0]) {
                case "Add":
                    String pieceToAdd = commandArr[1];
                    String composerToAdd = commandArr[2];
                    String keyToAdd = commandArr[3];
                    add(pieceMap,pieceToAdd,composerToAdd,keyToAdd);
                    break;
                case "Remove":
                    String pieceToRemove = commandArr[1];
                    remove (pieceMap,pieceToRemove);
                    break;
                case "ChangeKey":
                    String pieceToChangeKey = commandArr[1];
                    String newKey = commandArr[2];
                    changeKey (pieceMap,pieceToChangeKey,newKey);
                    break;
            }

            commandArr = scanner.nextLine().split("\\|");
        }
        for (Piece piece: pieceMap.values()){
            System.out.println(piece);
        }
    }

    private static void add(Map<String, Piece> pieceMap, String pieceToAdd, String composerToAdd, String keyToAdd) {
        if (!pieceMap.containsKey(pieceToAdd)){
            pieceMap.put(pieceToAdd,new Piece(pieceToAdd,composerToAdd,keyToAdd));
            System.out.printf("%s by %s in %s added to the collection!%n", pieceToAdd,composerToAdd,keyToAdd);
        } else {
            System.out.printf("%s is already in the collection!%n", pieceToAdd);
        }
    }

    private static void remove(Map<String, Piece> pieceMap, String pieceToRemove) {
        if (pieceMap.containsKey(pieceToRemove)){
            pieceMap.remove(pieceToRemove);
            System.out.printf("Successfully removed %s!%n",pieceToRemove);
        } else {
            System.out.printf("Invalid operation! %s does not exist in the collection.%n", pieceToRemove);
        }
    }

    private static void changeKey(Map<String, Piece> pieceMap, String pieceToChangeKey, String newKey) {
        Piece currentPiece = pieceMap.get(pieceToChangeKey);
        if (pieceMap.containsKey(pieceToChangeKey)){
            currentPiece.setKey(newKey);
            System.out.printf("Changed the key of %s to %s!%n",pieceToChangeKey,newKey);
        } else {
            System.out.printf("Invalid operation! %s does not exist in the collection.%n", pieceToChangeKey);
        }
    }

    public static class Piece {
        String name;
        String composer;
        String key;

        public Piece(String name, String composer, String key) {
            this.name = name;
            this.composer = composer;
            this.key = key;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getComposer() {
            return composer;
        }

        public void setComposer(String composer) {
            this.composer = composer;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        @Override
        public String toString() {
            return String.format("%s -> Composer: %s, Key: %s", getName(),getComposer(),getKey());
        }
    }
}
