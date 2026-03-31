class Alert {
    String message;
    String type; // CRITICAL, INFO, WARNING

    public Alert(String message, String type) {
        this.message = message;
        this.type = type;
    }

    @Override
    public String toString() {
        return type + " - " + message;
    }
}
