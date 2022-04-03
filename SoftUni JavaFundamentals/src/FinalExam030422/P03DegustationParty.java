package FinalExam030422;

import java.util.*;

public class P03DegustationParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Map<String, Guest> guestMap = new LinkedHashMap<>();
        int dislikeMeal = 0;
        boolean isCommand = false;
        while (!line.equals("Stop")) {
            isCommand = true;
            String[] commandArr = line.split("-");
            switch (commandArr[0]) {
                case "Like":
                    String currentGuestLike = commandArr[1];
                    String currentMealLike = commandArr[2];
                    like(guestMap, currentGuestLike, currentMealLike);
                    break;
                case "Dislike":
                    String currentGuestDislike = commandArr[1];
                    String currentMealDislike = commandArr[2];
                    dislike(guestMap, currentGuestDislike, currentMealDislike);
                    break;
            }

            line = scanner.nextLine();
        }

        for (Guest guest : guestMap.values()) {
            System.out.println(guest + String.join(", ",guest.getMeals()));
            dislikeMeal += guest.getDislikeMeal();
        }
        if (isCommand){
            System.out.printf("Unliked meals: %d", dislikeMeal);
        }

    }

    private static void like(Map<String, Guest> guestMap, String currentGuestLike, String currentMealLike) {
        if (guestMap.containsKey(currentGuestLike)) {
            Guest guest = guestMap.get(currentGuestLike);
            if (!guest.getMeals().contains(currentMealLike)) {
                guest.getMeals().add(currentMealLike);
            }
        } else {
            Guest guest = new Guest(currentGuestLike, new LinkedList<>(),0);
            guestMap.put(currentGuestLike, guest);
            guest.getMeals().add(currentMealLike);
        }
    }

    private static void dislike(Map<String, Guest> guestMap, String currentGuestDislike, String currentMealDislike) {
        Guest guest = guestMap.get(currentGuestDislike);
        if (guestMap.containsKey(currentGuestDislike)) {
            if (!guest.getMeals().contains(currentMealDislike)) {
                System.out.printf("%s doesn't have the %s in his/her collection.%n", guest.getGuestName(), currentMealDislike);
            } else {
                guest.setDislikeMeal(guest.getDislikeMeal() + 1);
                guest.getMeals().remove(currentMealDislike);
                System.out.printf("%s doesn't like the %s.%n", guest.getGuestName(), currentMealDislike);
            }
        } else {
            System.out.printf("%s is not at the party.%n", currentGuestDislike);
        }
    }

    public static class Guest {
        String guestName;
        List<String> meals;
        int dislikeMeal;

        public Guest(String guestName, List<String> meals, int dislikeMeal) {
            this.guestName = guestName;
            this.meals = meals;
            this.dislikeMeal = dislikeMeal;
        }


        @Override
        public String toString() {
            return String.format("%s: ", getGuestName());
        }

        public String getGuestName() {
            return guestName;
        }

        public void setGuestName(String guestName) {
            this.guestName = guestName;
        }

        public List<String> getMeals() {
            return meals;
        }

        public void setMeals(List<String> meals) {
            this.meals = meals;
        }

        public int getDislikeMeal() {
            return dislikeMeal;
        }

        public void setDislikeMeal(int dislikeMeal) {
            this.dislikeMeal = dislikeMeal;
        }
    }
}
