package com.Rasmus.demo;

public class ShopItem {
    private String name;
    private int price;
    private ItemType type;
    private String use;
    private boolean purchased;
    private boolean equipped;

    public ShopItem(String name, int price, ItemType type, String use) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.use = use;
        this.purchased = false;
        this.equipped = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public boolean isPurchased() {
        return purchased;
    }

    public void setPurchased(boolean purchased) {
        this.purchased = purchased;
    }

    public boolean isEquipped() {
        return equipped;
    }

    public void setEquipped(boolean equipped) {
        this.equipped = equipped;
    }
}
