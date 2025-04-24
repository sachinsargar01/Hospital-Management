package service;

import model.Appointment;
import util.DBConnection;
import java.sql.*;
import java.util.Scanner;

public class AppointmentService {

    public void bookAppointment() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter patient ID: ");
        int patientId = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter doctor name: ");
        String doctor = sc.nextLine();
        System.out.print("Enter appointment date (YYYY-MM-DD): ");
        String date = sc.nextLine();
        System.out.print("Enter appointment time (HH:MM:SS): ");
        String time = sc.nextLine();

        String sql = "INSERT INTO appointments (patient_id, doctor_name, appointment_date, appointment_time) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, patientId);
            stmt.setString(2, doctor);
            stmt.setDate(3, Date.valueOf(date));
            stmt.setTime(4, Time.valueOf(time));

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Appointment booked successfully.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewAppointments() {
        String sql = "SELECT * FROM appointments";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Appointment appt = new Appointment(
                        rs.getInt("id"),
                        rs.getInt("patient_id"),
                        rs.getString("doctor_name"),
                        rs.getDate("appointment_date"),
                        rs.getTime("appointment_time")
                );
                System.out.println(appt);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
