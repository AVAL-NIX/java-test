package nio.server;

public class ServerMain {

    public static void main(String[] args) {
        ServerHandler deamon = new ServerHandler("127.0.0.1",9999);
        new Thread(deamon).start();
    }

}