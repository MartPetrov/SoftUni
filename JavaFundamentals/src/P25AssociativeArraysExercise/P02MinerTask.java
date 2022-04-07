package P25AssociativeArraysExercise;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P02MinerTask {

    public static void main(String[] args) {
        Map<String, Long> resources  = new LinkedHashMap<>();
        String resource = " ";
        Scanner scanner = new Scanner(System.in);
        while (!resource.equals("stop"))
        {

            resource = scanner.nextLine();
            if (!resource.equals("stop"))
            {
                long quantity = Integer.parseInt(scanner.nextLine());
                if (!resources.containsKey(resource))
                {
                    resources.put(resource, quantity);
                }
                else
                {
                    long val = resources.get(resource);
                    resources.put(resource, val += quantity);
                }
            }
        }
        for (Map.Entry<String, Long> entry : resources.entrySet()) {
            String key = entry.getKey();
            Long value = entry.getValue();
            System.out.println(key + " -> " + value);
        }
    }
}