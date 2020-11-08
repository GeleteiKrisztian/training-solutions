package intromethods;

public class TodoListMain {

    public static void main(String[] args) {
        TodoList todoList = new TodoList();
        todoList.addTodo("Hétfőn 10:00-kor megbeszélés.");
        todoList.addTodo("Reggel 8-ra ébresztőt állítani be.");
        todoList.addTodo("Este időben lefeküdni.");
        todoList.addTodo("Az időt hétköznap átgondoltam beosztani.");
        System.out.println(todoList.todosToFinish());

        todoList.finishTodos("Este időben lefeküdni.");
        System.out.println(todoList.todosToFinish());

        System.out.println("Feladatok,amiket be kell még fejezni: " + todoList.numberOfFinishTodos());
        System.out.println("Összes feladat befejezése metódus meghívása...");
        todoList.finishAllTodos(todoList.todosToFinish());
        System.out.println("Feladatok,amiket be kell még fejezni: " + todoList.numberOfFinishTodos());
    }
}
