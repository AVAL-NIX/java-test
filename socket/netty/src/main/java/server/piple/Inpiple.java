package server.piple;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author zhengxin
 * @date 2021/9/3
 */
public class Inpiple {

    public static class SimpleInA extends ChannelInboundHandlerAdapter{
        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            System.out.println(" AAAAAAAAAAAAAAA ");
           // super.channelRead(ctx, msg);
            ctx.fireChannelRead(msg);
        }
    }

    public static class SimpleInB extends ChannelInboundHandlerAdapter{
        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            System.out.println(" BBBBBBBBBBBBBBBBBB ");
            super.channelRead(ctx, msg);
        }
    }

    public static class SimpleInC extends ChannelInboundHandlerAdapter{

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            System.out.println(" CCCCCCCCCCCCCCCCCC ");
            super.channelRead(ctx, msg);
        }
    }
}

