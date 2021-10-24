<%@ page language="java" contentType="text/html; ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>TODO app</title>
    </head>
<body>
    <jsp:include page="../common/header.jsp"></jsp:include>
<div class="container col-md-8 col-md-offset-3" style="overflow: auto">
    <h1>Login Form</h1>
    <form action="<%=request.getContextPath()%>/login" mathod="post">
        <div class="form-group">
            <label for="uname">User Name: </label> <input type="text" id="uname" placeholder="User Name" name="username required">
        </div>
    </form>
</div>
</body>
</html>