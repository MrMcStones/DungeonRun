package com.Rasmus.demo;
import static com.Rasmus.demo.Colors.*;

public class Main {
    public static void main(String[] args) {

        Player player = new Player(2, 3,
                3, 50, 50, 1, 5, 0);

        Monster[] monsters = new Monster[]{
                new Monster(CYAN + "Thrall", 1, 1, 5, 5, 1),
                new Monster(PURPLE + "Dragon", 10, 8, 80, 80, 5),
                new Monster(BLUE + "Sorcerer", 3, 3, 30, 30, 3),
                new Monster(RED + "Gremlin", 1, 5, 15, 15, 2),
                new Monster(GREEN + "Zombie", 3, 1, 10, 10, 2)
        };

        Game game = new Game(player, monsters);
        Shop shop = new Shop(player);
        game.start();

    }
}