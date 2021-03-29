<%-- 配方信息录入页面 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="logindetect.jsp"/>
<html>
<head>
    <title>配方录入</title>
</head>
<body>
    <h1>录入新配方</h1>
    <form action="recipeCreate" method="post">
        <input name="recipe_name" type="text" placeholder="配方名">
        <input name="recipe_ingredient" type="text" placeholder="配方药材">
        <input type="submit" value="录入">
    </form>
    <div>
        <a href="userinfo.jsp">返回病人信息页面</a>
    </div>
</body>
</html>
