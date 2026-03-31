public class MealApp {

    public static void main(String[] args) {

        Meal<VegetarianMeal> meal1 =
                MealGenerator.generateMealPlan("Amit", new VegetarianMeal());

        Meal<VeganMeal> meal2 =
                MealGenerator.generateMealPlan("Neha", new VeganMeal());

        Meal<KetoMeal> meal3 =
                MealGenerator.generateMealPlan("Rohit", new KetoMeal());

        Meal<HighProteinMeal> meal4 =
                MealGenerator.generateMealPlan("Sneha", new HighProteinMeal());

        displayMeal(meal1);
        displayMeal(meal2);
        displayMeal(meal3);
        displayMeal(meal4);
    }

    private static void displayMeal(Meal<? extends MealPlan> meal) {
        System.out.println(
                meal.getUserName() + " | " +
                meal.getMealPlan().getPlanName() + " | Calories: " +
                meal.getMealPlan().getCalories()
        );
    }
}
