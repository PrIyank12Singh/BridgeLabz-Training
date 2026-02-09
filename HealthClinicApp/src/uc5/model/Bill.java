package uc5.model;

public class Bill {
    private int id;
    private int visitId;
    private double amount;
    private String status; // PAID / PENDING

    public Bill() {}

    public Bill(int visitId, double amount, String status) {
        this.visitId = visitId;
        this.amount = amount;
        this.status = status;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getVisitId() { return visitId; }
    public void setVisitId(int visitId) { this.visitId = visitId; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
