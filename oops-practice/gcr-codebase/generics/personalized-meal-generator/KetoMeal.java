public class KetoMeal implements MealPlan {

    @Override
    public String getPlanName() {
        return "Keto";
    }

    @Override
    public int getCalories() {
        return 2000;
    }
}
