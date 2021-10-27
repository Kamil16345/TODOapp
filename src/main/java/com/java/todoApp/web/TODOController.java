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
        String login = request.getParameter("login");
        boolean isDone = Boolean.valueOf(request.getParameter("isDone"));
        TODO Todo = new TODO(title, login, description, LocalDate.now(), isDone);
    }
    private void updateTODO(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
        int id = Integer.parseInt(request.getParameter("title"));

        String title = request.getParameter("title");
        String login = request.getParameter("login");
        String description = request.getParameter("description");
        LocalDate targetDate = LocalDate.parse(request.getParameter("targetDate"));

        boolean isDone = Boolean.valueOf(request.getParameter("isDone"));
        TODO updateTODO = new TODO(id, title, login, description, targetDate, isDone);

        todoDao.updateTodo(updateTODO);
        response.sendRedirect("list");
    }
    private void deleteTODO(HttpServletRequest request, HttpServletResponse response )throws SQLException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        todoDao.deleteTodo(id);
        response.sendRedirect("list");
    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException{
            int id = Integer.parseInt(request.getParameter("id"));
            TODO existingTodo = todoDao.selectTODO(id);
            RequestDispatcher dispatcher = request.getRequestDispatcher("todo/todo-form.jsp");
            request.setAttribute("todo", existingTodo);
            dispatcher.forward(request, response);
    }
}