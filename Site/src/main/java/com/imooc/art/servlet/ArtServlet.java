package com.imooc.art.servlet;

import com.imooc.art.entity.Canvas;
import com.imooc.art.entity.Category;
import com.imooc.art.service.CanvasService;
import com.imooc.art.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author: dtvikey
 * @Date: 04/12/18 下午 03:22
 * @Version 1.0
 */
public class ArtServlet extends HttpServlet {

    private CanvasService canvasService;
    private CategoryService categoryService;

    @Override
    public void init() throws ServletException {
        super.init();
        canvasService = new CanvasService();
        categoryService = new CategoryService();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if("/art/list.do".equals(req.getServletPath())){
            String pageStr = req.getParameter("page");
            String categoryIdStr = req.getParameter("categoryId");
            try{
                Long categoryId = 1L;
                if(null!=categoryIdStr && !"".equals(categoryIdStr.trim())){
                    categoryId = Long.valueOf(categoryIdStr);
                }
                int page = 1;
                if (null!=pageStr && !"".equals(pageStr.trim())){
                    page = Integer.valueOf(pageStr);
                }

                List<Canvas> canvas = canvasService.getCanvasByCategoryId(categoryId,page,8);
                int count = canvasService.countCanvasByCategoryId(categoryId);
                int last = count % 8 == 0 ? (count/8):((count/8) + 1);

                List<Category> categories = categoryService.getCategories();
                req.setAttribute("canvas",canvas);
                req.setAttribute("categories",categories);
                req.setAttribute("page",page);
                req.setAttribute("last",last);
                req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req,resp);

            }catch (NumberFormatException e){

                req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req,resp);

            }
        }else if ("/art/getImg.do".equals(req.getServletPath())){

            String idStr = req.getParameter("id");
            Canvas canvas = canvasService.getCanvasImg(Long.valueOf(idStr));
            try{
                resp.setContentType("multipart/form-data");
                if(null!=canvas&& null!=canvas.getSmallImg()){
                    InputStream in = new ByteArrayInputStream(canvas.getSmallImg());
                    ServletOutputStream out = resp.getOutputStream();
                    byte[] b = new byte[1024];
                    int length = in.read(b);
                    while (length!=-1){
                        out.write(b);
                        length = in.read(b);
                    }
                    out.flush();
                    out.close();
                    in.close();
                    resp.flushBuffer();
                }
            } catch (IOException e){
                e.printStackTrace();
            }

        }
    }

    @Override
    public void destroy() {
        super.destroy();
        canvasService = null;
        categoryService = null;
    }
}
