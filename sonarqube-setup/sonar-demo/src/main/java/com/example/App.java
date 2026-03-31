package com.example;

public class App {

    public int add(int a, int b) {
        return a + b;
    }

    public boolean isPositive(int number) {
        return number > 0;
    }

    public static void main(String[] args) {
        App app = new App();
        System.out.println("Sum of 3 and 5: " + app.add(3, 5));
        System.out.println("Is 10 positive? " + app.isPositive(10));
    }
}
