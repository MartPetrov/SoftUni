package com.PrepForExam;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P03Heroes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numHeroes = Integer.parseInt(scanner.nextLine());
        Map<String, Hero> heroMap = new LinkedHashMap<>();
        for (int i = 0; i < numHeroes; i++) {
            String[] inputHero = scanner.nextLine().split(" ");
            String name = inputHero[0];
            int healthPoint = Integer.parseInt(inputHero[1]);
            int manaPoint = Integer.parseInt(inputHero[2]);
            Hero hero = new Hero(name, healthPoint, manaPoint);
            heroMap.put(name, hero);
        }

        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] commandArr = command.split(" - ");
            Hero currentHero = heroMap.get(commandArr[1]);
            switch (commandArr[0]) {
                case "CastSpell":
                    int manaNeeded = Integer.parseInt(commandArr[2]);
                    String spellName = commandArr[3];
                    castSpell(currentHero,manaNeeded,spellName);
                    break;
                case "TakeDamage":
                    int damage = Integer.parseInt(commandArr[2]);
                    String attacker = commandArr[3];
                    takeDamage (heroMap,currentHero,damage,attacker);
                    break;
                case "Recharge":
                    int amount = Integer.parseInt(commandArr[2]);
                    recharge(heroMap,currentHero,amount);
                    break;
                case "Heal":
                    int amountHeal = Integer.parseInt(commandArr[2]);
                    heal(heroMap,currentHero,amountHeal);
                    break;
            }
            command = scanner.nextLine();
        }
        for (Hero hero: heroMap.values()){
            System.out.print(hero);
        }
    }

    private static void heal(Map<String, Hero> heroMap, Hero currentHero, int amountHeal) {
        int currentHealth = currentHero.getHealth();
        currentHero.setHealth(Math.min(currentHero.getHealth() + amountHeal, 100));
        System.out.printf("%s healed for %d HP!%n", currentHero.getName(), currentHero.getHealth() - currentHealth);
    }

    private static void recharge(Map<String, Hero> heroMap, Hero currentHero, int amount) {
        int currentMana = currentHero.getMana();
        currentHero.setMana(Math.min(currentHero.getMana() + amount, 200));
        System.out.printf("%s recharged for %d MP!%n", currentHero.getName(), currentHero.getMana() - currentMana);
    }

    private static void takeDamage(Map<String, Hero> heroMap, Hero currentHero, int damage, String attacker) {
        currentHero.setHealth(currentHero.getHealth() - damage);
        if (currentHero.getHealth() > 0) {
            System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", currentHero.getName(), damage, attacker,currentHero.getHealth());
        } else {
            heroMap.remove(currentHero.getName());
            System.out.printf("%s has been killed by %s!%n", currentHero.getName(), attacker);
        }
    }

    private static void castSpell(Hero currentHero, int manaNeeded, String spellName) {
        if (currentHero.getMana() >= manaNeeded) {
            currentHero.setMana(currentHero.getMana() - manaNeeded);
            System.out.printf("%s has successfully cast %s and now has %d MP!%n", currentHero.getName(), spellName, currentHero.getMana());
        } else {
            System.out.printf("%s does not have enough MP to cast %s!%n",currentHero.getName(), spellName);
        }
    }

    public static class Hero {
        String name;
        int health;
        int mana;

        public Hero(String name, int health, int mana) {
            this.name = name;
            this.health = health;
            this.mana = mana;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getHealth() {
            return health;
        }

        public void setHealth(int health) {
            this.health = health;
        }

        public int getMana() {
            return mana;
        }

        public void setMana(int mana) {
            this.mana = mana;
        }

        @Override
        public String toString() {
            return String.format("%s%n" +
                    "  HP: %d%n" +
                    "  MP: %d%n", getName(),getHealth(),getMana());
        }
    }
}
