class BookAccess {
    public String ISBN;
    protected String title;
    private String author;

    //Parameterized Constructor
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }
}

class EBook extends BookAccess {
    void display() {
        System.out.println(ISBN + " " + title);
    }
}
