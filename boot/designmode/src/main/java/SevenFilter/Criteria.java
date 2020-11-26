package SevenFilter;

import java.util.List;

/**
 * 人class 的接口
 * -> 筛选
 *
 * @author zx
 * @date 2019/6/25
 */
public interface Criteria {

    public List<Person> meetCriteria(List<Person> persons);
}