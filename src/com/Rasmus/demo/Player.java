package com.Rasmus.demo;

import java.util.Random;

public class Player {
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
        return getBaseDamage() + getStrength();
    }

    public boolean didDodge() {
        int agility = getAgility();
        int randomValue = new Random().nextInt(50);
        return randomValue < agility;
    }

    public void flee() {
        Random random = new Random();
        setAgility(getAgility());
        int successChance = getAgility();

        if (random.nextInt(100) < successChance) {
            System.out.println("You got away safely!");
        } else {
            takeDamage(20);
            System.out.println("You could not escape...");
        }
    }

    public boolean isAlive() {
        return this.fullHealth > 0;
    }

    public boolean lose() {
        return this.currentHealth <= 0;
    }

    private void levelUp() {
        setLevel(getLevel() + 1);
        setExperience(getExperience() - 1);
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
        if (this.experience >= 10) {
            levelUp();
        }
    }

    public void fullHeal() {
        this.currentHealth = this.fullHealth;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return this.strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getIntelligence() {
        return this.intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getAgility() {
        return this.agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getFullHealth() {
        return this.fullHealth;
    }

    public void setFullHealth(int fullHealth) {
        this.fullHealth = fullHealth;
    }

    public int getCurrentHealth() {
        return this.currentHealth;
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
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getBaseDamage() {
        return this.baseDamage;
    }

    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }

    public void takeDamage(int damage) {
        this.currentHealth -= damage;
        if (this.currentHealth < 0 ) {
            this.currentHealth = 0;
        }
    }

    public void calculateExpToLvl(int amountOfExp) {
        for (int i = amountOfExp; i > 0; i--) {
            setExperience(getExperience() + 1);

            if (getExperience() == 100) {
                setLevel(getLevel() + 1);
                setExperience(0);
            }
        }
    }

    public void getStatus() {
        System.out.printf("Character Name: %s %n", this.name);
        System.out.printf("Level: %d %n", this.level);
        System.out.printf("Experience: %d %n", this.experience);
        System.out.printf("\nHealth: %d %n", this.fullHealth);
        System.out.printf("BaseDamage: %d %n", this.baseDamage);
        System.out.printf("\nStrength: %d %n", this.strength);
        System.out.printf("Intelligence: %d %n", this.intelligence);
        System.out.printf("Agility: %d %n", this.agility);
        System.out.println();
    }

}