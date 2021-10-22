<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: red">
        <div>
            <a href="https://www.google.com" class="navbar-brand">TODOApp</a>
        </div>
        <ul>
            <li><a href="<%= request.getContextPath() %>/login" class="nav-link">login</a></li>
            <li><a href="<%= request.getContextPath()%>/signUp" class="nav-link">sign up</a></li>
        </ul>
    </nav>
</header>