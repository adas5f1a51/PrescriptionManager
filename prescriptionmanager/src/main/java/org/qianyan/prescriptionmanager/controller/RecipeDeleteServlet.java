package org.qianyan.prescriptionmanager.controller;

import org.qianyan.prescriptionmanager.domain.Prescription;
import org.qianyan.prescriptionmanager.service.impl.PrescriptionServiceImpl;
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
 * 删除配方信息 Servlet
 */
@WebServlet(name = "recipeDelete", urlPatterns = "/recipeDelete")
public class RecipeDeleteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 从请求中接收参数
        int recipe_id = Integer.parseInt(req.getParameter("recipe_id"));

        try {

            // 查询是否有使用了此配方的处方笺记录
            List<Prescription> prescriptions = new PrescriptionServiceImpl().findByRecipeId(recipe_id);

            if (prescriptions.isEmpty()) {

                // 若没有查询到，则进行删除
                int result = new RecipeServiceImpl().doDelete(recipe_id);

                if (result != 0) {

                    // 若删除成功，重定向至配方列表页面
                    resp.getWriter().print("<script>alert(\"配方删除成功！\");window.location.href = 'recipeList';</script>");

                }

            } else {

                // 若查询到了，则不能删除，须先删除全部使用了此配方的处方笺记录才能删除此配方。重定向至配方列表页面
                resp.getWriter().print("<script>alert(\"有某些病人正在使用此配方，无法删除！请删除相关处方笺记录！\");window.location.href = 'recipeList';</script>");

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
