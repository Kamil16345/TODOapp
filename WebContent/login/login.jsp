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
            <label for="uname">Login: </label> <input type="text" id="uname" placeholder="Login" name="login" required>
        </div>
        <div class="form-group">
            <label for="uname">Password:</label><input type="password" class="form-control" id="password" placeholder="password" required>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>