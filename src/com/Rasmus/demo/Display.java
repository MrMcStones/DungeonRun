package com.Rasmus.demo;

import static com.Rasmus.demo.Colors.*;

public class Display {

    public static void startMenu(Player player) {
        System.out.println(YELLOW + "What would you like to do?" + GREEN +
                """
                
                1. Look for an encounter
                2. Check your status
                3. Go to the shop
                4. Exit Game
                """ + YELLOW);
    }
    public static void fightMenu(Player player) {
        System.out.println("What would you like to do " + GREEN + player.getName() + YELLOW + "?" + GREEN);
        System.out.println("""
                        1. Fight
                        2. Flee
                        3. Check your status
                        4. Check opponents status
                        5. Go to the shop
                        6. Exit game
                        """);
    }

    public static void playerDied() {
        System.out.println(PURPLE_BOLD + "You died...");
        System.out.println("""
                    1. Restart with a new encounter and full health
                    2. Exit game
                    """);
    }
}