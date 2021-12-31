<style>
    .header{
        background-color: #3B5998;
        color:white;
    }
    a{
        color:white;
    }
</style>
<header class="header">
    <nav class="navbar navbar-expand-md navbar-dark">
        <div>
            <a href="index.jsp" class="navbar-brand">TODOApp</a>
        </div>
            <a href="<%= request.getContextPath()%>/register/register.jsp" class="nav-link">Sign Up</a>
            <a href="<%= request.getContextPath() %>/login/login.jsp" class="nav-link" >Sign In</a>
    </nav>
</header>