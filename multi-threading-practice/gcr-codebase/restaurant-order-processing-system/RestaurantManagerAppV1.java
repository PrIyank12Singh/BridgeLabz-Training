public class RestaurantManagerAppV1 {

    public static void main(String[] args) throws InterruptedException {

        ChefWorkerV1 chef1 = new ChefWorkerV1("Chef-1", "Pizza", 3000);
        ChefWorkerV1 chef2 = new ChefWorkerV1("Chef-2", "Pasta", 2000);
        ChefWorkerV1 chef3 = new ChefWorkerV1("Chef-3", "Salad", 1000);
        ChefWorkerV1 chef4 = new ChefWorkerV1("Chef-4", "Burger", 2500);

        chef1.start();
        chef2.start();
        chef3.start();
        chef4.start();

        chef1.join();
        chef2.join();
        chef3.join();
        chef4.join();

        System.out.println("Kitchen closed - All orders completed");
    }
}
