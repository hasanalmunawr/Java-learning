package service;

import entity.TodoList;
import repository.TodoListRepository;
import utilScanner.DataBaseUtil;

import java.sql.*;

public class TodoListServiceImpl implements TodoListService {

    private TodoListRepository todoListRepository;

    public TodoListServiceImpl(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    @Override
    public void showTodoList() {
        System.out.println("=====TODO LIST=====");
        String sql = "SELECT * FROM todolist";
        try (Connection connection = DataBaseUtil.getDataSource().getConnection();
             Statement statement = connection.createStatement()) {
           try (ResultSet resultSet = statement.executeQuery(sql)) {
               while (resultSet.next()) {
                   String id = resultSet.getString("id");
                   String kegiatan = resultSet.getString("kegiatan");

                   System.out.println(
                           String.join(", ", id, kegiatan)
                   );
               }
           }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addTodoList(String todo) {
        TodoList todoList = new TodoList(todo);
        System.out.println("Berhasil menambahkan list baru");
        todoListRepository.add(todoList);
    }


    @Override
    public void editTodoList(int number,String dataBaru) {
        TodoList todoBaru = new TodoList(dataBaru);
        System.out.println("Berhasil merubah list ");
        todoListRepository.edit(number,todoBaru);
    }

    @Override
    public void removeTodoList(int number) {
        boolean bisa = todoListRepository.remove(number);
        String s = (bisa) ? "Berhasil menghapus" : "gagal menghapus";
        System.out.println(s);


    }
}
