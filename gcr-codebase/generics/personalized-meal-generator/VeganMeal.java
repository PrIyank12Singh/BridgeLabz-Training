public class VeganMeal implements MealPlan {

    @Override
    public String getPlanName() {
        return "Vegan";
    }

    @Override
    public int getCalories() {
        return 1700;
    }
}
