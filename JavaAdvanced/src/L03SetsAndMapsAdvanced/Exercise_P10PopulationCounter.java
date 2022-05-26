package L03SetsAndMapsAdvanced;

import java.util.*;

public class Exercise_P10PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String,Map<String,Double>> countryMap = new LinkedHashMap<>();
        Map<String,Double> citiesMap = new TreeMap<>();
        while (!input.equals("report")) {
            String[] dataArr = input.split("\\|");
            String city = dataArr[0];
            String country = dataArr[1];
            double population = Double.parseDouble(dataArr[2]);
            if (!countryMap.containsKey(country)) {
                citiesMap.put(city,population);
                countryMap.put(country,citiesMap);
            } else {
                Map<String,Double> currentCountry = countryMap.get(country);
                currentCountry.put(city,population);
                countryMap.put(country,currentCountry);
            }

            input = scanner.nextLine();
        }



        //ToDo Print
        //Bulgaria (total population: 1000000)
        //=>Sofia: 1000000
    }
}
