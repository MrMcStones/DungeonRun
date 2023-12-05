package com.Rasmus.demo.game;

import com.Rasmus.demo.characters.Player;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class ScoreFile {

    public static void writeScoreFile(Player player) throws IOException {
        String fileName = "latest_gameScore.txt";

        try (PrintWriter writer = new PrintWriter((new FileWriter(fileName)))) {
            writer.println("Player name: " + player.getName() +
                    "\nPlayer level: " + player.getLevel() +
                    "\nEquipped weapon: " + player.getEquippedWeapon() +
                    "\nEquipped armor: " + player.getEquippedArmor() +
                    "\nEquipped accessory: " + player.getAccessory() +
                    "\nMonsters killed: " + player.getMonstersKilled());

            Map<String, Integer> monstersKilledMap = player.getMonstersKilledMap();
            writer.println("Monsters killed by type: ");
            for (Map.Entry<String, Integer> entry : monstersKilledMap.entrySet()) {
                String monsterName = entry.getKey();
                int count = entry.getValue();
                writer.println(monsterName + ": " + count);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Could not correctly update game stats...");
            throw e;
        }
    }
}