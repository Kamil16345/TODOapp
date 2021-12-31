<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<style>
    .content{
        margin: auto;

        text-align: center;
    }
    .content>h3{
        margin: auto;
        text-align: center;
        width:50%;
    }
    .content>h3>a{
        color:black;

    }
</style>
<!DOCTYPE html>
<html>
<head>
    <title>TODO App</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>
<jsp:include page="common/header.jsp"></jsp:include>
<div class="content">
    <h1><%= "Welcome to my CRUD App."%></h1>
</div>
<div class="content">
    <h1><%="Add your task and maintain it!"%></h1>
</div>
<br/>
<div class="content"><h3><a href="register/register.jsp">Sign Up</a></h3></div>
<div class="content"><h3><a href="login/login.jsp">Sign In</a></h3></div>
<jsp:include page="common/footer.jsp"></jsp:include>
</body>
</html>