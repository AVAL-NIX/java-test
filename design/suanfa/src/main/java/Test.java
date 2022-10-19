import org.yaml.snakeyaml.events.Event.ID;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class Test {


    public static void main(String[] args) throws ParseException {
//        Date date = new Date("2007-03-01T00:00:00.000Z");
//
//        System.out.println(date);
        LocalDateTime parse = LocalDateTime.parse("2007-03-01T00:00:00.000Z", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH));
        System.out.println(parse);
        String dateTime = "2007-03-01T00:00:00.000Z";
        dateTime = dateTime.replace("Z", " UTC"); //2019-06-27T16:00:00.000 UTC
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");//转换时区格式
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");

        Date date = null;
        try {
            date = format1.parse(dateTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String time = format2.format(date);//2019-06-28
        System.out.println(time);
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
