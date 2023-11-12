package com.Rasmus.demo;

public class Main {
    public static void main(String[] args) {

        Player player = new Player(5, 5,
                5, 50, 100, 1, 50);

        Monster[] monsters = new Monster[]{
                new Monster("Thrall", 2, 10, 10, 10, 5),
                new Monster("Dragon", 10, 10, 100, 100, 5),
                new Monster("Sorcerer", 6, 10, 30, 30, 5)
        };

        Game game = new Game(player, monsters);
        game.start();

        }
    }

// TODO
/*
Klasser:
Följande klasser ska finnas med i spelet
Godkänt:
• Player
• Monster
• ICombat (Interface) (Eller abstrakt klass)
• Enhetstester
Väl Godkänt:
• Shop
• Weapon
• WriteScoreFile
• Färger
• Felhantering
• Fördjupande Enhetstester
 */
