class User implements Comparable<User> {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(User other) {
        return this.name.compareTo(other.name); // sorting by name
    }

    @Override
    public String toString() {
        return name;
    }
}
