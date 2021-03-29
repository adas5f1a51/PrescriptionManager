package org.qianyan.prescriptionmanager.controller;

import org.qianyan.prescriptionmanager.domain.User;
import org.qianyan.prescriptionmanager.domain.UserVo;
import org.qianyan.prescriptionmanager.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author dyj123 2020/11/18
 * @Company Qianyan Studio
 * 登录病人信息 Servlet
 */
@WebServlet(name = "userLogin", urlPatterns = "/userLogin")
public class UserLoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 从请求中接收参数
        String user_name = req.getParameter("user_name");
        String user_tel = req.getParameter("user_tel");

        // 创建需要查询的病人对象并赋予参数
        User userVo = new User();
        userVo.setUser_name(user_name);
        userVo.setUser_tel(user_tel);

        // 创建病人值对象并赋予参数
        UserVo vo = new UserVo();
        vo.setUser(userVo);

        try {

            // 查找此病人记录
            User user = new UserServiceImpl().findByVo(vo);

            if (user != null) {

                // 若查询有此病人，则登录成功，并创建会话
                req.getSession().invalidate();
                req.getSession().setAttribute("user", user);

                // 重定向至病人信息页面
                resp.getWriter().print("<script>alert(\"登录成功\");window.location.href = 'userinfo.jsp';</script>");


            } else {

                // 若查询无此病人，则登录失败，并重定向至创建病人页面
                resp.getWriter().print("<script>alert(\"未查询到此病人信息，请先录入！\");window.location.href = 'usersign.jsp';</script>");

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
