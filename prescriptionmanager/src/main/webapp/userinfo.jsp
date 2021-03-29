<%-- 病人信息页面 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="logindetect.jsp"/>
<html>
<head>
    <title>病人信息</title>
</head>
<body>
    <h1>病人信息</h1>
    <div>
        姓名：<c:out value="${sessionScope.user.user_name}"/><br>
        年龄：<c:out value="${sessionScope.user.user_age}"/><br>
        性别：<c:out value="${sessionScope.user.user_sex}"/><br>
        电话：<c:out value="${sessionScope.user.user_tel}"/><br>
    </div>
    <div>
        <a href="userLogout">退出登录</a><br>
        <a href="userupdate.jsp">信息修改</a><br>
        <a href="userDelete">删除该病人</a>
    </div>
    <div>
        <a href="recipeSelect">为此病人开取新处方笺</a><br>
        <a href="prescriptionList">查询此病人的所有处方笺</a>
    </div>
    <div>
        <a href="recipecreate.jsp">创建新配方</a><br>
        <a href="recipeList">查看所有配方</a>
    </div>
</body>
</html>
