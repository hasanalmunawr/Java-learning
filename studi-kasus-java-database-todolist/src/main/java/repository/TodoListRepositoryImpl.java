package repository;

import com.zaxxer.hikari.HikariDataSource;
import entity.TodoList;
import utilScanner.DataBaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class TodoListRepositoryImpl implements TodoListRepository {

    private   TodoList[] data = new TodoList[10];
    private HikariDataSource dataSource;

    public TodoListRepositoryImpl(TodoList[] data) {
        this.data = data;
    }

    public TodoListRepositoryImpl(HikariDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public HikariDataSource getAll() {
        return dataSource;
    }

    @Override
    public void add(TodoList todoList) {
        String sql = " INSERT INTO todolist(kegiatan) VALUES (?) ";
        try (Connection connection = DataBaseUtil.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, todoList.getTodo());
            statement.executeUpdate();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void edit(int number,TodoList todoList) {
        String sql = "UPDATE todolist SET kegiatan = ? WHERE id = ? ";
        try (Connection connection = DataBaseUtil.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, todoList.getTodo());
            statement.setInt(2, number);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean remove(int number) {
        String sql = "DELETE FROM todolist WHERE id = ? ";
        try (Connection connection = DataBaseUtil.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, number);
            int isSucces = statement.executeUpdate();
            if(isSucces != 0) {
                return  true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }


    private boolean checkIsNull() {
        String sql = "SELECT * FROM todolist";
        try (Connection connection = DataBaseUtil.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.executeUpdate();
            try (ResultSet resultSet = statement.executeQuery()){
                if(resultSet.next()) {
                    return true;
                } else {
                    return  false;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
