package nio.netty.code;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.MessageToByteEncoder;
import nio.model.IMMessage;
import nio.model.IMP;
import org.apache.commons.lang3.StringUtils;
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

public class IMEncoder extends MessageToByteEncoder<IMMessage> {

    private Pattern pattern = Pattern.compile("^\\[(.*)\\](\\s\\-\\s(.*))?");

    @Override
    protected void encode(ChannelHandlerContext ctx,IMMessage imMessage, ByteBuf out) throws Exception {
           out.writeBytes(new MessagePack().write(imMessage));
    }


    public String encode(IMMessage msg) {
        if (msg == null) {
            return null;
        }
        return "";
    }


}
