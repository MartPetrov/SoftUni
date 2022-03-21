package P31RegularExpressionsExercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P04StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countMessages =  Integer.parseInt(scanner.nextLine());
        String regex = "@(?<planetName>[A-Za-z]+)[^@!:>-]*:(?<population>\\d+)[^@!:>-]*!(?<attack>[AD])![^@!:>-]*->(?<soldierCount>\\d+)";
        Pattern pattern = Pattern.compile(regex);

        List<String> attackersPlanets = new ArrayList<>();
        List<String> destroyedPlanets = new ArrayList<>();

        for (int messageCount = 1; messageCount <= countMessages; messageCount++) {
            String encryptedMessage = scanner.nextLine();
            String decryptedMessage = getDecryptedMessage (encryptedMessage);
            Matcher matcher = pattern.matcher(decryptedMessage);
            if (matcher.find()) {
                String planetName = matcher.group("planetName");
                int population = Integer.parseInt(matcher.group("population"));
                String attackType = matcher.group("attack"); // A -> atack; D -> destroyed
                int soldierCount = Integer.parseInt(matcher.group("soldierCount"));

                if (attackType.equals("A")) {
                    attackersPlanets.add(planetName);
                } else if (attackType.equals("D")){
                    destroyedPlanets.add(planetName);
                }
            }

        }

        System.out.println("Attacked planets: " + attackersPlanets.size());
        Collections.sort(attackersPlanets);
        attackersPlanets.forEach(planet -> System.out.println("-> " + planet));
        System.out.println("Destroyed planets: " + destroyedPlanets.size());
        Collections.sort(destroyedPlanets);
        destroyedPlanets.forEach(planet -> System.out.println("-> " + planet));
    }

    private static String getDecryptedMessage(String encryptedMessage) {
        //1.Намираме броя на всички букви [s,S,t,T,a,A,r,R] в криптираното съобщение
        int countLetters = getSpecialLetterCount (encryptedMessage);
        StringBuilder  decryptedMessage = new StringBuilder();

        for(char symbol : encryptedMessage.toCharArray()) {
            char newSymbol = (char)(symbol - countLetters);
            decryptedMessage.append(newSymbol);
        }
        return decryptedMessage.toString();
    }

    private static int getSpecialLetterCount(String encryptedMessage) {
        int counter = 0;
        for (char symbol: encryptedMessage.toLowerCase().toCharArray()) {
            if (symbol == 's' || symbol =='a' || symbol =='t' || symbol == 'r') {
                counter++;
            }
        }
        return counter;
    }
}
