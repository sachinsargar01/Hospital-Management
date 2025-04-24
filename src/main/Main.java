package main;

import service.PatientService;
import service.AppointmentService;
import service.BillingService;
import service.InventoryService;
import service.StaffService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PatientService ps = new PatientService();
        AppointmentService as = new AppointmentService();
        BillingService bs = new BillingService();
        InventoryService is = new InventoryService();
        StaffService ss = new StaffService(); 

        while (true) {
            System.out.println("\n--- Hospital Management System ---");
            System.out.println("1. Register Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. Book Appointment");
            System.out.println("4. View Appointments");
            System.out.println("5. Generate Bill");
            System.out.println("6. View All Bills");
            System.out.println("7. Add Inventory Item");
            System.out.println("8. View Inventory");
            System.out.println("9. Add Staff"); 
            System.out.println("10. View Staff"); 
            System.out.println("11. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // clear input buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter gender: ");
                    String gender = sc.nextLine();
                    System.out.print("Enter contact: ");
                    String contact = sc.nextLine();
                    ps.addPatient(name, age, gender, contact);
                    break;
                case 2:
                    ps.viewAllPatients();
                    break;
                case 3:
                    as.bookAppointment();
                    break;
                case 4:
                    as.viewAppointments();
                    break;
                case 5:
                    bs.generateBill();
                    break;
                case 6:
                    bs.viewAllBills();
                    break;
                case 7:
                    is.addItem();
                    break;
                case 8:
                    is.viewItems();
                    break;
                case 9:
                    ss.addStaff(); // Add Staff
                    break;
                case 10:
                    ss.viewStaff(); // View Staff
                    break;
                case 11:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
