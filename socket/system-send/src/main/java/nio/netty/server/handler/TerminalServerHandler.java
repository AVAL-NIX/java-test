package nio.netty.server.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import nio.model.IMMessage;
import nio.model.MsgProcessor;

/**
 * 对自定义协议的支持
 *
 * @author zhengxin
 * @date 2021/3/29
 */
public class TerminalServerHandler extends SimpleChannelInboundHandler<IMMessage> {

    private MsgProcessor msgProcessor = new MsgProcessor();

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, IMMessage msg) throws Exception {
        msgProcessor.sendMsg(ctx.channel(),msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println(cause.getMessage()+" 客户端断开连接！");
        cause.printStackTrace();
        ctx.close();
    }
}
