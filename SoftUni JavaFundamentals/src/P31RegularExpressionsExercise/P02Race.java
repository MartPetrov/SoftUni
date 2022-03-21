package P31RegularExpressionsExercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class P02Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> racers = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        Map<String, Integer> racersDistances = new LinkedHashMap<>();
        //име на състезателя -> измината дистанция;
        racers.forEach(racer -> racersDistances.put(racer, 0));
        String input = scanner.nextLine();

        String regexForName = "[A-Za-z+]";
        Pattern patternLetter = Pattern.compile(regexForName);

        String regexForDigit = "[0-9]";
        Pattern patternForDigit = Pattern.compile(regexForDigit);

        while (!input.equals("end of race")) {
            StringBuilder nameBuilder = new StringBuilder();

            Matcher matcherForName = patternLetter.matcher(input);
            while (matcherForName.find()){
                nameBuilder.append(matcherForName.group());
            }
            Matcher matcherForDistance = patternForDigit.matcher(input);
            int distance = 0;
            while (matcherForDistance.find()) {
                distance += Integer.parseInt(matcherForDistance.group());
            }
            String racerName = nameBuilder.toString();
            if (racersDistances.containsKey(racerName)) {
                int currentDistance = racersDistances.get(racerName);
                racersDistances.put(racerName,currentDistance + distance);
            }
            input = scanner.nextLine();
        }
//        Map<String, Integer> firstThreeRacers = racersDistances.entrySet().stream().sorted
//                (Map.Entry.comparingByValue(Comparator.reverseOrder()))
//                .limit(3).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
//                        (a1, a2) -> a1, LinkedHashMap::new));


        List<String> firstThreeNames = racersDistances.entrySet().stream().sorted
                (Map.Entry.comparingByValue(Comparator.reverseOrder()))
               .limit(3).map(entry -> entry.getKey()).collect(Collectors.toList());

        System.out.println("1st place: " + firstThreeNames.get(0));
        System.out.println("2nd place: " + firstThreeNames.get(1));
        System.out.println("3rd place: " + firstThreeNames.get(2));

    }
}
