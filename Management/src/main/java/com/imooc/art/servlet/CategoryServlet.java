package com.imooc.art.servlet;

import com.imooc.art.entity.Category;
import com.imooc.art.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author: dtvikey
 * @Date: 30/11/18 下午 02:36
 * @Version 1.0
 * 分类servlet
 */
public class CategoryServlet extends HttpServlet {

    private CategoryService categoryService;

    @Override
    public void init() throws ServletException {

        super.init();
        categoryService = new CategoryService();

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ("/category/list.do".equals(req.getServletPath())){
            List<Category> categories = categoryService.getCategories();
            req.setAttribute("categories",categories);
            req.getRequestDispatcher("/WEB-INF/views/biz/category_list.jsp").forward(req,resp);
        }else if("/category/addPrompt.do".equals(req.getServletPath())){
            req.getRequestDispatcher("/WEB-INF/views/biz/add_category.jsp").forward(req,resp);
        }else if("/category/add.do".equals(req.getServletPath())){
            String name = req.getParameter("name");
            String description = req.getParameter("description");
            String createName = req.getParameter("createname");
            Category category = new Category();
            category.setName(name);
            category.setDescription(description);
            category.setCreateName(createName);
            categoryService.addCategory(category);
            req.getRequestDispatcher("/category/list.do").forward(req,resp);
        }
    }

    @Override
    public void destroy() {

        super.destroy();
        categoryService = null;

    }
}
