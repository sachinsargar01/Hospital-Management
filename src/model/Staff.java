package model;

public class Staff {
    private int id;
    private String name;
    private String role;
    private String department;
    private String contact;

    public Staff(int id, String name, String role, String department, String contact) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.department = department;
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Staff ID: " + id + ", Name: " + name + ", Role: " + role + ", Department: " + department + ", Contact: " + contact;
    }
}
