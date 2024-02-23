package view;

import service.TodoListService;
import utilScanner.InputUser;

public class TodoListView {

    private TodoListService todoListService;

    public TodoListView(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    public void showTodoList() {
//        boolean isLanjut = true;
        while (true) {
            todoListService.showTodoList();
            System.out.println("\n\n=====MENU=====");
            System.out.println("1. Add todo list ");
            System.out.println("2. Edit todo list ");
            System.out.println("3. Remove todo list ");
            System.out.println("0. Out for Program \n\n");

               String choiceUser = InputUser.inputStr("Input your choice use number = ");

            if(choiceUser.equals("1")) {
                addTodoList();
            } else if (choiceUser.equals("2")) {
                editTodoList();
            } else if (choiceUser.equals("3")) {
                removeTodoList();
            } else if (choiceUser.equals("0")) {
                break;
            } else {
                System.out.println("Input missing understand for system!");
            }
           yesOrNo();
        }
        System.out.println("Final from program ");

    }


    public  void addTodoList() {
        String inputAdd = InputUser.inputStr("Input your todo to add = ");
        todoListService.addTodoList(inputAdd);
    }

    public  void editTodoList() {
        String inputEditTodo = InputUser.inputStr("Input your todo want to change = ");
        int inputEdit = InputUser.inputInt("Input number want you edit = ");
        todoListService.editTodoList(inputEdit,inputEditTodo);
    }

    public  void removeTodoList() {
        int inputRemove = InputUser.inputInt("Input number that you want remove = ");
        todoListService.removeTodoList(inputRemove);
    }

    private  static  boolean yesOrNo() {
        String inputYesNo = InputUser.inputStr("do you want to continue program ? (y/n) = \n");
//        boolean isContinue = (inputYesNo.equals("Y")) ? true : false ;
            boolean isLanjut = true;
            if(inputYesNo.equals("Y")) {
               isLanjut = true;
            } else {
                isLanjut = false;
            }
        return isLanjut;

    }

}
