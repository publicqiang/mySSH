<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>
<h2><a href="${pageContext.request.contextPath }/user_findAll.action">查询</a> </h2>

<form action="/user_findAll.action" method="post">
    userName:<input type="text" name="user.userName" value="${user.userName }"/><br/>
    password:<input type="password" name="user.password" value="${user.password }"><br/>
    <input type="submit" value="login"/>
</form>
</body>
</html>
