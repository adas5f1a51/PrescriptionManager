<%-- 病人登录页面 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>病人查询</title>
</head>
<body>
    <h1>病人查询</h1>
    <form action="userLogin" method="post">
        <input name="user_name" type="text" placeholder="姓名"><br>
        <input name="user_tel" type="text" placeholder="电话"><br>
        <input type="submit" value="登录">
    </form>
    <div>
        <a href="usersign.jsp">新病人信息录入</a>
    </div>
</body>
</html>
