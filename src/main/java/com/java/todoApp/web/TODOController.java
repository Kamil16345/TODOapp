package com.java.todoApp.web;

import com.java.todoApp.dao.TodoDAO;
import com.java.todoApp.dao.TodoDAOImpl;
import com.java.todoApp.model.TODO;
import com.java.todoApp.utils.JDBCUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/")
public class TODOController extends HttpServlet {
    private static final long SerialVersionUID=1L;
    private TodoDAO todoDao;

    public void init(){
        todoDao= new TodoDAOImpl();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        doGet(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertTODO(request, response);
                    break;
                case "/delete":
                    deleteTODO(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateTODO(request, response);
                    break;
                case "/list":
                    listTODO(request, response);
                    break;
                default:
                    RequestDispatcher dispatcher = request.getRequestDispatcher("login/login.jsp");
                    dispatcher.forward(request, response);
            }
        }catch(SQLException exception){
            JDBCUtils.printSQLException(exception);
        }
    }
    private void listTODO(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException{
        List<TODO> listTODO = todoDao.selectAllTodos();
        request.setAttribute("listTODO", listTODO);
        RequestDispatcher dispatcher = request.getRequestDispatcher("todo/todo-list.sjp");
        dispatcher.forward(request, response);
    }
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("todo/todo-form.sjp");
        dispatcher.forward(request, response);
    }
    private void insertTODO(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String username = request.getParameter("username");
        boolean isDone = Boolean.valueOf(request.getParameter("isDone"));
        TODO Todo = new TODO(title, username, description, LocalDate.now(), isDone);
    }
}
