package SevenFilter;

import java.util.ArrayList;
import java.util.List;

/**
 * 接口的具体实现 - > 女人类
 *
 * @author zx
 * @date 2019/6/25
 */
public class CriteriaFemale implements Criteria {

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> femalePersons = new ArrayList<Person>();
        for (Person person : persons) {
            if (person.getGender().equalsIgnoreCase("FEMALE")) {
                femalePersons.add(person);
            }
        }
        return femalePersons;
    }
}