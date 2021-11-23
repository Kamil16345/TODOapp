<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: red">
        <div>
            <a href="../index.jsp" class="navbar-brand">TODOApp</a>
        </div>
        <ul>
            <li><a href="<%= request.getContextPath() %>/login/login.jsp" class="nav-link">login</a></li>
            <li><a href="<%= request.getContextPath()%>/register/register.jsp" class="nav-link">sign up</a></li>
        </ul>
    </nav>
</header>