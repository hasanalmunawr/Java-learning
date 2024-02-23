package repository;

import com.zaxxer.hikari.HikariDataSource;
import entity.TodoList;

public interface TodoListRepository {

    HikariDataSource getAll();

    void add(TodoList todoList);

    void edit(int number, TodoList data);

    boolean remove(int number);
}
