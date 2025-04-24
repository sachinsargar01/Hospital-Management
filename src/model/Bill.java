package model;

public class Bill {
    private int id;
    private int patientId;
    private double amount;
    private String billingDate;

    public Bill(int id, int patientId, double amount, String billingDate) {
        this.id = id;
        this.patientId = patientId;
        this.amount = amount;
        this.billingDate = billingDate;
    }

    @Override
    public String toString() {
        return "Bill ID: " + id + ", Patient ID: " + patientId + ", Amount: ₹" + amount + ", Date: " + billingDate;
    }
}
