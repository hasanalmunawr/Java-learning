package entity;

public class TodoList {

    private String todo;

    //constraktor
    public  TodoList() {}

    public  TodoList(String todo) {
        this.todo = todo;
    }

    //setter getter
    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }
}
