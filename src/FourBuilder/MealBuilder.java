package FourBuilder;

/**
 * 创建一个 MealBuilder 类，实际的 builder 类负责创建 Meal 对象。
 * @author avalon
 * @date 2019/5/22
 */
public class MealBuilder {

    public Meal prepareVegMeal (){
        Meal meal = new Meal();
        meal.addItem(new Burger());
        meal.addItem(new Cold());
        return meal;
    }


}
