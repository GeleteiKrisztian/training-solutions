package collectionsqueue;

public class Job implements Comparable {

    private int priority;
    private String job;
    private boolean urgent;

    public Job(int priority, String job) {
        this.priority = priority;
        this.job = job;
        if (priority < 5) {
            urgent = true;
        }
    }

    public int getPriority() {
        return priority;
    }

    public String getJobDescription() {
        return job;
    }

    @Override
    public int compareTo(Object o) {
        Job job = (Job) o;
        if(this.priority == job.getPriority())
            return 0;
        else if(this.priority > job.getPriority())
            return 1;
        else
            return -1;
    }

}
