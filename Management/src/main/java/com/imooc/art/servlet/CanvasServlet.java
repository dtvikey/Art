package com.imooc.art.servlet;

import com.imooc.art.entity.Canvas;
import com.imooc.art.service.CanvasService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author: dtvikey
 * @Date: 29/11/18 上午 09:30
 * @Version 1.0
 * 油画servlet
 */
public class CanvasServlet extends HttpServlet {

    private CanvasService canvasService;

    @Override
    public void init() throws ServletException {
        super.init();
        canvasService = new CanvasService();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if("/art/list.do".equals(req.getServletPath())){
            String categoryIdStr = req.getParameter("categoryId");
            try{

                Long categoryId = null;
                if(null!=categoryIdStr){
                    categoryId = Long.valueOf(categoryIdStr);
                }

                List<Canvas> canvas = canvasService.getCanvasByCategoryId(categoryId,1,500);
                req.setAttribute("canvas",canvas);

            } catch (NumberFormatException e){

            }
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        canvasService = null;
    }

}
