package ExamPrep.P01;

import java.util.*;

public class P01Blacksmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] steelArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] carbonArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> steel = new ArrayDeque<>();
        for (int i = 0; i < steelArr.length; i++) {
            steel.offer(steelArr[i]);
        }


        ArrayDeque<Integer> carbon = new ArrayDeque<>();
        for (int i = 0; i < carbonArr.length; i++) {
            carbon.push(carbonArr[i]);
        }

        Map<String, Integer> swordMap = new TreeMap<>();
        swordMap.put("Gladius", 0);
        swordMap.put("Shamshir", 0);
        swordMap.put("Katana", 0);
        swordMap.put("Sabre", 0);


        int countSword = 0;
        while (!steel.isEmpty() && !carbon.isEmpty()) {
            int currentSteel = steel.pop();
            int currentCarbon = carbon.poll();
            int currentSum = currentSteel + currentCarbon;

            // Gladius	70
            //Shamshir	80
            //Katana	90
            //Sabre	110
            if (currentSum == 70) {
                int currentGladius = swordMap.get("Gladius");
                swordMap.put("Gladius", currentGladius + 1);
                countSword++;
            } else if (currentSum == 80) {
                int currentShamshir = swordMap.get("Shamshir");
                swordMap.put("Shamshir", currentShamshir + 1);
                countSword++;
            } else if (currentSum == 90) {
                int currentKatana = swordMap.get("Katana");
                swordMap.put("Katana", currentKatana + 1);
                countSword++;
            } else if (currentSum == 110) {
                int currentSabre = swordMap.get("Sabre");
                swordMap.put("Sabre", currentSabre + 1);
                countSword++;
            } else {
                carbon.push(currentCarbon + 5);
            }

        }

        if (countSword != 0) {
            System.out.printf("You have forged %d swords.%n", countSword);
        } else {
            System.out.println("You did not have enough resources to forge a sword.");
        }

        if (!steel.isEmpty()) {
            System.out.print("Steel left: ");
            for (Integer integer : steel) {
                System.out.print(integer.toString());
                steel.pop();
                if (!steel.isEmpty()) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        } else {
            System.out.println("Steel left: none");
        }
        if (!carbon.isEmpty()) {
            System.out.print("Carbon left: ");
            for (Integer integer : carbon) {
                System.out.print(integer.toString());
                carbon.poll();
                if (!carbon.isEmpty()) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        } else {
            System.out.println("Carbon left: none");
        }

        for (Map.Entry<String,Integer> entry: swordMap.entrySet()) {
            if (entry.getValue() != 0) {
                System.out.printf("%s: %d%n", entry.getKey(),entry.getValue());
            }
        }
    }
}