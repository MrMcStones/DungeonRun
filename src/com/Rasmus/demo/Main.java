package com.Rasmus.demo;
import static com.Rasmus.demo.Colors.*;

public class Main {
    public static void main(String[] args) {

        Player player = new Player(1, 1,
                1, 20, 20, 1, 5);

        Monster[] monsters = new Monster[]{
                new Monster(GREEN + "Thrall", 1, 1, 5, 5, 1),
                new Monster(PURPLE + "Dragon", 10, 10, 100, 100, 5),
                new Monster(BLUE + "Sorcerer", 1, 3, 30, 30, 3)
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

när man möter monster skapas random guld och vid slayed så läggs det till för player.
public interface 'character' - public class player implements icharacter, samma på monster.
sen skapar du tomma metoder i icharacter som takedamage etc. - de funktioner som finns i båda klasser.
då är interface skapat som implementerar båda klasserna.
icharacter är en karta över alla karaktärer oavsett spelare elr monster - de kan ta skada, dö osv.
 */
