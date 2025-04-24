package model;

public class Patient {
    private int id;
    private String name;
    private int age;
    private String gender;
    private String contact;

    public Patient(int id, String name, int age, String gender, String contact) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.contact = contact;
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
    public String getContact() { return contact; }

    public void setName(String name) { this.name = name; }
    public void setContact(String contact) { this.contact = contact; }

    @Override
    public String toString() {
        return "Patient ID: " + id + ", Name: " + name + ", Age: " + age +
               ", Gender: " + gender + ", Contact: " + contact;
    }
}
