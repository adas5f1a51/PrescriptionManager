<%-- 错误处理页面 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>服务器错误页面</title>
</head>
<body>
    <h1>出错了</h1>
    处理您的请求时发生错误！请确认您通过正确途径操作。
    <p style="color: red">
        <%=request.getAttribute("error")%>
    </p>
</body>
</html>
