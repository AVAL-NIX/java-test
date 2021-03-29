package TenIterator;

/**
 * @author zx
 * @date 2019/6/25
 */
public class NamePepository implements Container {

    public String names[] = {"Robe", "cccc", "D", "G"};

    @Override
    public Iterator getIterator() {
        return new NameIterator();

    }

    /**
     * 内部迭代器
     */
    private class NameIterator implements Iterator {
        int index = 0;

        @Override
        public boolean hasNext() {
            if (index < names.length) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return names[index++];
            }
            return null;
        }
    }
}
