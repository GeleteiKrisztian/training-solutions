package intromethods;

import java.util.ArrayList;
import java.util.List;

public class TodoList {

    private List<Todo> todoList = new ArrayList<>();

    public void addTodo(String caption) {
        Todo todo = new Todo(caption);
        todoList.add(todo);
    }

    public void finishTodos(String caption) {
        for (Todo item : todoList) {
            if(item.getCaption().equals(caption)) {
                item.finish();
            }
        }
    }

    public void finishAllTodos(List<String> todosToFinish) {
        for (String item : todosToFinish) {
            for (Todo todoItem : todoList) {
                if (todoItem.getCaption().equals(item)) {
                todoItem.finish();
                }
            }
        }
    }

    public List<String> todosToFinish() {
        List<String> tempTodos = new ArrayList<>();
        for (Todo item : todoList) {
            if (item.isFinished() != true) {
                tempTodos.add(item.getCaption());
            }
        }
        return tempTodos;
    }

    public int numberOfFinishTodos() {
        int counter = 0;
        for (Todo item : todoList) {
            if (item.isFinished() == false) {
                ++counter;
            }
        }
        return counter;
    }

}
