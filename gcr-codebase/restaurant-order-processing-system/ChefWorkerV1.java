public class ChefWorkerV1 extends Thread {

    private String dishName;
    private int cookingTimeMillis;

    public ChefWorkerV1(String chefName, String dishName, int cookingTimeMillis) {
        super(chefName);
        this.dishName = dishName;
        this.cookingTimeMillis = cookingTimeMillis;
    }

    @Override
    public void run() {

        System.out.println(getName() + " started preparing " + dishName);

        int[] progress = {25, 50, 75, 100};

        for (int percent : progress) {
            try {
                Thread.sleep(cookingTimeMillis / 4);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            System.out.println(getName() + " preparing " +
                    dishName + ": " + percent + "% complete");
        }
    }
}
