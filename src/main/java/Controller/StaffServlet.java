package Controller;

import Dao.CRUD;
import Dao.CRUDSTUDENT;
import Dao.DepartmetDao;
import Dao.StaffDao;
import Model.Department;
import Model.Staff;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "StafServlet", urlPatterns = "/Staff")
public class StaffServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private CRUDSTUDENT staffDao = new StaffDao();

    private CRUD departmentDao = new DepartmetDao();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    create(req, resp);
                    break;
                case "edit":
                    edit(req, resp);
                    break;
                case "find":
                    find(req, resp);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create":
                    showCreate(req, resp);
                    break;
                case "edit":
                    showEdit(req, resp);
                    break;
                case "delete":
                    showDelete(req, resp);
                    break;
                case "find":
                    showFind(req, resp);
                    break;
                default:
                    showListStudent(req, resp);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    //-------------------Hien thi toan bo list students----------------------------
    private void showListStudent(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, IOException, ServletException {
        List<Staff> staffs = staffDao.selectAll();
        req.setAttribute("staffs", staffs);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);
    }


    //-------------------them student----------------------------

    private void showCreate(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("departments",departmentDao.selectAll());
        RequestDispatcher dispatcher = req.getRequestDispatcher("Staff/create.jsp");
        dispatcher.forward(req, resp);
    }


    private void create(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, IOException, ServletException {
        String name = req.getParameter("name");
        LocalDate birthDay = LocalDate.parse(req.getParameter("birthDay"));
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        int id = Integer.parseInt(req.getParameter("id"));
        Department department = (Department) departmentDao.select(id);
        Staff newStaff = new Staff(name, birthDay,address,phone,email, department);
        staffDao.creat(newStaff);
        RequestDispatcher dispatcher = req.getRequestDispatcher("Staff/create.jsp");
        req.setAttribute("message", "New Staff was created");
        dispatcher.forward(req, resp);
    }


    //-------------------Edit thong tin student----------------------------

    public void showEdit(HttpServletRequest req,HttpServletResponse resp) throws IOException,SQLException,ServletException{
        int id = Integer.parseInt(req.getParameter("id"));
        Staff staff = (Staff) staffDao.select(id);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Staff/edit.jsp");
        req.setAttribute("staff", staff);
        requestDispatcher.forward(req, resp);
    }

    private void edit(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        LocalDate birthDay = LocalDate.parse(req.getParameter("birthDay"));
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");

        String nameD = req.getParameter("department").replaceAll(" ", "");

        Department department = (Department) departmentDao.selectName(nameD);

        Staff book = new Staff(id,name,birthDay,address,phone,email,department);
        staffDao.edit(book);
        resp.sendRedirect("/Staff");
    }


    //-------------------Delete thong tin Student----------------------------

    public void showDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException,SQLException,ServletException{
        int id = Integer.parseInt(req.getParameter("id"));
        staffDao.delete(id);

        List<Staff> staffs =  staffDao.selectAll();
        req.setAttribute("staffs", staffs);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);
    }


    //-------------------find by Name----------------------------

    public void showFind(HttpServletRequest req, HttpServletResponse resp) throws IOException,SQLException,ServletException{
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Staff/find.jsp");
        requestDispatcher.forward(req,resp);
    }

    public void find(HttpServletRequest req,HttpServletResponse resp) throws IOException,SQLException,ServletException{
        String name = req.getParameter("name");
        List<Staff> findStaffs = staffDao.selectName(name);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Staff/find.jsp");
        req.setAttribute("findStaffs", findStaffs);
        requestDispatcher.forward(req, resp);
    }
}