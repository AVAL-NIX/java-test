package SevenFilter;

import java.util.ArrayList;
import java.util.List;

/**
 * 接口的具体实现 - > 男人类
 *
 * @author zx
 * @date 2019/6/25
 */
public class CriteriaMale implements Criteria {

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> malePersons = new ArrayList<Person>();
        for (Person person : persons) {
            if (person.getGender().equalsIgnoreCase("MALE")) {
                malePersons.add(person);
            }
        }
        return malePersons;
    }
}