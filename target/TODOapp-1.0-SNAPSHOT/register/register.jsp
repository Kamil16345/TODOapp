<%@ page language="java" contentType="text/html; ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>TODO app</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<jsp:include page="../common/header.jsp"></jsp:include>
<div class="container">
    <h2>User Sign Up form</h2>
    <div class="col-md-6 col-md-offset-3">
        <div class="alert alert-success center" role="alert"></div>
        <p>${NOTIFICATION}</p>
    </div>
    <form action="<%=request.getContextPath()%>/register" method="post">
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
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
</html>