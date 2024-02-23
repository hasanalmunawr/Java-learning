package serviceTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.TodoListRepository;
import repository.TodoListRepositoryImpl;
import service.TodoListService;
import service.TodoListServiceImpl;
import utilScanner.DataBaseUtil;

public class ServiceTest {

    private TodoListService todoListService;

    private TodoListRepository todoListRepository;

    @BeforeEach
    void setUp() {
        todoListService = new TodoListServiceImpl(todoListRepository);
    }



    @Test
    void testViewTodolist() {
        todoListService.showTodoList();
    }
}
