package Exam01For2Time;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P03ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfPiece = Integer.parseInt(scanner.nextLine());
        Map<String, Pieces> piecesMap = new LinkedHashMap<>();
        for (int i = 0; i < numOfPiece; i++) {
            String[] inputPieces = scanner.nextLine().split("\\|");
            String piece = inputPieces[0];
            String composer = inputPieces[1];
            String key = inputPieces[2];
            Pieces pieces = new Pieces(piece, composer, key);
            piecesMap.put(piece, pieces);
        }

        String command = scanner.nextLine();
        while (!command.equals("Stop")) {
            String[] commandArr = command.split("\\|");
            switch (commandArr[0]) {
                case "Add":
                    if (!piecesMap.containsKey(commandArr[1])){
                        Pieces newPieces = new Pieces(commandArr[1],commandArr[2],commandArr[3]);
                        piecesMap.put(commandArr[1],newPieces);
                        System.out.printf("%s by %s in %s added to the collection!%n",commandArr[1],commandArr[2],commandArr[3]);
                    } else {
                        System.out.printf("%s is already in the collection!%n",commandArr[1]);
                    }
                    break;
                case "Remove":
                    if (piecesMap.containsKey(commandArr[1])){
                        piecesMap.remove(commandArr[1]);
                        System.out.printf("Successfully removed %s!%n", commandArr[1]);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", commandArr[1]);
                    }
                    break;
                case "ChangeKey":
                    Pieces currentPiece = piecesMap.get(commandArr[1]);
                    if (piecesMap.containsKey(commandArr[1])){
                        currentPiece.setKey(commandArr[2]);
                        System.out.printf("Changed the key of %s to %s!%n", commandArr[1], commandArr[2]);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", commandArr[1]);
                    }
                    break;
            }

            command = scanner.nextLine();
        }
        for (Pieces pieces: piecesMap.values()){
            System.out.println(pieces);
        }
    }

    public static class Pieces {
        String piece;
        String composer;
        String key;

        public Pieces(String piece, String composer, String key) {
            this.piece = piece;
            this.composer = composer;
            this.key = key;
        }

        public String getPiece() {
            return piece;
        }

        public void setPiece(String piece) {
            this.piece = piece;
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
            return String.format("%s -> Composer: %s, Key: %s",getPiece(),getComposer(),getKey());
        }
    }
}
