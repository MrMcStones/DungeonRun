package com.Rasmus.demo;

import static com.Rasmus.demo.Game.random;

public class Monster implements ICharacter {
    private String name;
    private int strength;
    private int agility;
    private int fullHealth;
    private int currentHealth;
    private int baseDamage;

    public Monster(String name, int strength, int agility, int fullHealth, int currentHealth, int baseDamage) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.fullHealth = fullHealth;
        this.currentHealth = currentHealth;
        this.baseDamage = baseDamage;
    }

    public int calculateDamage() {
        return (getBaseDamage() + random.nextInt(getStrength()));
    }

    public int attack(Player player) {
        int monsterDamage = calculateDamage();
        if (player.didDodge(getAgility())) {
            System.out.println("You dodged the attack!");
            return 0;
        } else {
            player.takeDamage(monsterDamage);
            return monsterDamage;
        }
    }

    public void takeDamage(int damage) {
        currentHealth -= damage;
        if (currentHealth < 0) {
            currentHealth = 0;
        }
    }

    public void getStatus() {
        System.out.printf("%sMonster: %s %n", Colors.GREEN_BOLD, name);
        System.out.printf("\n%sHealth: %s%d/%d %n", Colors.RED_BOLD, Colors.RED, currentHealth, fullHealth);
        System.out.printf("%sBaseDamage: %s%d %n", Colors.PURPLE_BOLD, Colors.PURPLE, baseDamage);
        System.out.printf("\n%sStrength: %s%d %n", Colors.RED_BOLD, Colors.RED, strength);
        System.out.printf("%sAgility: %s%d %n%n", Colors.YELLOW_BOLD, Colors.YELLOW, agility);
        System.out.println();
    }

    public boolean isAlive() {
        return fullHealth > 0;
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

    public int getBaseDamage() {
        return baseDamage;
    }

    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }
}
