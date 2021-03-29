package org.qianyan.prescriptionmanager.controller;

import org.qianyan.prescriptionmanager.service.impl.PrescriptionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author dyj123 2020/11/19
 * @Company Qianyan Studio
 * 删除处方笺记录 Servlet
 */
@WebServlet(name = "prescriptionDelete", urlPatterns = "/prescriptionDelete")
public class PrescriptionDeleteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 从请求中接收参数
        Integer prescription_id = Integer.parseInt(req.getParameter("prescription_id"));

        try {

            // 删除此处方笺
            int result = new PrescriptionServiceImpl().doDeleteByPreId(prescription_id);

            if (result != 0) {

                // 若删除成功，重定向至查询所有处方笺 Servlet
                resp.getWriter().print("<script>alert(\"删除处方笺成功！\");window.location.href = 'prescriptionList';</script>");

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
