<%-- 配方列表页面 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="logindetect.jsp"/>
<html>
<head>
    <title>配方列表</title>
</head>
<body>
    <h1>所有配方列表一览</h1>
    <c:forEach items="${requestScope.recipes}" var="recipe">
        <c:out value="${recipe.recipe_name}"/>：<c:out value="${recipe.recipe_ingredient}"/>
        <a href="recipeDelete?recipe_id=${recipe.recipe_id}">删除此配方</a><br>
    </c:forEach>
    <div>
        <a href="userinfo.jsp">返回病人信息页面</a>
    </div>
</body>
</html>
