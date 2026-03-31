
class Student {
    String name;
    String district;
    int score;

    public Student(String name, String district, int score) {
        this.name = name;
        this.district = district;
        this.score = score;
    }

    @Override
    public String toString() {
        return name + " (" + district + ") - " + score;
    }
}

