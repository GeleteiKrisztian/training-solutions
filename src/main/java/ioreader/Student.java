package ioreader;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String name;
    private List<Integer> grades;

    public Student(String name, List<Integer> grades) {
        this.name = name;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getGradeList() {
        return new ArrayList<>(grades);
    }

    public double average() {
        int sum = 0;
        for (int item : grades) {
            sum += item;
        }
        return (double) sum / grades.size();
    }

    public boolean isIncreasing() {
        for (int i = 1; i < grades.size(); i++) {
            if (grades.get(i-1) > grades.get(i)) {
                return false;
            }
        }
        return true;
    }

}
