package nio.model;

import lombok.Data;
import org.msgpack.annotation.Message;

/**
 * @author zhengxin
 * @date 2021/3/29
 */
@Message
@Data
public class IMMessage {

    // IP 地址端口
    private String addr;
    //命令类型 对应IMP枚举
    private String cmd;
    //命令发送时间
    private long time;
    //在线人数
    private int online;
    //发送人
    private String sender;
    //接收人
    private String receiver;
    //内容
    private String content;
    //终端
    private String terminal;


    public IMMessage(String addr, String cmd, long time, int online, String sender, String receiver, String content, String terminal) {
        this.addr = addr;
        this.cmd = cmd;
        this.time = time;
        this.online = online;
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
        this.terminal = terminal;
    }

    public IMMessage(String head, String head1, long time, String nickname) {

    }

    public IMMessage(String head, long time, String nickname, String content) {
    }

    public IMMessage(String name, long currentTimeMillis, int size, String s) {
    }
}
