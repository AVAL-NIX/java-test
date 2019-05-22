package FourBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 菜单
 * @author avalon
 * @date 2019/5/22
 */
public class Meal {

    private List<Item> items = new ArrayList<>();


    public void addItem(Item item){
        items.add(item);
    }


    public double getCost(){
        return items.stream().collect(Collectors.summingDouble(a -> a.price()));
    }

    public void showItems(){
        for (Item item : items) {
            System.out.print("Item : "+item.name());
            System.out.print(", Packing : "+item.packing().packing());
            System.out.println(", Price : "+item.price());
        }
    }
}
