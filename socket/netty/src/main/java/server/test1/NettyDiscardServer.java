package server.test1;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author zhengxin
 * @date 2021/9/2
 */
public class NettyDiscardServer {

    private int serverPort = 0;

    ServerBootstrap b = new ServerBootstrap();

    public NettyDiscardServer(int port) {
        this.serverPort = port;
    }

    public void serverRun(){
        EventLoopGroup bossLoopGroup = new NioEventLoopGroup();
        EventLoopGroup workLoopGroup = new NioEventLoopGroup();
        b.group(bossLoopGroup, workLoopGroup);
        b.channel(NioServerSocketChannel.class);
        b.localAddress(serverPort);
        b.option(ChannelOption.SO_KEEPALIVE,true);
        b.childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                ch.pipeline().addLast(new NettyDiscardHandler());
            }
        });
        ChannelFuture channelFuture = null;
        try {
            channelFuture = b.bind().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ChannelFuture closeFuture = channelFuture.channel().closeFuture();

        workLoopGroup.shutdownGracefully();
        bossLoopGroup.shutdownGracefully();
    }

    public static void main(String[] args) {
        new NettyDiscardServer(12345).serverRun();
    }
}


