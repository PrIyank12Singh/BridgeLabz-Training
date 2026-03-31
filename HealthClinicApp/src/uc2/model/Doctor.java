package uc2.model;

public class Doctor {
    private int id;
    private String name;
    private String specialization;
    private String contact;
    private double consultationFee;
    private boolean isActive;

    // Constructors
    public Doctor() {}
    public Doctor(String name, String specialization, String contact, double consultationFee) {
        this.name = name;
        this.specialization = specialization;
        this.contact = contact;
        this.consultationFee = consultationFee;
        this.isActive = true;
    }

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }

    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }

    public double getConsultationFee() { return consultationFee; }
    public void setConsultationFee(double consultationFee) { this.consultationFee = consultationFee; }

    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }
}
