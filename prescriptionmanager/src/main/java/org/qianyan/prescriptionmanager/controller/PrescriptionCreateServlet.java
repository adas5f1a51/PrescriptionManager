package org.qianyan.prescriptionmanager.controller;

import org.qianyan.prescriptionmanager.domain.Prescription;
import org.qianyan.prescriptionmanager.domain.User;
import org.qianyan.prescriptionmanager.service.impl.PrescriptionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author dyj123 2020/11/19
 * @Company Qianyan Studio
 * 创建处方笺记录 Servlet
 */
@WebServlet(name = "prescriptionCreate", urlPatterns = "/prescriptionCreate")
public class PrescriptionCreateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 创建病人对象并从会话中接收参数
        User user = (User) req.getSession().getAttribute("user");

        // 创建该病人的处方笺对象并赋予参数
        Prescription prescription = new Prescription();
        prescription.setRecipe_id(Integer.parseInt(req.getParameter("recipe_id")));
        prescription.setUser_id(user.getUser_id());
        prescription.setPrescription_date(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));

        try {

            // 保存到数据库
            int result = new PrescriptionServiceImpl().doInsert(prescription);

            if (result != 0) {

                // 若保存成功，重定向至创建处方笺页面
                resp.getWriter().print("<script>alert(\"处方笺创建成功！\");window.location.href = 'prescriptioncreate.jsp';</script>");

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
