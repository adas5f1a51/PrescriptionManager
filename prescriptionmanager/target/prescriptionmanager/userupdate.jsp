<%-- 修改病人信息页面 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="logindetect.jsp"/>
<html>
<head>
    <title>病人信息修改</title>
</head>
<body>
    <h1>病人信息修改</h1>
    <form action="userUpdate" method="post">
        <input name="user_name" type="text" placeholder="姓名" value="${sessionScope.user.user_name}"><br>
        <input name="user_age" type="text" placeholder="年龄" value="${sessionScope.user.user_age}"><br>
        <input name="user_sex" type="text" placeholder="性别" value="${sessionScope.user.user_sex}"><br>
        <input name="user_tel" type="text" placeholder="电话" value="${sessionScope.user.user_tel}"><br>
        <input type="submit" value="确认修改">
    </form>
    <div>
        <a href="userinfo.jsp">返回病人信息</a>
    </div>
</body>
</html>
