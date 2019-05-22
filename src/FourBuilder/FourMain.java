package FourBuilder;

/**
 * @author avalon
 * @date 2019/5/22
 */
public class FourMain {


    public static void main(String[] args){
        MealBuilder mealBuilder = new MealBuilder();

        Meal vegMeal = mealBuilder.prepareVegMeal();
        System.out.println("Veg Meal");
        vegMeal.showItems();
        System.out.println("Total Cost: " +vegMeal.getCost());
    }
}
