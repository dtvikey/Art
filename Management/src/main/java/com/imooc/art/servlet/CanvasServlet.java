package com.imooc.art.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: dtvikey
 * @Date: 29/11/18 上午 09:30
 * @Version 1.0
 * 油画servlet
 */
public class CanvasServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if("/art/list.do".equals(req.getServletPath())){
            String categoryIdStr = req.getParameter("categoryId");
            try{

                Long categoryId = null;

            } catch (NumberFormatException e){

            }
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }

}
