package nio.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ServerHandler implements Runnable {

    private boolean flag = true;

    private ServerSocketChannel serverSocketChannel = null;
    private Selector selector = null;

    private List<SocketChannel> channelList = null;


    @Override
    public void run() {
        while (this.flag) {
            int num = 0;
            try {
                //此处select()阻塞了线程
                num = selector.select();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error while select channel:" + e);
            }
            if (num > 0) {
                Iterator<SelectionKey> it = selector.selectedKeys().iterator();
                while (it.hasNext()) {
                    SelectionKey key = it.next();
                    it.remove();
                    if (key.isAcceptable()) {
                        // 监听到有新的连接则再注册读操作
                        this.channelList.add(ServerHandlerReadAndWriter.accept(selector,
                                serverSocketChannel));
                    } else if (key.isReadable()) {
                        // 监听到读操作
                        try {
                            ServerHandlerReadAndWriter.read(selector, key, channelList);
                        } catch (Exception e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("server to close..");
        close();
    }

    private void close() {
        if (this.serverSocketChannel != null && this.serverSocketChannel.isOpen()) {
            try {
                this.serverSocketChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (this.selector != null && this.selector.isOpen()) {
            try {
                this.selector.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public ServerHandler(String addr, int port) {
        try {
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(addr,port));
            selector = Selector.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            this.channelList = new ArrayList<>();
            System.out.println(" server is listening now.... ");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
