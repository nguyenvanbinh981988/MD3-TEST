package Dao;

import Connection_MySQL.ConnectionMySQL;
import Model.Department;
import Model.Staff;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class StaffDao implements CRUDSTUDENT<Staff> {
    DepartmetDao departmetDao = new DepartmetDao();

    @Override
    public List<Staff> selectAll() {
        String spl = "SELECT * FROM STAFF;";
        List<Staff> staffs = new ArrayList<>();
        try (Connection connection = ConnectionMySQL.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(spl);) {
            ResultSet resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Date birthDayDate = resultSet.getDate("birthDay");
                LocalDate birthDay = birthDayDate.toLocalDate();
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                Department department = departmetDao.select(resultSet.getInt("id"));

                staffs.add(new Model.Staff(id, name, birthDay, address, phone, email, department));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return staffs;
    }

    //----------------------------SELECT A Student----------------------------------


    public Staff select(int id) {
        String sql = "select * from STAFF where id =" + id;
        try (Connection connection = ConnectionMySQL.getConnect()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            resultSet.next();
            int idS = resultSet.getInt("id");
            String name = resultSet.getString("name");
            LocalDate birthDay = LocalDate.parse(resultSet.getString("birthDay"));
            String phone = resultSet.getString("phone");
            String address = resultSet.getString("address");
            String email = resultSet.getString("email");
            Department department = departmetDao.select(resultSet.getInt("id"));

            return new Staff(idS, name, birthDay, address, email, phone, department);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }


    //----------------------------CREATE----------------------------------


    public boolean creat(Staff staff) throws SQLException {
        String spl = "INSERT INTO STAFF (name , birthDay,address,phone,email,departmentid) VALUES (?,?,?,?,?,?);";
        try (Connection connection = ConnectionMySQL.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(spl);) {

            preparedStatement.setString(1, staff.getName());
            preparedStatement.setString(2, String.valueOf(staff.getBirthDay()));
            preparedStatement.setString(3, staff.getAddress());
            preparedStatement.setString(4, staff.getPhone());
            preparedStatement.setString(5, staff.getEmail());
            preparedStatement.setInt(6, staff.getDepartment().getId());

            return preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //----------------------------EDIT----------------------------------

    public boolean edit(Staff staff) throws SQLException {
        String sql = "update STAFF set name = ?,birthDay = ?,address=?,phone=?,email=?,departmentid=? where Id = ?;";

        try (Connection connection = ConnectionMySQL.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(7, staff.getId());
            preparedStatement.setString(1, staff.getName());
            preparedStatement.setString(2, String.valueOf(staff.getBirthDay()));
            preparedStatement.setString(3, staff.getAddress());
            preparedStatement.setString(4, staff.getPhone());
            preparedStatement.setString(5, staff.getEmail());
            preparedStatement.setInt(6, staff.getDepartment().getId());

            return preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    //----------------------------DELETE----------------------------------
    public boolean delete(int id) throws SQLException {
        String sql = "DELETE FROM STAFF WHERE id = ? ";
        boolean rowDelete;

        try (Connection connection = ConnectionMySQL.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        }
        return rowDelete;
    }

    //----------------------------FIND----------------------------------
    public List<Staff> selectName(String name) {
        List<Staff> staffs = new ArrayList<>();
        String sql = "select * from STAFF where name like concat('%',?,'%')";
        try (Connection connection = ConnectionMySQL.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, name);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int ids = resultSet.getInt("id");
                String name1 = resultSet.getString("name");
                LocalDate birthDay = LocalDate.parse(resultSet.getString("birthDay"));
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                Department department = departmetDao.select(resultSet.getInt("id"));


                Staff staff = new Staff(ids, name1, birthDay, phone, address, email, department);
                staffs.add(staff);
            }


            return staffs;


        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return null;

    }

}


