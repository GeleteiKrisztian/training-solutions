package schoolrecords;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private List<Mark> marks = new ArrayList<>();
    private String name;

    public Student(String name) {
        if (isEmpty(name)) {
            throw new IllegalArgumentException("Student name must not be empty!");
        }
        this.name = name;
    }

    public double calculateAverage() {
        if (marks.size() == 0) {
            return 0.0;
        }
        double sum = 0;
        for (Mark item : marks) {
            sum += item.getMarkType().getValue();
        }
        int covertFix = (int) ((sum / marks.size()) * 100);
        return covertFix / 100D;
    }

    public double calculateSubjectAverage(Subject subject) {
        if (marks.size() == 0) {
            return 0.0;
        }
        int itemCounter = 0;
        double sum = 0;
        for (Mark item : marks) {
            if (item.getSubject().getSubjectName().equals(subject.getSubjectName())) {
                sum += item.getMarkType().getValue();
                ++itemCounter;
            }
        }
        int covertFix = (int) ((sum / itemCounter) * 100);
        return covertFix / 100.0;
    }

    public String getName() {
        return name;
    }

    public void grading(Mark mark) {
        if (mark == null) {
            throw new NullPointerException("Mark must not be null!");
        }
        marks.add(mark);
    }

    private boolean isEmpty(String str) {
        if (str == null || str.isBlank()) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String result = name + " marks: " + marks.get(0).getSubject().getSubjectName() + ": " + marks.get(0);
        for (int i = 1; i < marks.size(); i++){
            result += ", " + name + " marks: " + marks.get(0).getSubject().getSubjectName() + ": " + marks.get(i);
        }
        return result;
    }

}


