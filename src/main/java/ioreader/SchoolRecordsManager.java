package ioreader;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SchoolRecordsManager {

    private List<Student> students = new ArrayList<>();

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }

    public void readGradesFromFile(String file) {
        try(BufferedReader br = Files.newBufferedReader(Path.of(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] split = line.split(" ");
                String name = split[0];
                List<Integer> grades = new ArrayList<>();
                for (int i = 1;i < split.length; i++) {
                    grades.add(Integer.parseInt(split[i]));
                }
                students.add(new Student(name, grades));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("");
        }
    }

    public double classAverage() {
        double sum = 0;
        for (Student item : students) {
            sum += item.average();
        }
        return sum / students.size();
    }

}
