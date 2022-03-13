import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import org.springframework.util.NumberUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;

public class Test2 {

    public static void main(String[] args) {

        System.out.println(change("10K"));
        System.out.println(change("10M"));
        System.out.println(change("10G"));
        System.out.println(change("Affdsf"));
        System.out.println(change("100000G"));

    }
    public static int change(String value) {
//        Match n = new Match("d/(K|M|G)");
        if (value == null || ("").equals(value) ){
            return -1;
        }
        int i = value.indexOf("K");
        if (i > -1) {
            int v = Integer.parseInt(value.substring(0, i));
            if(v == 0){
                return 0;
            }
            return result(Math.ceil(v * 1024));
        }
        i = value.indexOf("M");
        if (i > -1) {
            int v = Integer.parseInt(value.substring(0, i));
            if(v == 0){
                return 0;
            }
            return result(Math.ceil(v * 1024 * 1024));
        }
        i = value.indexOf("G");
        if (i > -1) {
            int v = Integer.parseInt(value.substring(0, i));
            if(v == 0){
                return 0;
            }
            BigDecimal b = new BigDecimal(v);
            System.out.println(b.multiply(new BigDecimal(1024)).multiply(new BigDecimal(1024).multiply(new BigDecimal(1024))).toString());
            return result(b.multiply(new BigDecimal(1024)).multiply(new BigDecimal(1024).multiply(new BigDecimal(1024))).intValue());
        }
        try {
            return result(Long.parseLong(value));
        }catch (Exception e){
            return -1;
        }
    }

    public static int result(double v) {
        return v > Integer.MAX_VALUE
                || v < -1 || v == 0
                ? -1 : (int) v;
    }
}
