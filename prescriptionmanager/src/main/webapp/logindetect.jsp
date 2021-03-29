<%-- 检查是否登录 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if (request.getSession().getAttribute("user") == null) {
        response.getWriter().print("<script>alert(\"检测到没有登录病人信息，请重新登录\");window.location.href = 'userlogin.jsp';</script>");
    }
%>
