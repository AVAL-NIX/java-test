package nio.netty.handler;

import io.netty.channel.*;
import io.netty.handler.codec.http.*;
import io.netty.handler.codec.http.HttpHeaders.Names;
import io.netty.handler.codec.http.HttpHeaders.Values;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.RandomAccessFile;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * 主要处理服务器分发请求
 * 手动编写HTTP请求头
 *
 * @author zhengxin
 * @date 2021/3/29
 */
public class HttpServerHandler extends SimpleChannelInboundHandler<FullHttpRequest> {

    private URL baseURL = HttpServerHandler.class.getResource("");

    private final String webroot = "webroot";

    private File getResource(String fileName) {
        String basePath = null;
        String path = null;
        try {
            int start = basePath.indexOf("classes/");
            basePath = baseURL.toURI().toString();
            basePath = (basePath.substring(0, start) + "/" + "classes/").replaceAll("/+", "/");
            path = basePath + webroot + "/" + fileName;
            //
            System.out.println("basePath" + basePath);
            System.out.println("path" + path);
            path = !path.contains("file:") ? path : path.substring(5);
            path = path.replaceAll("//", "/");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return new File(path);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest request) throws Exception {
        String uri = request.getUri();
        RandomAccessFile file = null;

        String page = uri.equals("/") ? "chat.html" : uri;
        file = new RandomAccessFile(page, "r");

        ///
        HttpVersion version;
        HttpResponseStatus status;
        HttpResponse response = new DefaultHttpResponse(request.getProtocolVersion(),
                HttpResponseStatus.OK);
        //获取类型
        String contentType = "text/html";
        if(uri.endsWith(".css")){
            contentType = "text/css";
        }
        else if(uri.endsWith(".js")){
            contentType = "text/javascript";
        }
        else if(uri.toLowerCase().matches(".*\\.(jpg|png|gif)$")){
            String ext = uri.substring(uri.lastIndexOf("."));
            contentType = "image/" + ext;
            System.out.println("contentType : "+contentType);
        }

        response.headers().set(Names.CONTENT_TYPE,contentType +"charest=utf-8;");
        boolean keepAlive = HttpHeaders.isKeepAlive(request);
        if(keepAlive){
            response.headers().set(Names.CONTENT_LENGTH, file.length());
            response.headers().set(Names.CONNECTION, Values.KEEP_ALIVE);
        }
        ctx.write(response);
        ctx.write(new DefaultFileRegion(file.getChannel(), 0 ,file.length()));

        ChannelFuture future = ctx.writeAndFlush(LastHttpContent.EMPTY_LAST_CONTENT);
        if(!keepAlive){
            future.addListener(ChannelFutureListener.CLOSE);
        }
        file.close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        Channel channel = ctx.channel();
        System.out.println(channel.remoteAddress()+"异常！！！！！！！！！！！！");
        cause.printStackTrace();
        ctx.close();
    }
}
