public class VegetarianMeal implements MealPlan {

    @Override
    public String getPlanName() {
        return "Vegetarian";
    }

    @Override
    public int getCalories() {
        return 1800;
    }
}
