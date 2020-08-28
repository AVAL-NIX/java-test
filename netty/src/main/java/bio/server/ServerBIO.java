package bio.server;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * 从以上代码，很容易看出，BIO主要的问题在于每当有一个新的客户端请求接入时，服务端必须创建一个新的线程来处理这条链路，在需要满足高性能、高并发的场景是没法应用的（大量创建新的线程会严重影响服务器性能，甚至罢工）。
 */
public class ServerBIO {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8888);
        while (true){
            Socket socket = serverSocket.accept();
            new Thread(new handlerBIO(socket)).start();
        }
    }
}
