<%-- 病人创建页面 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>病人录入</title>
</head>
<body>
    <h1>病人录入</h1>
    <form action="userCreate" method="post">
        <input name="user_name" type="text" placeholder="姓名"><br>
        <input name="user_age" type="text" placeholder="年龄"><br>
        <input name="user_sex" type="text" placeholder="性别"><br>
        <input name="user_tel" type="text" placeholder="电话"><br>
        <input type="submit" value="录入">
    </form>
    <div>
        <a href="userlogin.jsp">返回病人登录页面</a>
    </div>
</body>
</html>
