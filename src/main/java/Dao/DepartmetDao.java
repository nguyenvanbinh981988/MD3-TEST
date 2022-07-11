package Dao;

import Connection_MySQL.ConnectionMySQL;
import Model.ClassSt;
import Model.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DepartmetDao implements CRUD<Department> {

    public DepartmetDao() {}

    @Override
    public List<Department> selectAll() {
        String spl = "SELECT * FROM DEPARTMENT;";
        List<Department> departments = new ArrayList<>();
        try (Connection connection =  ConnectionMySQL.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(spl);) {
            ResultSet resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String className = resultSet.getString("name");
                int number = resultSet.getInt("number");

                departments.add(new Department(id, className, number));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return departments;
    }

    //----------------------------SELECT A CLASS----------------------------------

    public Department select(int id){
        String sql = "select * from DEPARTMENT where id =?;";
        Department department = null;

        try (Connection connection =  ConnectionMySQL.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            rs.next();
                String classname = rs.getString("name");
                int number = rs.getInt("number");
                department = new Department(id,classname,number);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return department;
    }


    //----------------------------CREATE----------------------------------


    public boolean creat(Department department) throws SQLException {
        String spl = "INSERT INTO DEPARTMENT (name, Number) VALUES (?,?);";
        try (Connection connection =  ConnectionMySQL.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(spl);) {
            preparedStatement.setString(1, department.getName());
            preparedStatement.setInt(2, department.getNumber());

            return preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //----------------------------EDIT----------------------------------

    public boolean edit(Department department) throws SQLException{
        String sql = "update DEPARTMENT set name = ?, Number =? where id = ?;";
        boolean rowEdit;
        try (Connection connection =  ConnectionMySQL.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, department.getName());
            preparedStatement.setInt(2, department.getNumber());
            preparedStatement.setInt(3, department.getId());

            rowEdit = preparedStatement.executeUpdate() > 0;
        }

        return rowEdit;
    }

    //----------------------------DELETE----------------------------------
    public boolean delete(int id) throws SQLException{
        String sql = "DELETE FROM DEPARTMENT WHERE id = ?;";
        boolean rowDelete;

        try (Connection connection =  ConnectionMySQL.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        }
        return rowDelete;
    }

//----------------------------FIND----------------------------------

    public Department selectName(String name){
        String sql = "select * from DEPARTMENT where name =?;";
        Department department = null;

        try (Connection connection =  ConnectionMySQL.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, name);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            rs.next();
            int id = rs.getInt("id");
            int number = rs.getInt("number");
            department = new Department(id,name,number);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return department;
    }
}


