<%@ page language="java" contentType="text/html; ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>TODO app</title>

</head>
<body>
<jsp:include page="../common/header.jsp"></jsp:include>
<div class="container">
    <h2>User Sign Up form</h2>
    <div class="col-md-6 col-md-offset-3">
        <div class="alert alert-success center" role="alert"></div>
        <p>${NOTIFICATION}</p>
    </div>
    <form action="<%=request.getContextPath()%>/register" method="post"></form>
    <div class="form-group">
        <label for="uname">First name:</label> <input type="text" class="form-control" id="uname" placeholder="First name" name="firstName" required>
    </div>
    <div class="form-group">
        <label for="uname">Last name:</label><input type="text" class="form-control" id="lastName" placeholder="First name" name="lastName" required>
    </div>
    <div class="form-group">
        <label for="uname">Login:</label><input type="text" class="form-control" id="login" placeholder="First name" name="username" required>
    </div>
    <div class="form-group">
        <label for="uname">Password:</label><input type="password" class="form-control" id="password" placeholder="First name" name="password" required>
    </div>
</div>
</body>
</html>