<%-- 创建处方笺页面 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="logindetect.jsp"/>
<html>
<head>
    <title>创建新处方笺</title>
</head>
<body>
    <h1>给病人创建新处方笺</h1>
    <p>选择配方</p>
    <form action="prescriptionCreate" method="post">
        <select name="recipe_id">
            <option selected="selected">==请选择==</option>
            <c:forEach items="${requestScope.recipes}" var="recipe">
                <option value="${recipe.recipe_id}">${recipe.recipe_id}:${recipe.recipe_name}</option>
            </c:forEach>
        </select>
        <input type="submit" value="创建">
    </form>
    <div>
        <a href="userinfo.jsp">返回病人信息页面</a>
    </div>
</body>
</html>
