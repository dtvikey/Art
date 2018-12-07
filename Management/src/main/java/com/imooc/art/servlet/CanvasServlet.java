package com.imooc.art.servlet;

import com.imooc.art.entity.Canvas;
import com.imooc.art.entity.Category;
import com.imooc.art.service.CanvasService;
import com.imooc.art.service.CategoryService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: dtvikey
 * @Date: 29/11/18 上午 09:30
 * @Version 1.0
 * 油画servlet
 */
public class CanvasServlet extends HttpServlet {

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
            //获取油画分类的id
            String categoryIdStr = req.getParameter("categoryId");

            try{
                //定义一个长整型的油画分类ID
                Long categoryId = null;
                //如果前台页面传过来的categoryId不为null
                if(null!=categoryIdStr){
                    //就将值的引用赋值给categoryId，此处需要将String类型的变量转换为Long型
                    categoryId = Long.valueOf(categoryIdStr);
                }
                //通过CateService中的getCakesByCategoryId方法可以获取指定分类下的cakes集合
                List<Canvas> canvas = canvasService.getCanvasByCategoryId(categoryId,1,500);
                //将cakes存储在request作用域中
                req.setAttribute("canvas",canvas);
                //通过CategoryService的getCateegories方法可以获取全部的油画分类
                List<Category> categories = categoryService.getCategories();
                //将categories存储在request作用域中
                req.setAttribute("categories",categories);
                //转发到cake_list.jsp页面
                req.getRequestDispatcher("/WEB-INF/views/biz/canvas_list.jsp").forward(req,resp);

            } catch (NumberFormatException e){

                req.getRequestDispatcher("/WEB-INF/views/biz/canvas_list.jsp").forward(req,resp);

            }
        }else if("/art/addPrompt.do".equals(req.getServletPath())){

            //通过CategoryService的getCateegories方法可以获取全部的油画分类
            List<Category> categories = categoryService.getCategories();
            //将categories存储在request作用域中
            req.setAttribute("categories", categories);
            //转发到add_cake.jsp页面
            req.getRequestDispatcher("/WEB-INF/views/biz/add_canvas.jsp").forward(req, resp);

        }else if("/art/add.do".equals(req.getServletPath())){

            req.setCharacterEncoding("utf-8");
            if(ServletFileUpload.isMultipartContent(req)){
                try{

                    FileItemFactory factory = new DiskFileItemFactory();
                    ServletFileUpload upload = new ServletFileUpload(factory);
                    List<FileItem> items = upload.parseRequest(req);  //解析请求
                    Iterator<FileItem> ite= items.iterator();
                    Canvas canvas = new Canvas();
                    while(ite.hasNext()){

                        FileItem item = ite.next();
                        if(item.isFormField()){  //信息是普通的格式
                            String fieldName = item.getFieldName();
                            if("categoryId".equals(fieldName)){
                                canvas.setCategoryId(Long.valueOf(item.getString()));
                            }else if("name".equals(fieldName)){
                                canvas.setName(new String(item.getString().getBytes("iso8859-1"),"utf-8"));
                            }else if("price".equals(fieldName)){
                                canvas.setPrice(Integer.valueOf(item.getString()));
                            }else if("description".equals(fieldName)){
                                canvas.setDescription(new String(item.getString().getBytes("iso8859-1"),"utf-8"));
                            }
                        } else {  //信息是文件格式
                            canvas.setSmallImg(item.get());
                        }
                    }

                    canvasService.addCanvas(canvas);
                    req.getRequestDispatcher("/art/list.do").forward(req,resp);

                }catch (FileUploadException e){
                    e.printStackTrace();
                }
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
