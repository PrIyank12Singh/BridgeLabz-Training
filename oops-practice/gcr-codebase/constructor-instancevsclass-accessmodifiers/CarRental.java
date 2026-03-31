class CarRental {
    String customerName;
    String carModel;
    int rentalDays;
    static final double COST_PER_DAY = 1500;

    //Parameterized Constructor
    CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    double calculateTotalCost() {
        return rentalDays * COST_PER_DAY;
    }
}
