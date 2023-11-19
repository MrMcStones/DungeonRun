package com.Rasmus.demo;

import static com.Rasmus.demo.Colors.*;

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
        System.out.println(YELLOW + "Welcome to the DungeonRun!");
        System.out.println("What is your name?");
        player.setName(sc.nextLine());
        System.out.println("Nice to meet you " + GREEN + player.getName() + YELLOW + ", good luck on your adventure!");

        boolean quit = false;
        do {
            System.out.println("What would you like to do?" + GREEN +
                    """
                    
                    1. Look for an encounter
                    2. Check your status
                    3. Exit Game
                    """ + YELLOW);

            String choice = sc.nextLine();
            switch (choice) {
                case "1" -> fightMenu(player);
                case "2" -> player.getStatus();
                case "3" -> quit = true;

                default ->
                    System.out.println(RED + "Invalid choice. Type in your choice with the corresponding number." + YELLOW);
            }
        } while (!quit);
        exitGame();
    }

    public void fightMenu(Player player) {
        do {
            Monster monster = monsters[new Random().nextInt(monsters.length)];
            System.out.println(YELLOW + "You encountered a " + monster.getName());
            System.out.println(RED + "Health: " + monster.getFullHealth() + YELLOW);
            monster.setCurrentHealth(monster.getFullHealth());
            System.out.println();

            do {
                System.out.println("What would you like to do " + GREEN + player.getName() + YELLOW + "?" + GREEN);
                System.out.println("""
                        1. Battle
                        2. Flee
                        3. Check your status
                        4. Check opponents status
                        5. Exit game
                        """);

                switch (sc.nextLine()) {
                    case "1" -> battle(player, monster);
                    case "2" -> {
                        player.flee(monster);
                        if (player.isAlive()) {
                            fightMenu(player);
                        }
                    }
                    case "3" -> player.getStatus();
                    case "4" -> monster.getStatus();
                    case "5" -> exitGame();

                    default -> System.out.println(RED + "Invalid choice. Type in your choice with the corresponding number." + YELLOW);
                }
            } while (player.isAlive() && monster.isAlive());
        } while (player.isAlive());
    }

    public void battle(Player player, Monster monster) {
        System.out.println(YELLOW + "Inside Battle");

        int playerDamage = player.calculateDamage();

        System.out.println("You attacked the: " + RED + monster.getName() + YELLOW + " for " + playerDamage
                + " damage!");
        monster.takeDamage(player.calculateDamage());
        System.out.println(RED + monster.getName() + YELLOW + " remaining health: " + monster.getCurrentHealth());

        if (monster.getCurrentHealth() >= 1) {
            int monsterDamage = monster.attack(player);
            player.takeDamage(monster.calculateDamage());
            System.out.println("You took " + monsterDamage + " damage!");
            System.out.println(player.getName() + " remaining health: " + player.getCurrentHealth());
            System.out.println();
        } else {
            System.out.println("You slayed the " + RED + monster.getName());
            player.gainedExp(random.nextInt(monster.getFullHealth()));
            System.out.println();
            fightMenu(player);
        }

        if (player.getCurrentHealth() <= 0) {
            System.out.println(PURPLE_BOLD + "You died...");
            System.out.println("""
                    1. Restart with a new encounter and full health
                    2. Exit game
                    """);
            String choice = sc.nextLine();
            switch (choice) {
                case "1" -> reset();
                case "2" -> exitGame();

                default -> System.out.println(RED + "Invalid choice. Type in your choice with the corresponding number." + YELLOW);
            }
        }
    }

    public void reset() {
        player.fullHeal();
        fightMenu(player);
    }

    public void exitGame() {
        System.out.println(YELLOW + "Thank you for playing!");
        System.exit(0);
    }
}
