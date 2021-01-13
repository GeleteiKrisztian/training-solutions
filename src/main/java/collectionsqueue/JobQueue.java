package collectionsqueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class JobQueue {
    private Deque<Job> jobs = new ArrayDeque<>();

    public Deque<Job> addJobByUrgency(Job... jobs) {
        for (Job item : jobs) {
            if (item.isUrgent()) {
                this.jobs.addFirst(item);
            } else {
                this.jobs.addLast(item);
            }
        }
        return new ArrayDeque<>(this.jobs);
    }

    public Job dispatchUrgentJob(Deque<Job> jobs) throws NoJobException {
        if (isNullOrEmpty(jobs)) {
            throw new NoJobException("No job available, get a rest!");
        }
        return jobs.getFirst();
    }

    public Job dispatchNotUrgentJob(Deque<Job> jobs) throws NoJobException {
        if (isNullOrEmpty(jobs)) {
            throw new NoJobException("No job available, get a rest!");
        }
        return jobs.getLast();
    }

    private boolean isNullOrEmpty(Deque<Job> j) {
        if (j == null || j.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

}
