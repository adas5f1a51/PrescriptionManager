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
 * 修改病人信息 Servlet
 */
@WebServlet(name = "userUpdate", urlPatterns = "/userUpdate")
public class UserUpdateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 创建病人对象
        User user = new User();

        // 为保险起见，若某病人信息的某参数为空则使用原信息作为参数，判断如下
        User userOriginal = (User) req.getSession().getAttribute("user");
        user.setUser_id(userOriginal.getUser_id());
        if (req.getParameter("user_name").equals("")) {
            user.setUser_name(userOriginal.getUser_name());
        } else {
            user.setUser_name(req.getParameter("user_name"));
        }

        if (req.getParameter("user_age").equals("")) {
            user.setUser_age(userOriginal.getUser_age());
        } else {
            user.setUser_age(Integer.parseInt(req.getParameter("user_age")));
        }

        if (req.getParameter("user_sex").equals("")) {
            user.setUser_sex(userOriginal.getUser_sex());
        } else {
            user.setUser_sex(req.getParameter("user_sex"));
        }

        if (req.getParameter("user_tel").equals("")) {
            user.setUser_tel(userOriginal.getUser_tel());
        } else {
            user.setUser_tel(req.getParameter("user_tel"));
        }

        try {

            // 提交修改
            int result = new UserServiceImpl().doUpdate(user);

            if (result != 0) {

                // 若修改成功，则更新会话
                req.getSession().setAttribute("user", user);

                // 重定向至病人信息页面
                resp.getWriter().print("<script>alert(\"病人信息修改成功！\");window.location.href = 'userinfo.jsp';</script>");

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
