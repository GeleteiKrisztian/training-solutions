package collectionsqueue;

import java.util.PriorityQueue;
import java.util.Queue;

public class JobDispatcher {

    Queue<Job> jobs = new PriorityQueue<>();

    public Queue<Job> addJob(Job... jobs) {
        for (Job item : jobs) {
            this.jobs.add(item);
        }
        return new PriorityQueue<Job>(this.jobs);
    }

    public Job dispatchNextJob(Queue<Job> jobs) throws NoJobException {
        if (jobs == null || jobs.size() == 0) {
            throw new NoJobException("No job available, get a rest!");
        }
        return jobs.element();
    }

}
