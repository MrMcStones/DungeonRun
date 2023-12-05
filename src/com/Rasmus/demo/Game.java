package com.Rasmus.demo;

import static com.Rasmus.demo.Colors.*;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Game {
    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    Player player;
    Monster[] monsters;
    private Shop shop;

    public Game(Player player, Monster[] monsters) {
        this.player = player;
        this.monsters = monsters;
        this.shop = new Shop(player);
    }

    public void start() {
        System.out.println(YELLOW + "Welcome to the DungeonRun!");
        System.out.println("What is your name?");
        player.setName(sc.nextLine());
        System.out.println("Nice to meet you " + GREEN + player.getName() + YELLOW + ", good luck on your adventure!");

        boolean quit = false;
        do {
            Display.startMenu(player);

            String choice = sc.nextLine();
            switch (choice) {
                case "1" -> fightMenu(player);
                case "2" -> player.getStatus();
                case "3" -> shop.shopMenu();
                case "4" -> quit = true;

                default ->
                    System.out.println(RED + "Invalid choice. Type in your choice with the corresponding number." + YELLOW);
            }
        } while (!quit);
        exitGame();
    }

    public void fightMenu(Player player) {
        do {
            Monster monster = monsters[new Random().nextInt(monsters.length)];
            monster.setCurrentHealth(monster.getFullHealth());
            System.out.println(YELLOW + "You have encountered a " + monster.getName());
            System.out.println(RED + "Health: " + monster.getCurrentHealth() + "/" + monster.getFullHealth() + YELLOW);
            System.out.println();

            do {
                Display.fightMenu(player);

                switch (sc.nextLine()) {
                    case "1" -> battle(player, monster);
                    case "2" -> {
                        if (player.flee(monster)) {
                            fightMenu(player);
                        }
                    }
                    case "3" -> player.getStatus();
                    case "4" -> monster.getStatus();
                    case "5" -> shop.shopMenu();
                    case "6" -> exitGame();

                    default -> System.out.println(RED + "Invalid choice. Type in your choice with the corresponding number." + YELLOW);
                }
            } while (player.isAlive() && monster.isAlive());
        } while (player.isAlive());
    }

    public void battle(Player player, Monster monster) {
        System.out.println(YELLOW_UNDERLINED + "Inside Battle" + YELLOW);

        int playerDamage = player.calculateDamage();

        System.out.println(YELLOW + "You attacked the: " + RED + monster.getName() + YELLOW + " for " + playerDamage
                + " damage!");
        monster.takeDamage(playerDamage);
        System.out.println(RED + monster.getName() + YELLOW + " remaining health: " + monster.getCurrentHealth());

        if (monster.getCurrentHealth() >= 1) {
            int monsterDamage = monster.attack(player, player.getEquippedArmor());
            System.out.println("You took " + monsterDamage + " damage!");
            System.out.println(GREEN + player.getName() + YELLOW + " remaining health: " + player.getCurrentHealth());
            System.out.println();
        } else {
            System.out.println("You slayed the " + RED + monster.getName());
            player.gainedExp(random.nextInt(monster.getFullHealth()));
            player.gainedCurrency();
            player.addMonstersKilled(monster);
            System.out.println();
            fightMenu(player);
        }

        if (player.getCurrentHealth() <= 0) {
            death();
        }
    }

    public void death() {
        Display.playerDied();
        String choice = sc.nextLine();
        switch (choice) {
            case "1" -> reset();
            case "2" -> exitGame();

            default -> System.out.println(RED + "Invalid choice. Type in your choice with the corresponding number." + YELLOW);
        }
    }

    public void reset() {
        player.fullHeal();
        fightMenu(player);
    }

    public void exitGame() {
        System.out.println(YELLOW + "Thank you for playing!");
        try {
            ScoreFile.writeScoreFile(player);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.exit(0);
    }
}