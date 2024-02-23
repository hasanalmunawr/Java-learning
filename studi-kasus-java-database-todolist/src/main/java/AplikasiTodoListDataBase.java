import com.zaxxer.hikari.HikariDataSource;
import repository.TodoListRepository;
import repository.TodoListRepositoryImpl;
import service.TodoListService;
import service.TodoListServiceImpl;
import view.TodoListView;

public class AplikasiTodoListDataBase {

    public static void main(String[] args) {

        HikariDataSource dataSource = new HikariDataSource();

        TodoListRepository todoListRepository = new TodoListRepositoryImpl(dataSource);
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
        TodoListView todoListView = new TodoListView(todoListService);


        todoListView.showTodoList();


    }
}
