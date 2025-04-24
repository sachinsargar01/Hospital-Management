package model;

public class InventoryItem {
    private int id;
    private String name;
    private int quantity;

    public InventoryItem(int id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Item ID: " + id + ", Name: " + name + ", Quantity: " + quantity;
    }
}
