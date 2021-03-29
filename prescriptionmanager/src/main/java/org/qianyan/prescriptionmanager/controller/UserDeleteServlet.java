package org.qianyan.prescriptionmanager.controller;

import org.qianyan.prescriptionmanager.domain.User;
import org.qianyan.prescriptionmanager.service.impl.PrescriptionServiceImpl;
import org.qianyan.prescriptionmanager.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author dyj123 2020/11/19
 * @Company Qianyan Studio
 * 删除病人信息 Servlet
 */
@WebServlet(name = "userDelete", urlPatterns = "/userDelete")
public class UserDeleteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 创建病人对象并从会话中接收参数
        User user = (User) req.getSession().getAttribute("user");

        try {

            // 删除此病人的所有处方笺记录
            new PrescriptionServiceImpl().doDeleteByUserId(user.getUser_id());

            // 删除此病人记录
            int result = new UserServiceImpl().doDelete(user.getUser_id());

            if (result != 0) {

                // 若删除成功，则结束会话
                req.getSession().invalidate();

                // 重定向至病人登录页面
                resp.getWriter().print("<script>alert(\"删除成功！感谢使用！\");window.location.href = 'userlogin.jsp';</script>");

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
