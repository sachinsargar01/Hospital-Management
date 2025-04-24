package service;

import model.InventoryItem;
import util.DBConnection;
import java.sql.*;
import java.util.Scanner;

public class InventoryService {

    public void addItem() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter item name: ");
        String name = sc.nextLine();
        System.out.print("Enter quantity: ");
        int qty = sc.nextInt();

        String sql = "INSERT INTO inventory (name, quantity) VALUES (?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setInt(2, qty);

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Inventory item added.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewItems() {
        String sql = "SELECT * FROM inventory";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                InventoryItem item = new InventoryItem(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("quantity")
                );
                System.out.println(item);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
