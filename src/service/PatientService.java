package service;

import model.Patient;
import util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientService {

    public void addPatient(String name, int age, String gender, String contact) {
        String sql = "INSERT INTO patients (name, age, gender, contact) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.setString(3, gender);
            stmt.setString(4, contact);

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Patient registered successfully.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewAllPatients() {
        String sql = "SELECT * FROM patients";
        List<Patient> patients = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Patient p = new Patient(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("age"),
                    rs.getString("gender"),
                    rs.getString("contact")
                );
                patients.add(p);
            }

            if (patients.isEmpty()) {
                System.out.println("No patients found.");
            } else {
                for (Patient p : patients) {
                    System.out.println(p);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
