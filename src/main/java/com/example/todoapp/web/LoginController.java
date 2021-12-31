package com.example.todoapp.web;

import com.example.todoapp.dao.LoginDAO;
import com.example.todoapp.dao.TodoDAO;
import com.example.todoapp.dao.TodoDAOImpl;
import com.example.todoapp.model.LoginBean;
import com.example.todoapp.model.TODO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

//@WebServlet(name = "loginController", value = "/loginController")
@WebServlet("/login")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID=1L;
    private LoginDAO loginDAO;
    private TodoDAO todoDAO;

    public void init(){
        loginDAO = new LoginDAO();
        todoDAO = new TodoDAOImpl();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("login.jsp");
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
        loginBean.setUsername(login);
        loginBean.setPassword(password);
        try {
            System.out.println(loginDAO.validate(loginBean));
            if (loginDAO.validate(loginBean)) {
                List<TODO> listTodo = todoDAO.selectAllTodos();
                request.setAttribute("listTODO", listTodo);
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