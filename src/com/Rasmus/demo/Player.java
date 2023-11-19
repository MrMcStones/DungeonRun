package com.Rasmus.demo;

import java.util.Random;

import static com.Rasmus.demo.Game.random;

public class Player implements ICharacter {
    private String name;
    private int strength;
    private int intelligence;
    private int agility;
    private int fullHealth;
    private int currentHealth;
    private int experience;
    private int level;
    private int baseDamage;

    public Player(int strength, int intelligence, int agility, int fullHealth, int currentHealth, int level, int baseDamage) {
        this.strength = strength;
        this.intelligence = intelligence;
        this.agility = agility;
        this.fullHealth = fullHealth;
        this.currentHealth = currentHealth;
        this.level = level;
        this.baseDamage = baseDamage;
    }

    public int calculateDamage() {
        if (critDamage()) {
            System.out.println("You made a 'critical hit'!");
            return (getBaseDamage() + (getStrength() * 2 / 4 + 1)) *2 + (random.nextInt(6) - 2);
        } else {
            return getBaseDamage() + (getStrength() * 2 / 4 + 1) + (random.nextInt(6) -2);
        }
    }

    public boolean critDamage() {
        int critChance = getIntelligence();
        int randomNumber = random.nextInt(25) + 1;
        return randomNumber <= critChance;
    }

    public boolean didDodge(int monsterAgility) {
        int agility = getAgility();
        int randomValue = new Random().nextInt(10);
        return (randomValue + agility) > (monsterAgility * 2);
    }

    public void takeDamage(int damage) {
        currentHealth -= damage;
        if (currentHealth < 0 ) {
            currentHealth = 0;
        }
    }

    public boolean flee(Monster monster) {
        Random random = new Random();
        int successChance = getAgility();
        int failChance = monster.getAgility();

        if (random.nextInt(failChance) < successChance) {
            System.out.println(Colors.YELLOW + "You got away safely!");
            System.out.println();
            return true;
        } else {
            int monsterDamage = monster.calculateDamage();
            takeDamage(monsterDamage);

            System.out.println(Colors.YELLOW + "You could not escape...");
            System.out.println("You took " + monsterDamage + " damage!");
            System.out.println("Health: " + getCurrentHealth() + "/" + getFullHealth());
            return false;
        }
    }

    public boolean isAlive() {
        return currentHealth > 0;
    }

    private void levelUp() {
            setLevel(getLevel() + 1);
            setExperience(0);
            setFullHealth(getFullHealth() + 10);
            setCurrentHealth(getFullHealth());
            setIntelligence(getIntelligence() + (random.nextInt(3) +1));
            setAgility(getAgility() + (random.nextInt(3) +1));
            setStrength(getStrength() + (random.nextInt(3) +1));
            setBaseDamage(getBaseDamage() + (random.nextInt(3) +1));
            System.out.println("You leveled up!");
    }

    public void gainedExp(int exp) {
        this.experience += exp;
        int levelNeed = 10 + (this.level - 1) * 5;
        if (experience >= levelNeed) {
            levelUp();
        }
    }

    public void fullHeal() {
        currentHealth = fullHealth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getFullHealth() {
        return fullHealth;
    }

    public void setFullHealth(int fullHealth) {
        this.fullHealth = fullHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }

    public void getStatus() {
        System.out.printf("%sCharacter Name: %s %n", Colors.GREEN_BOLD, name);
        System.out.printf("%sLevel: %s%d %n", Colors.CYAN_BOLD, Colors.CYAN, level);
        System.out.printf("%sExperience: %s%d %n", Colors.YELLOW_BOLD, Colors.YELLOW, experience);
        System.out.printf("\n%sHealth: %s%d/%d %n", Colors.RED_BOLD, Colors.RED, currentHealth, fullHealth);
        System.out.printf("%sBaseDamage: %s%d %n", Colors.PURPLE_BOLD, Colors.PURPLE, baseDamage);
        System.out.printf("\n%sStrength: %s%d %n", Colors.RED_BOLD, Colors.RED, strength);
        System.out.printf("%sIntelligence: %s%d %n", Colors.BLUE_BOLD, Colors.BLUE, intelligence);
        System.out.printf("%sAgility: %s%d %n%n", Colors.YELLOW_BOLD, Colors.YELLOW, agility);
    }
}