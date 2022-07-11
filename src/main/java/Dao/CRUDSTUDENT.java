package Dao;

import java.sql.SQLException;
import java.util.List;

public interface CRUDSTUDENT<E> {

    public List<E> selectAll();

    public E select(int id);

    public List<E> selectName(String className);

    public boolean creat(E e) throws SQLException;

    public boolean edit(E e) throws SQLException;

    public boolean delete(int id) throws SQLException;
}
