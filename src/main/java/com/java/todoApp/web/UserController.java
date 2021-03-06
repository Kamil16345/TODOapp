package com.java.todoapp.web;

import com.java.todoapp.dao.UserDAO;
import com.java.todoapp.model.User;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class UserController extends HttpServlet {
    private static final long serialVersionUID =1L;
    private UserDAO userDao;

    public void init(){
        userDao= new UserDAO();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
            register(request, response);
        }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
            response.sendRedirect("register/register.jsp");
        }

    private void register(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String firstName=request.getParameter("firstName");
        String lastName= request.getParameter("lastName");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUsername(username);
        user.setPassword(password);

        try{
            int result = userDao.registerUser(user);
            if (result==1){
                request.setAttribute("NOTIFICATION", "User Registered correctly.");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("register/register.jsp");
        dispatcher.forward(request, response);
    }
}
