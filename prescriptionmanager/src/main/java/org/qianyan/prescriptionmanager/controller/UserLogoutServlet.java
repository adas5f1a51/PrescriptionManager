package org.qianyan.prescriptionmanager.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author dyj123 2020/11/19
 * @Company Qianyan Studio
 * 登出病人信息 Servlet
 */
@WebServlet(name = "userLogout", urlPatterns = "/userLogout")
public class UserLogoutServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 设置会话过期，登出成功
        req.getSession().invalidate();

        // 重定向至病人登入页面
        resp.getWriter().print("<script>alert(\"退出登录成功！\");window.location.href = 'userlogin.jsp';</script>");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

}
