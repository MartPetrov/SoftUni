package Exam04;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P03HeroesOfCodeAndLogicVII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numbersOfHero = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> heroHpMap = new LinkedHashMap<>();
        Map<String, Integer> heroManaMap = new LinkedHashMap<>();

        for (int i = 0; i < numbersOfHero; i++) {
            String[] input = scanner.nextLine().split(" ");
            String heroName = input[0];
            int hp = Integer.parseInt(input[1]);
            if (hp > 100) {
                hp = 100;
            }
            int mana = Integer.parseInt(input[2]);
            if (mana > 200) {
                mana = 200;
            }
            heroHpMap.put(heroName, hp);
            heroManaMap.put(heroName, mana);
        }

        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] commandArr = command.split(" - ");
            String heroName = commandArr[1];
            switch (commandArr[0]) {
                case "CastSpell":
                    int neededMana = Integer.parseInt(commandArr[2]);
                    String spellName = commandArr[3];
                    int currentMana = heroManaMap.get(heroName);
                    if (currentMana >= neededMana) {
                        heroManaMap.put(heroName, currentMana - neededMana);
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n", heroName, spellName, currentMana - neededMana);
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spellName);
                    }
                    break;
                case "TakeDamage":
                    int damage = Integer.parseInt(commandArr[2]);
                    String attacker = commandArr[3];
                    int currentHp = heroHpMap.get(heroName);
                    heroHpMap.put(heroName, currentHp - damage);
                    int currentHpCheck = heroHpMap.get(heroName);
                    if (currentHpCheck <= 0) {
                        heroHpMap.remove(heroName);
                        heroManaMap.remove(heroName);
                        System.out.printf("%s has been killed by %s!%n", heroName, attacker);
                    } else {
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", heroName, damage, attacker, currentHpCheck);
                    }
                    break;
                case "Recharge":
                    int rechargeMana = Integer.parseInt(commandArr[2]);
                    int currentManaForRecharge = heroManaMap.get(heroName);
                    heroManaMap.put(heroName, currentManaForRecharge + rechargeMana);
                    int currentManaForRechargeCheck = heroManaMap.get(heroName);
                    int howRecharge = 0;
                    if (currentManaForRechargeCheck > 200) {
                        heroManaMap.put(heroName, 200);
                        howRecharge = 200 - currentManaForRecharge;
                    } else {
                        howRecharge = rechargeMana;
                    }
                    System.out.printf("%s recharged for %d MP!%n", heroName, howRecharge);
                    break;
                case "Heal":
                    int rechargeHealth = Integer.parseInt(commandArr[2]);
                    int currentHealthForRecharge = heroHpMap.get(heroName);
                    heroHpMap.put(heroName, currentHealthForRecharge + rechargeHealth);
                    int currentHealForRechargeCheck = heroHpMap.get(heroName);
                    int howHealth = 0;
                    if (currentHealForRechargeCheck > 100) {
                        heroHpMap.replace(heroName,currentHealForRechargeCheck,100);
                        howHealth = 100 - currentHealthForRecharge;
                    } else {
                        howHealth = rechargeHealth;
                    }
                    System.out.printf("%s healed for %s HP!%n", heroName, howHealth);
                    break;

            }
            command = scanner.nextLine();
        }

        for (Map.Entry<String, Integer> entry : heroHpMap.entrySet()) {
            System.out.printf("%s%n  HP: %d%n  MP: %d%n", entry.getKey(), entry.getValue(), heroManaMap.get(entry.getKey()));
        }
    }
}
