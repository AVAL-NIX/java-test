package server.piple;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

/**
 * @author zhengxin
 * @date 2021/9/3
 */
public class OutPiple {

    public static class SimpleOutD extends ChannelOutboundHandlerAdapter  {
        @Override
        public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
            System.out.println(" DDDDDDDDDDDDDDD ");
            super.write(ctx, msg, promise);
        }
    }

    public static class SimpleOutE extends ChannelOutboundHandlerAdapter  {
        @Override
        public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
            System.out.println(" EEEEEEEEEEEEEEEEE ");
            super.write(ctx, msg, promise);
        }
    }

    public static class SimpleOutF extends ChannelOutboundHandlerAdapter  {
        @Override
        public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
            System.out.println(" FFFFFFFFFFFFFFFFFF ");
            super.write(ctx, msg, promise);
        }
    }


}
