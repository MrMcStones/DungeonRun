package com.Rasmus.demo;

public class Main {
    public static void main(String[] args) {

        Player player = new Player(5, 5,
                5, 50, 50, 1, 5);

        Monster[] monsters = new Monster[]{
                new Monster("Thrall", 2, 10, 10, 2),
                new Monster("Dragon", 10, 100, 100, 20),
                new Monster("Sorcerer", 6, 30, 30, 4)
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
