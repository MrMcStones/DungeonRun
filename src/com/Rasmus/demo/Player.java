package com.Rasmus.demo;

import java.util.Random;

public class Player implements ICombat {
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
        return getBaseDamage() + (getStrength() * 2 / 4 + 1);
    }

    public boolean didDodge() {
        int agility = getAgility();
        int randomValue = new Random().nextInt(10);
        return randomValue < agility;
    }

    public void takeDamage(int damage) {
        currentHealth -= damage;
        if (currentHealth < 0 ) {
            currentHealth = 0;
        }
    }

    public void flee(Monster monster) {
        Random random = new Random();
        int successChance = getAgility();
        int failChance = monster.getAgility();

        if (random.nextInt(failChance) < successChance) {
            System.out.println("You got away safely!");
        } else {
            int monsterDamage = monster.calculateDamage();
            takeDamage(monsterDamage);

            System.out.println("You could not escape...");
            System.out.println("You took " + monsterDamage + " damage!");
            System.out.println("Health: " + getCurrentHealth() + "/" + getFullHealth());
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
            setIntelligence(getIntelligence() + 2);
            setAgility(getAgility() + 2);
            setStrength(getStrength() + 2);
            setBaseDamage(getBaseDamage() + 2);
            System.out.println("You leveled up!");
    }

    public void gainedExp(int exp) {
        this.experience += exp;
        if (experience >= 10) {
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