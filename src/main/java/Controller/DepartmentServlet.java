package Controller;


import Dao.DepartmetDao;
import Model.Department;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/Department")
public class DepartmentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    DepartmetDao departmetDao = new DepartmetDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "createDepartment":
                    createDepartment(req, resp);
                    break;
                case "editDepartment":
                    editDepartment(req, resp);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        RequestDispatcher dispatcher = null;
        try {
            switch (action) {
                case "createDepartment":
                    showCreateDepartment(req, resp);
                    break;
                case "editDepartment":
                    showEditDepartment(req, resp);
                    break;
                case "deleteClassSt":
                    showDeleteDepartment(req, resp);
                    break;
                default:
                    showListDepartment(req, resp);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    //-------------------Hien thi toan bo list students----------------------------
    private void showListDepartment(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, IOException, ServletException {
        List<Department> departments = departmetDao.selectAll();
        req.setAttribute("departments", departments);
        RequestDispatcher dispatcher = req.getRequestDispatcher("Department/DepartmentList.jsp");
        dispatcher.forward(req, resp);
    }


    //-------------------them classSt----------------------------

    private void showCreateDepartment(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("Department/createDepartment.jsp");
        dispatcher.forward(req, resp);
    }


    private void createDepartment(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, IOException, ServletException {
        String className = req.getParameter("name");
        int number = Integer.parseInt(req.getParameter("number"));
        Department department = new Department(className,number);
        departmetDao.creat(department);
        RequestDispatcher dispatcher = req.getRequestDispatcher("Department/createDepartment.jsp");
        req.setAttribute("message", "New Department was created");
        dispatcher.forward(req, resp);
    }

    //-------------------Edit thong tin ClassSt----------------------------

    public void showEditDepartment(HttpServletRequest req,HttpServletResponse resp) throws IOException,SQLException,ServletException{
        int id = Integer.parseInt(req.getParameter("id"));
        Department department = departmetDao.select(id);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Department/editDepartment.jsp");
        req.setAttribute("department", department);
        requestDispatcher.forward(req, resp);
    }

    private void editDepartment(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, IOException, ServletException {
        int classId = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int number = Integer.parseInt(req.getParameter("number"));

        Department book = new Department(classId,name,number);
        departmetDao.edit(book);
        resp.sendRedirect("/Department");
    }


    //-------------------Delete thong tin ClassSt----------------------------

    public void showDeleteDepartment(HttpServletRequest req, HttpServletResponse resp) throws IOException,SQLException,ServletException{
        int id = Integer.parseInt(req.getParameter("id"));
        departmetDao.delete(id);

        List<Department> departments = departmetDao.selectAll();
        req.setAttribute("departments", departments);
        RequestDispatcher dispatcher = req.getRequestDispatcher("Department/DepartmentList.jsp");
        dispatcher.forward(req, resp);
    }
}
