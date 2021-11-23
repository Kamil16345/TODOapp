<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>TODOApp Form</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>
<header>
    <nav class="navbar navbar-expand-md navbar-dark"
        style="background-color: crimson">
        <h1>TODO App</h1>
        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/list"
                class="nav-link">TODOs</a>
            </li>
        </ul>
        <ul class="navbar-nav navbar-collapse justify-content-end">
            <li>
                <a href="<%=request.getContextPath()%>"
                   class="nav-link">Logout</a>
            </li>
        </ul>
    </nav>
</header>

<div class="container col-md-5">
    <div class="card">
        <form class="card-body">
            <c:if test="${todo!=null}">
                <form action ="update" method="post">

                </form>
            </c:if>
            <c:if test="${todo==null}">
                <form action="insert" method="post"></form>
            </c:if>
            <caption>
                <h2>
                    <c:if test="${todo!=null}">
                        Add new TODO
                    </c:if>
                </h2>
            </caption>
            <c:if test="${todo !=null}">
                <input type="hidden" name="id" value="<c:out value='${todo.id}'/>"/>
            </c:if>

            <fieldset class="form-group">
                <label>Todo Status</label><select class="form-control" name="isDone">
                <option value="false">In progress</option>
                <option value="true">Complete</option>
            </select>
            </fieldset>
            <fieldset class="form-group">
                <label>Todo Target Date</label> <input type="date"
                       value="<c:out value='${todo.targetDate}'/>" class="form-control"
                        name="targetDate" required="required">
            </fieldset>
            <button type="submit" class="btn btn-success">Save</button>
        </form>
        </div>
    </div>
</div>
<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>