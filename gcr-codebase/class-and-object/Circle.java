class Circle {

    double radius;

    // method for calculation and area
    void calculateArea() {
        double area = Math.PI * radius * radius;
        System.out.printf("Area of circle: %.4f\n", area);
    }

    // method for calculation  and circumference
    void calculateCircumference() {
        double circumference = 2 * Math.PI * radius;
        System.out.printf("Circumference of circle: %.4f\n", circumference);
    }

    // main method
    public static void main(String[] args) {

        //circle object
        Circle circle = new Circle();

        // Assigning radius
        circle.radius = 2.5;

        // Calling methods
        circle.calculateArea();
        circle.calculateCircumference();
    }
}