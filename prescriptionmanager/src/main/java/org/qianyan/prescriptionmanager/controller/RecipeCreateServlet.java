package org.qianyan.prescriptionmanager.controller;

import org.qianyan.prescriptionmanager.domain.Recipe;
import org.qianyan.prescriptionmanager.service.impl.RecipeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author dyj123 2020/11/19
 * @Company Qianyan Studio
 * 创建配方信息 Servlet
 */
@WebServlet(name = "recipeCreate", urlPatterns = "/recipeCreate")
public class RecipeCreateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 创建配方对象并从请求中接收参数
        Recipe recipe = new Recipe();
        recipe.setRecipe_name(req.getParameter("recipe_name"));
        recipe.setRecipe_ingredient(req.getParameter("recipe_ingredient"));

        try {

            // 保存到数据库
            int result = new RecipeServiceImpl().doInsert(recipe);

            if (result != 0) {

                // 若保存成功，则重定向至配方信息录入页面
                resp.getWriter().print("<script>alert(\"新配方保存成功！\");window.location.href = 'recipecreate.jsp';</script>");

            }

        } catch (Exception e) {
            req.setAttribute("error", e);
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

}
