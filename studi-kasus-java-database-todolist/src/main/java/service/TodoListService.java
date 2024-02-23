package service;

public interface TodoListService {

    void showTodoList();

    void addTodoList(String todo);

    void editTodoList(int number, String dataBaru);

    void removeTodoList(int number);
}
