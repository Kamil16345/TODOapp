package com.java.todoApp.web;

import com.java.todoApp.dao.LoginDAO;
import com.java.todoApp.model.LoginBean;
import com.java.todoApp.utils.JDBCUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    private static final long serialVerionUID=1L;
    private LoginDAO loginDAO;

    public void init(){
        loginDAO = new LoginDAO();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.sendRedirect("login/login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        authenticate(request, response);
    }
    private void authenticate(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        LoginBean loginBean = new LoginBean();
        loginBean.setLogin(login);
        loginBean.setPassword(password);
        try {
            if (loginDAO.validate(loginBean)) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("todo/todo-list.jsp");
                dispatcher.forward(request, response);
            }
            else{
                HttpSession session = request.getSession();
            }
        }
           catch(ClassNotFoundException ex){
               ex.printStackTrace();
            }

    }
}
