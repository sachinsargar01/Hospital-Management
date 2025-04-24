package service;

import model.Bill;
import util.DBConnection;
import java.sql.*;
import java.util.Scanner;

public class BillingService {

    public void generateBill() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter patient ID: ");
        int patientId = sc.nextInt();
        System.out.print("Enter amount: ₹");
        double amount = sc.nextDouble();
        sc.nextLine();

        String sql = "INSERT INTO bills (patient_id, amount, billing_date) VALUES (?, ?, CURDATE())";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, patientId);
            stmt.setDouble(2, amount);

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Bill generated successfully.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewAllBills() {
        String sql = "SELECT * FROM bills";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Bill bill = new Bill(
                        rs.getInt("id"),
                        rs.getInt("patient_id"),
                        rs.getDouble("amount"),
                        rs.getDate("billing_date").toString()
                );
                System.out.println(bill);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
