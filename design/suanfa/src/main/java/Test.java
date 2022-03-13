import org.yaml.snakeyaml.events.Event.ID;

public class Test {


    public static void main(String[] args) {

        Hash test = new Hash();
        test.insert("key", "value");

        test.insert("key1¬", "value1");


        System.out.println(test.get("key"));System.out.println(test.get("key1"));










    }

    static class Hash {
        public HashNode[] table = new HashNode[1];

        class HashNode {
            Object key;
            Object value;
            HashNode pre;
            HashNode next;
        }

        public void insert(Object key, Object value) {
            int index = key.hashCode();
            index = index % table.length;
            HashNode hashNode = new HashNode();
            hashNode.key = key;
            hashNode.value = value;
            if (table[index] != null) {
                HashNode pre = table[index];/* valid*/
                HashNode valid = pre;


                while (valid != null) {
                    if (valid.key.equals(key)) {
                        valid.value = value;
                        return;
                    }
                    valid = valid.next;
                }

                // insert
                while (pre.next != null) {
                    pre = pre.next;
                }
                pre.next = hashNode;
                hashNode.next = pre;
            } else {
                table[index] = hashNode;
            }
        }

        public Object get(Object key) {
            int index = key.hashCode();
            index = index % table.length;
            if (table[index] != null) {
                HashNode data = table[index];
                if (data.key.equals(key)) {
                    return data.value;
                }
                while (data.next != null) {
                    data = data.next;
                    if (data.key.equals(key)) {
                        return data.value;
                    }
                }
            }
            return null;
        }
    }
}
