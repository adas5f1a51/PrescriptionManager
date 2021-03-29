package org.qianyan.prescriptionmanager.controller;

import org.qianyan.prescriptionmanager.domain.User;
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
 * 创建病人信息 Servlet
 */
@WebServlet(name = "userCreate", urlPatterns = "/userCreate")
public class UserCreateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 创建需要保存的病人对象并从请求中接收参数
        User user = new User();
        user.setUser_name(req.getParameter("user_name"));
        user.setUser_age(Integer.parseInt(req.getParameter("user_age")));
        user.setUser_sex(req.getParameter("user_sex"));
        user.setUser_tel(req.getParameter("user_tel"));

        try {

            // 保存到数据库
            int result = new UserServiceImpl().doInsert(user);

            if (result != 0) {

                // 若保存成功，重定向至病人登入页面进行登入
                resp.getWriter().print("<script>alert(\"信息录入成功！\");window.location.href = 'userlogin.jsp';</script>");

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
