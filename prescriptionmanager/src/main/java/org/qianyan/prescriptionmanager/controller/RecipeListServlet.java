package org.qianyan.prescriptionmanager.controller;

import org.qianyan.prescriptionmanager.domain.Recipe;
import org.qianyan.prescriptionmanager.service.impl.RecipeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author dyj123 2020/11/19
 * @Company Qianyan Studio
 * 查询所有配方信息 Servlet
 */
@WebServlet(name = "recipeList", urlPatterns = "/recipeList")
public class RecipeListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {

            // 查询所有配方记录
            List<Recipe> recipes = new RecipeServiceImpl().findAll();

            if (!recipes.isEmpty()) {

                // 若查询到记录，则向请求发送参数
                req.setAttribute("recipes", recipes);

                // 转发到配方列表页面
                req.getRequestDispatcher("recipelist.jsp").forward(req, resp);

            } else {

                // 若没有查询到记录，说明数据库没有任何配方记录，重定向至病人信息页面
                resp.getWriter().print("<script>alert(\"没有任何配方记录！请创建新配方！\");window.location.href = 'userinfo.jsp';</script>");

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
