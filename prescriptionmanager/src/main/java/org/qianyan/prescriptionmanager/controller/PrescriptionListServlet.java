package org.qianyan.prescriptionmanager.controller;

import org.qianyan.prescriptionmanager.domain.PrescriptionWithRecipeName;
import org.qianyan.prescriptionmanager.domain.User;
import org.qianyan.prescriptionmanager.service.impl.PrescriptionServiceImpl;

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
 * 查询病人的所有处方笺信息 Servlet
 */
@WebServlet(name = "prescriptionList", urlPatterns = "/prescriptionList")
public class PrescriptionListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 创建病人对象并从会话中接收参数
        User user = (User) req.getSession().getAttribute("user");

        try {

            // 查询此病人全部带有配方名的处方笺
            List<PrescriptionWithRecipeName> prescriptionsWithRecipeName = new PrescriptionServiceImpl().findWithRecipeNameByUserId(user.getUser_id());

            if (!prescriptionsWithRecipeName.isEmpty()) {

                // 若查询到记录，则将此记录集合传入请求
                req.setAttribute("prescriptions", prescriptionsWithRecipeName);

                // 转发给
                req.getRequestDispatcher("prescriptionlist.jsp").forward(req, resp);

            } else {

                // 若没有查询到记录，则重定向至病人信息页面
                resp.getWriter().print("<script>alert(\"未查询到任何此病人的处方笺信息！请创建新处方笺\");window.location.href = 'userinfo.jsp';</script>");

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


