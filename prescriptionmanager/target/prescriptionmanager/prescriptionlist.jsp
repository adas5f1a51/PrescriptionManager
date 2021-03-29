<%-- 病人处方笺列表页面 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="logindetect.jsp"/>
<html>
<head>
    <title>处方笺列表</title>
</head>
<body>
    <h1>此病人的所有处方笺如下</h1>
    <c:forEach items="${requestScope.prescriptions}" var="prescription">
        配方名：<c:out value="${prescription.recipe_name}"/>
        创建时间：<c:out value="${prescription.prescription_date}"/>
        <a href="prescriptionDelete?prescription_id=${prescription.prescription_id}">删除此处方笺</a><br>
    </c:forEach>
    <div>
        <a href="userinfo.jsp">返回病人信息页面</a>
    </div>
</body>
</html>
