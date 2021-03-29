package nio.model;

import com.alibaba.fastjson.JSONObject;
import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.GlobalEventExecutor;
import nio.netty.code.IMDecoder;
import nio.netty.code.IMEncoder;

/**
 * 处理消息的类222
 *
 * @author zhengxin
 * @date 2021/3/29
 */
public class MsgProcessor {
    //记录在线用户
    private static ChannelGroup onlineUsers = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    //定义扩展属性
    public static final AttributeKey<String> NICK_NAME = AttributeKey.valueOf("nickName");
    public static final AttributeKey<String> IP_ADDR = AttributeKey.valueOf("ipAddr");
    public static final AttributeKey<JSONObject> ATTRS = AttributeKey.valueOf("attrs");
    public static final AttributeKey<String> FROM = AttributeKey.valueOf("from");

    //定义解码器
    private IMDecoder imDecoder = new IMDecoder();
    private IMEncoder imEncoder = new IMEncoder();

    /**
     * 获取名称
     *
     * @param client
     * @return
     */
    public String getNickName(Channel client) {
        return client.attr(NICK_NAME).get();
    }

    /**
     * 获取地址
     *
     * @param client
     * @return
     */
    public String getAddress(Channel client) {
        return client.remoteAddress().toString().replaceAll("/", "");
    }

    public String getAddr(Channel client) {
        return client.remoteAddress().toString().replaceAll("/", "");
    }

    /**
     * 获取扩展属性
     *
     * @param client
     * @return
     */
    public JSONObject getAttrs(Channel client) {
        JSONObject jsonObject = client.attr(ATTRS).get();
        return jsonObject;
    }

    /**
     * 设置扩展属性
     *
     * @param client
     * @param key
     * @param value
     */
    public void setAttrs(Channel client, String key, Object value) {
        JSONObject jsonObject = client.attr(ATTRS).get();
        if(jsonObject == null){
            jsonObject = new JSONObject();
        }
        jsonObject.put(key, value);
        client.attr(ATTRS).set(jsonObject);
    }

    public void logout(Channel channel) {
        if (getNickName(channel) == null) {
            return;
        }
        for (Channel onlineUser : onlineUsers) {
            //给所有客户端发消息
            IMMessage imMessage = new IMMessage(IMP.SYSTEM.getName(), System.currentTimeMillis(), onlineUsers.size()
                    , getNickName(channel) + "离开");

        }
        onlineUsers.remove(channel);
    }


    public void sendMsg(Channel client, String msg) {
        IMMessage request = imDecoder.decode(msg);
        if (request == null) {
            System.out.println("空消息：" + msg);
            return;
        }
        String addr = getAddress(client);

        if (IMP.LOGIN.getName().equals(request.getCmd())) {
            //登录命令，执行记录用户属性
            client.attr(NICK_NAME).getAndSet(request.getSender());
            client.attr(IP_ADDR).getAndSet(addr);
            client.attr(FROM).getAndSet(request.getTerminal());

            onlineUsers.add(client);
            //给所有客户端发消息,通知XXX 上线了。
            for (Channel onlineUser : onlineUsers) {
                boolean isMy = (onlineUser == client);
                if (isMy) {
                    request = new IMMessage(IMP.SYSTEM.getName(), System.currentTimeMillis()
                            , onlineUsers.size(), "已与服务器建立连接");
                } else {
                    request = new IMMessage(IMP.SYSTEM.getName(), System.currentTimeMillis()
                            , onlineUsers.size(), getNickName(client) + "加入");
                }
                //如果是控制台chatClient对象
                if ("Console".equals(onlineUser.attr(FROM).get())) {
                    onlineUser.writeAndFlush(request);
                    continue;
                }
                //正常消息
                String content = imEncoder.encode(request);
                onlineUser.writeAndFlush(new TextWebSocketFrame(content));
            }


        } else if (IMP.CHAT.getName().equals(request.getCmd())) {
            for (Channel onlineUser : onlineUsers) {
                boolean isMy = (onlineUser == client);
                if (isMy) {
                    request.setSender("you");
                } else {
                    request.setSender(getNickName(client));
                }
                request.setTime(System.currentTimeMillis());
                //如果是控制台chatClient对象
                if ("Console".equals(onlineUser.attr(FROM).get()) ) {
                    if(isMy){
                        continue;
                    }
                    onlineUser.writeAndFlush(request);
                    continue;
                }

                //websocket正常消息
                String content = imEncoder.encode(request);
                onlineUser.writeAndFlush(new TextWebSocketFrame(content));
            }

        } else if (IMP.FLOWER.getName().equals(request.getCmd())) {
            JSONObject attr = getAttrs(client);
            long currTime = System.currentTimeMillis();
            if(attr!=null){
                long lastLong = attr.getLong("lastFlowerTime");
                //60s内不允许重复时间送花
                int s = 60;
                long sub = currTime - lastLong;
                if(sub <  1000* s){
                    request.setSender("you");
                    request.setCmd(IMP.SYSTEM.getName());
                    request.setContent("你送花太频繁了，请"+(s - Math.round(sub/1000))+"秒后重试");
                    String content = imEncoder.encode(request);
                    client.writeAndFlush(content);
                    return ;
                }
            }
            for (Channel onlineUser : onlineUsers) {
                boolean isMy = (onlineUser == client);
                if (isMy) {
                    request.setSender("you");
                    request.setContent("你给大家送了一波鲜花");
                    setAttrs(client,"lastFlowerTime", currTime);
                } else {
                    request.setSender(getNickName(onlineUser));
                    request.setContent(getNickName(client)+"给大家送了一波鲜花");
                }
                request.setTime(System.currentTimeMillis());
                //正常消息
                String content = imEncoder.encode(request);
                onlineUser.writeAndFlush(new TextWebSocketFrame(content));
            }

        }

    }

    public void sendMsg(Channel channel, IMMessage msg) {
        sendMsg(channel, imEncoder.encode(msg));
    }


}
