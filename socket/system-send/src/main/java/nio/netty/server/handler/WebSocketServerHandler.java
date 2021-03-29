package nio.netty.server.handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import nio.model.MsgProcessor;

/**
 * 对自定义协议的支持  ， 专门处理TextWebSocketFrame
 *
 * @author zhengxin
 * @date 2021/3/29
 */
public class WebSocketServerHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {
    private MsgProcessor msgProcessor = new MsgProcessor();

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        msgProcessor.sendMsg(ctx.channel(), msg.text());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        Channel channel = ctx.channel();
        String addr = msgProcessor.getAddr(channel);
        System.out.println("addr " + addr + " : " + channel.remoteAddress() + " websocket 异常！！！！！！！！！！！！");
        cause.printStackTrace();
        ctx.close();
    }
}
