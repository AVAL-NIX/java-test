package com.tomcat.controller.servlet;

import com.tomcat.controller.http.GPRequest;
import com.tomcat.controller.http.GPResponse;

import java.io.InputStream;

/**
 * @author zhengxin
 * @date 2021/5/3
 */
public class FirstServlet extends GPRequest {


    public FirstServlet(InputStream inputStream) {
        super(inputStream);
    }

    public void doGet(GPRequest request , GPResponse response) throws Exception{
        this.doPost(request, response);

    }

    private void doPost(GPRequest request, GPResponse response) {
        response.writer(" This is First Servlet");
    }
}
