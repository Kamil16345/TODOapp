package com.example.todoapp.web;

/*import com.example.todoapp.dao.TodoDAO;
import com.example.todoapp.dao.TodoDAOImpl;
import com.example.todoapp.model.TODO;
import com.example.todoapp.utils.JDBCUtils;

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
                    RequestDispatcher dispatcher = request.getRequestDispatcher("../todo/todo-list.jsp");
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
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("todo/todo-form.jsp");
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

 */
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.todoapp.dao.TodoDAO;
import com.example.todoapp.dao.TodoDAOImpl;
import com.example.todoapp.dao.TodoDAO;
import com.example.todoapp.dao.TodoDAOImpl;
import com.example.todoapp.model.TODO;


@WebServlet("/")
public class TODOController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private TodoDAO todoDAO;

    public void init() {
        todoDAO = new TodoDAOImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertTodo(request, response);
                    break;
                case "/delete":
                    deleteTodo(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateTodo(request, response);
                    break;
                case "/list":
                    listTodo(request, response);
                    break;
                default:
                    RequestDispatcher dispatcher = request.getRequestDispatcher("login/login.jsp");
                    dispatcher.forward(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listTodo(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List < TODO > listTodo = todoDAO.selectAllTodos();
        request.setAttribute("listTODO", listTodo);
        RequestDispatcher dispatcher = request.getRequestDispatcher("todo/todo-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("todo/todo-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        TODO existingTodo = todoDAO.selectTODO(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("todo/todo-form.jsp");
        request.setAttribute("todo", existingTodo);
        dispatcher.forward(request, response);

    }

    private void insertTodo(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

        String title = request.getParameter("title");
        String username = request.getParameter("username");
        String description = request.getParameter("description");

        /*DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-mm-dd");
        LocalDate targetDate = LocalDate.parse(request.getParameter("targetDate"),df);*/

        boolean isDone = Boolean.valueOf(request.getParameter("isDone"));
        TODO newTodo = new TODO(title, username, description, LocalDate.now(), isDone);
        todoDAO.insertTODO(newTodo);
        response.sendRedirect("list");
    }

    private void updateTodo(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        String title = request.getParameter("title");
        String username = request.getParameter("username");
        String description = request.getParameter("description");
        //DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-mm-dd");
        LocalDate targetDate = LocalDate.parse(request.getParameter("targetDate"));

        boolean isDone = Boolean.valueOf(request.getParameter("isDone"));
        TODO updateTodo = new TODO(id, title, username, description, targetDate, isDone);

        todoDAO.updateTodo(updateTodo);

        response.sendRedirect("list");
    }
    private void deleteTodo(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        todoDAO.deleteTodo(id);
        response.sendRedirect("list");
    }
}