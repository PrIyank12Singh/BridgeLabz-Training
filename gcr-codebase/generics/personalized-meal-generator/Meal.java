public class Meal<T extends MealPlan> {

    private String userName;
    private T mealPlan;

    public Meal(String userName, T mealPlan) {
        this.userName = userName;
        this.mealPlan = mealPlan;
    }

    public String getUserName() {
        return userName;
    }

    public T getMealPlan() {
        return mealPlan;
    }
}
