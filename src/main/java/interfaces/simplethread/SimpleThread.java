package interfaces.simplethread;

import java.util.List;

public class SimpleThread  implements Runnable {

    private List<String> tasks;

    @Override
    public void run() {
        while (nextStep()) {
            System.out.println("1");
        }
    }

    public SimpleThread(List<String> tasks) {
        this.tasks = tasks;
    }

    public List<String> getTasks() {
        return tasks;
    }

    private boolean nextStep() {
        if (tasks.size() > 0) {
            tasks.remove(tasks.size() - 1);
            return true;
        } else {
            return false;
        }
    }

}
