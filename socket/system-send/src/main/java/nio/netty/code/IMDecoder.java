package nio.netty.code;

import nio.model.IMMessage;
import nio.model.IMP;
import org.apache.commons.lang3.*;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.apache.commons.lang3.math.NumberUtils;
import org.msgpack.MessagePack;
import org.msgpack.MessageTypeException;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 自定义IMP的解码器
 *
 * @author zhengxin
 * @date 2021/3/29
 */

public class IMDecoder extends ByteToMessageDecoder {

    private Pattern pattern = Pattern.compile("^\\[(.*)\\](\\s\\-\\s(.*))?");

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> list) throws Exception {
        try {
            final int length = in.readableBytes();
            final byte[] array = new byte[length];
            String content = new String(array, in.readerIndex(), length);
            //空消息不解析
            if (org.apache.commons.lang3.StringUtils.isNotBlank(content)) {
                if (!IMP.isIMP(content)) {
                    ctx.channel().pipeline().remove(this);
                    return;
                }
            }

            in.getBytes(in.readerIndex(), array, 0, length);
            list.add(new MessagePack().read(array, IMMessage.class));
            in.clear();
        } catch (MessageTypeException e) {
            ctx.channel().pipeline().remove(this);
            System.out.println(e);
        }
    }


    public IMMessage decode(String msg) {
        if (StringUtils.isBlank(msg)) {
            return null;
        }
        Matcher matcher = pattern.matcher(msg);
        String header = "";
        String content = "";
        if (matcher.matches()) {
            header = matcher.group(1);
            content = matcher.group(3);
        }

        String[] heads = header.split("\\]\\[");
        long time = NumberUtils.toLong(heads[0]);
        String nickname = heads[2];

        //判断消息类型
        if (msg.startsWith("[" + IMP.LOGIN.getName() + "]") || msg.startsWith("[" + IMP.FLOWER.getName() + "]")) {
            return new IMMessage(heads[0], heads[3], time, nickname);
        } else if (msg.startsWith("[" + IMP.CHAT.getName() + "]")) {
            return new IMMessage(heads[0], time, nickname, content);
        } else {
            return null;
        }
    }


}
