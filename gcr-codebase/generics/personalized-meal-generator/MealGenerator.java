public class MealGenerator {

    public static <T extends MealPlan> Meal<T> generateMealPlan(String userName, T plan) {
        validatePlan(plan);
        return new Meal<>(userName, plan);
    }

    private static <T extends MealPlan> void validatePlan(T plan) {
        if (plan.getCalories() <= 0) {
            throw new IllegalArgumentException("Invalid meal plan calories");
        }
    }
}
