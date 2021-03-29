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

    /**
     * 要注意留一个空参构造，否则会反射失败
     * 二月 28, 2017 11:49:55 上午 org.msgpack.template.builder.BuildContext build
     严重: builder:
     {
     if (!$3 && $1.trySkipNil()) {
     return null;
     }
     messagepack.UserInfo _(双$)_t;
     if ($2 == null) {
     _(双$)_t = new messagepack.UserInfo();
     } else {
     _$$_t = (messagepack.UserInfo) $2;
     }
     */
    public IMMessage() {
    }

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

    public IMMessage(String cmd,long time,int online,String content){
        this.cmd = cmd;
        this.time = time;
        this.online = online;
        this.content = content;
        this.terminal = terminal;
    }

    public IMMessage(String cmd,String terminal,long time,String sender,String content){
        this.cmd = cmd;
        this.time = time;
        this.sender = sender;
        this.terminal = terminal;
        this.content = content;
    }

    public IMMessage(String cmd,String terminal,long time,String sender){
        this.cmd = cmd;
        this.time = time;
        this.sender = sender;
        this.terminal = terminal;
    }


    public IMMessage(String cmd,long time,String sender,String content){
        this.cmd = cmd;
        this.time = time;
        this.sender = sender;
        this.content = content;
        this.terminal = terminal;
    }
}
