package com.Rasmus.demo;

import java.util.Random;
import java.util.Scanner;

public class Game {
    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    Player player;
    Monster[] monsters;

    public Game(Player player, Monster[] monsters) {
        this.player = player;
        this.monsters = monsters;
    }

    public void start() {
        System.out.println("Welcome to the DungeonRun!");
        System.out.println("What is your name?");
        player.setName(sc.nextLine());
        System.out.println("Nice to meet you " + player.getName() + ", good luck on your adventure!");

        boolean quit = false;
        do {
            System.out.println("""
                    What would you like to do?
                    
                    1. Look for an encounter
                    2. Check your status
                    3. Exit Game
                    """);

            switch (sc.nextLine()) {
                case "1" : fightMenu(player);
                case "2" : player.getStatus();
                break;
                case "3" : quit = true;

                default:
                    System.out.println("Invalid choice. Select a valid option.");
            }
        } while (!quit);
        System.out.println("Thanks for playing!");
        sc.close();
    }

    public void fightMenu(Player player) {

        Monster monster = monsters[new Random().nextInt(monsters.length)];
        System.out.println("You encountered a " + monster.getName());
        System.out.println("Health: " + monster.getFullHealth());
        System.out.println();

        do {
            System.out.println("""
                    1. Battle
                    2. Flee
                    3. Check your status
                    4. Check opponents status
                    """);

            switch (sc.nextLine()) {
                case "1" -> battle(player, monster);
                case "2" -> player.flee();
                case "3" -> player.getStatus();
                case "4" -> monster.getStatus();

                default -> System.out.println("Invalid choice. Select a valid option.");
            }
        } while (player.isAlive() && monster.isAlive());

    }

    public void battle(Player player, Monster monster) {
        System.out.println("Inside Battle");

        int playerDamage = player.calculateDamage();

        System.out.println("You attacked the: " + monster.getName() + " for " + playerDamage
                + " damage!");
        monster.takeDamage(player.calculateDamage());
        System.out.println(monster.getName() + " remaining health: " + monster.getCurrentHealth());

        int monsterDamage = monster.attack(player);

        if (monster.getCurrentHealth() > 0) {

            player.takeDamage(monster.calculateDamage());
            System.out.println("You took " + monsterDamage + " damage!");
            System.out.println(player.getName() + " remaining health: " + player.getCurrentHealth());
            System.out.println();
        } else {
            System.out.println("You slayed the " + monster.getName());
            player.gainedExp(random.nextInt(monster.getFullHealth()));
            System.out.println();
            fightMenu(player);
        }

        if (player.getCurrentHealth() <= 0) {
            player.lose();
            System.out.println("You died...");
            System.out.println("""
                    1. Restart with a new encounter and full health
                    2. Exit game
                    """);

            switch (sc.nextLine()) {
                case "1" -> reset();
                case "2" -> System.exit(0);
            }
        }

    }

    public void reset() {
        player.fullHeal();
        fightMenu(player);
    }
}
