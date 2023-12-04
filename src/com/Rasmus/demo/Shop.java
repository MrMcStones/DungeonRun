package com.Rasmus.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.Rasmus.demo.Colors.*;

public class Shop {
    private List<ShopItem> availableItems;
    private Player player;
    Scanner sc = new Scanner(System.in);

    public Shop(Player player) {
        this.availableItems = new ArrayList<>();
        this.player = player;
        initializeShopItems();
    }

    private void initializeShopItems() {
        availableItems.add(new ShopItem("Axe", 8, ItemType.Weapon, "+2 BaseDamage"));
        availableItems.add(new ShopItem("Breastplate", 10, ItemType.Armor, "-2 DamageTaken"));
        availableItems.add(new ShopItem("Ring", 4, ItemType.Ring, "+2 Agility"));
    }

    public void displayItems() {
        System.out.println(YELLOW + "Available items in shop:" + GREEN);
        for (int i = 0; i < availableItems.size(); i++) {
            ShopItem item = availableItems.get(i);
            System.out.println(i + 1 + ". " + item.getName() + " - Price: " + YELLOW + item.getPrice() + " gold" + GREEN);
        }
        System.out.println("4. Exit the shop");
        System.out.println("Your " + YELLOW + "gold: " + player.getCurrency());
    }

    public void shopMenu() {
        while (true) {
            displayItems();
            System.out.println();

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice >= 1 && choice <= availableItems.size()) {
                buyItem(availableItems.get(choice -1));
            } else if (choice == 4) {
                break;
            } else {
                System.out.println(RED + "Invalid choice. Type in your choice with the corresponding number." + YELLOW);
            }
        }
    }

    public void buyItem(ShopItem item) {
        if (player.getCurrency() >= item.getPrice()) {
            if (!item.isPurchased()) {
                player.purchaseItem(item);
                System.out.println("You purchased the " + GREEN + item.getName() + YELLOW + " for " + item.getPrice() + " gold");

                if (!item.isEquipped()) {
                    player.equipItem(item);
                } else {
                    System.out.println(RED + "You already have the " + item.getName() + " equipped." + YELLOW);
                }
            } else {
                System.out.println(RED + item.getName() + " is already purchased." + YELLOW);
            }
        } else {
                    System.out.println(RED + "You don't have enough gold to purchase that item." + YELLOW);
        }
    }
}