package nio.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义消息协议
 *
 * @author zhengxin
 * @date 2021/3/29
 */
@Getter
public enum IMP {

    /**
     * 系统消息
     */
    SYSTEM("system"),

    /**
     * 登录指令
     */
    LOGIN("login"),


    /**
     * 登出指令
     */
    LOGOUT("logout"),

    /**
     * 聊天消息
     */
    CHAT("chat"),


    /**
     * 送鲜花
     */
    FLOWER("flower"),


    ;

    public static List<String> list = new ArrayList<String>();

    static {
        IMP[] imps = IMP.values();
        for (IMP imp : imps) {
            list.add(imp.name);
        }
    }

    private String name;

    IMP(String name) {
        this.name = name;
    }

    public static boolean isIMP(String content) {
        return list.contains(content);
    }




}
