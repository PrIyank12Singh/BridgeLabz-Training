class User {

    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_email")
    private String email;

    private int age;  // Not annotated, will be ignored

    public User(String username, String email, int age) {
        
        this.username = username;
        this.email = email;
        this.age = age;
    }

    // Getters (optional for JSON conversion if using field access)
    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public int getAge() { return age; }
}
