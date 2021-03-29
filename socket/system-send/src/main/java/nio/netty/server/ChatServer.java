package nio.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import nio.netty.code.IMDecoder;
import nio.netty.code.IMEncoder;
import nio.netty.server.handler.HttpServerHandler;
import nio.netty.server.handler.TerminalServerHandler;
import nio.netty.server.handler.WebSocketServerHandler;
import org.apache.commons.lang3.math.NumberUtils;

/**
 * @author zhengxin
 * @date 2021/3/29
 */
public class ChatServer {

    private int port  = 8088;

    public void start(int port){
        EventLoopGroup boosGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(boosGroup, workGroup).channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG,1024)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            // inbound  高到低 ， outbound 低到高 的顺序 ， 不能乱
                            ChannelPipeline channelPipeline = ch.pipeline();
                            channelPipeline.addLast(new IMDecoder());// inbound
                            channelPipeline.addLast(new IMEncoder()); // outbound
                            channelPipeline.addLast(new TerminalServerHandler());// inbound

                            //解析http请求
                            channelPipeline.addLast(new HttpServerCodec());// outbound

                            //将同一个HTTP请求或响应的多个消息对象变成一个fullhttprequest
                            channelPipeline.addLast(new HttpObjectAggregator(64 *1024));// inbound
                            //对大文件进行处理超过1GB的那种
                            channelPipeline.addLast(new ChunkedWriteHandler());// inbound , outbound
                            channelPipeline.addLast(new HttpServerHandler());// inbound 可有可无
                            //解析websocket请求
                            channelPipeline.addLast(new WebSocketServerProtocolHandler("/im"));// inbound
                            channelPipeline.addLast(new WebSocketServerHandler());// inbound

                        }
                    });
            ChannelFuture channelFuture  = b.bind(port);
            System.out.println(" 服务已经启动：端口 " + port);
            channelFuture.channel().closeFuture().sync();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            workGroup.shutdownGracefully();
            boosGroup.shutdownGracefully();
        }
    }

    public void start(){
        start(port);
    }

    public static void main(String[] args) {
        if(args.length > 0){
            new ChatServer().start(NumberUtils.toInt(args[0]));
        }else{
            new ChatServer().start();
        }
    }
}
