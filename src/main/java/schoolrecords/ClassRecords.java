package schoolrecords;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClassRecords {

    private String className;
    private Random rnd;
    private List<Student> students = new ArrayList<>();

    public ClassRecords(String className, Random rnd) {
        this.className = className;
        this.rnd = rnd;
    }

    public String getClassName() {
        return className;
    }

    public boolean addStudent(Student student) {
        for (Student item : students) {
            if (item.getName().equals(student.getName())) {
                return false;
            }
        }
        students.add(student);
        return true;
    }

    public double calculateClassAverage() {
        if (students.size() == 0) {
            throw new ArithmeticException("No student in the class, average calculation aborted!");
        }
        double sum = 0;
        for (Student item : students) {
            if (item.calculateAverage() == 0) {
                throw new ArithmeticException("No marks present, average calculation aborted!");
            }
            sum += item.calculateAverage();
        }
        return sum / students.size();
    }

    public double calculateClassAverageBySubject(Subject subject) {
        double sum = 0;
        int counter = 0;
        for (Student item : students) {
            double calculatedAverage = item.calculateSubjectAverage(subject);
            if (calculatedAverage == 0.0) {
                continue;
            }
            counter++;
            sum += calculatedAverage;

        }
        int precisionFix = (int) ((sum / counter) * 100);
        return precisionFix / 100.0;
    }

    public Student findStudentByName(String name) {
        if (isEmpty(name)) {
            throw new IllegalArgumentException("Student name must not be empty!");
        }
        if (students.size() == 0) {
            throw new IllegalStateException("No students to search!");
        }
        for (Student item : students) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        throw new IllegalArgumentException("Student by this name cannot be found! " + name);
    }

    private boolean isEmpty(String str) {
        if (str == null || str.isBlank()) {
            return true;
        }
        return false;
    }

    public String listStudentNames() {
        if (students.size() == 0) {
            ;
        }
        String names = students.get(0).getName();
        for (int i = 1; i < students.size(); i++) {
            names += ", " + students.get(i).getName();
        }
        return names;
    }

    public List<StudyResultByName> listStudyResults() {
        List<StudyResultByName> studyResultByNames = new ArrayList<>();
        for (Student item : students) {
            studyResultByNames.add(new StudyResultByName(item.getName(),item.calculateAverage()));
        }
        return studyResultByNames;
    }

    public boolean removeStudent(Student student) {
        for (Student item : students) {
            if (item.getName().equals(student.getName())) {
                students.remove(student);
                return true;
            }
        }
        return false;
    }

    public Student repetition() {
        if (students.size() == 0) {
            throw new IllegalStateException("No students to select for repetition!");
        }
        rnd = new Random();
        int randIndex = rnd.nextInt(students.size());
        return students.get(randIndex);
    }

}

