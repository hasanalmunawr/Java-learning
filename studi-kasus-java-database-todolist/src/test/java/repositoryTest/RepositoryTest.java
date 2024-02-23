package repositoryTest;

import com.zaxxer.hikari.HikariDataSource;
import entity.TodoList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.TodoListRepository;
import repository.TodoListRepositoryImpl;
import utilScanner.DataBaseUtil;

public class RepositoryTest {

    private HikariDataSource dataSource;
    private  TodoListRepository todoListRepository;

    @BeforeEach
    void setUp() {
        dataSource = DataBaseUtil.getDataSource();
        todoListRepository = new TodoListRepositoryImpl(dataSource);
    }

    @Test
    void testAddTodolist() {
        TodoList todoList = new TodoList();
        todoList.setTodo("main pb");
        todoListRepository.add(todoList);
    }

    @Test
    void testEditTodolist() {
        TodoList newTodo = new TodoList("dinner");
        todoListRepository.edit(2, newTodo);
    }

    @Test
    void testRemoveTodolist() {
        todoListRepository.remove(3);

    }

    @AfterEach
    void tearDown() {
        dataSource.close();
    }
}
