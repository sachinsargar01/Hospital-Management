package service;

import model.Staff;
import util.DBConnection;

import java.sql.*;
import java.util.Scanner;

public class StaffService {

    public void addStaff() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter role (e.g., Doctor, Nurse): ");
        String role = sc.nextLine();
        System.out.print("Enter department (e.g., Cardiology, Neurology): ");
        String department = sc.nextLine();
        System.out.print("Enter contact: ");
        String contact = sc.nextLine();

        String sql = "INSERT INTO staff (name, role, department, contact) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setString(2, role);
            stmt.setString(3, department);
            stmt.setString(4, contact);
            int rows = stmt.executeUpdate();

            if (rows > 0) {
                System.out.println("✅ Staff member added successfully.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewStaff() {
        String sql = "SELECT * FROM staff";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Staff staff = new Staff(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("role"),
                        rs.getString("department"),
                        rs.getString("contact")
                );
                System.out.println(staff);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
