package uc4.model;

public class Prescription {
    private int id;
    private int visitId;
    private String medicine;
    private String dose;
    private String duration;

    public Prescription() {}

    public Prescription(int visitId, String medicine, String dose, String duration) {
        this.visitId = visitId;
        this.medicine = medicine;
        this.dose = dose;
        this.duration = duration;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getVisitId() { return visitId; }
    public void setVisitId(int visitId) { this.visitId = visitId; }

    public String getMedicine() { return medicine; }
    public void setMedicine(String medicine) { this.medicine = medicine; }

    public String getDose() { return dose; }
    public void setDose(String dose) { this.dose = dose; }

    public String getDuration() { return duration; }
    public void setDuration(String duration) { this.duration = duration; }
}
