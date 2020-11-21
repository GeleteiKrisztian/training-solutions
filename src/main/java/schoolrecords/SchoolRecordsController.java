package schoolrecords;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SchoolRecordsController {

    private ClassRecords classRecords = new ClassRecords("ABCD",new Random());
    private List<Subject> subjects = new ArrayList<>();
    private List<Tutor> tutors = new ArrayList<>();
    private List<String> menuItems;

    public void initMenuItems() {
        menuItems = List.of("Diákok nevének listázása", "Diák név alapján keresése", "Diák létrehozása", "Diák név alapján törlése", "Diák " +
                "feleltetése", "Osztályátlag kiszámolása", "Tantárgyi átlag kiszámolása", "Diákok átlagának megjelenítése", "Diák átlagának kiírása", "Diák tantárgyhoz tartozó átlagának kiírása", "Kilépés");
    }

    public void initSchool() {
        subjects.add(new Subject("Fizika"));
        subjects.add(new Subject("Biológia"));
        subjects.add(new Subject("Kémia"));

        tutors.add(new Tutor("John Doe",List.of(subjects.get(0), subjects.get(1))));
        tutors.add(new Tutor("Jack Doe",List.of(subjects.get(2))));
        tutors.add(new Tutor("Jane Doe",List.of(subjects.get(0), subjects.get(2))));
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int inp;
            do {
                 for (int i = 0; i < menuItems.size(); i++) {
                     System.out.println(String.format("%2d. %s",i + 1,menuItems.get(i)));
                 //System.out.println(i + 1 + ". " + menuItems.get(i));
                 }
                System.out.print("\nVálassz menüpontot: ");
                inp = Integer.valueOf(scanner.nextLine());

                 switch (inp) {
                     case 1:
                         System.out.println(classRecords.listStudentNames());
                         break;
                     case 2:
                         System.out.println("Adj meg egy nevet a kereséshez:");
                         System.out.println(classRecords.findStudentByName(scanner.nextLine()));
                         break;
                     case 3:
                         System.out.println("Adj meg egy nevet a diák létrehozásához:");
                         classRecords.addStudent(new Student(scanner.nextLine()));
                         break;
                     case 4:
                         System.out.println("Adj meg egy nevet a diák törléséhez:");
                         classRecords.removeStudent(new Student(scanner.nextLine()));
                         break;
                     case 5:
                         Student student = classRecords.repetition();
                         System.out.println("A kiválasztott diák: " + student.getName());

                         System.out.println("Add meg az érdemjegyet: (A, B, C, D, F)");
                         String grade = scanner.nextLine();
                         System.out.println("Add meg a tantárgy nevét:");
                         String subj = scanner.nextLine();
                         Subject subject = new Subject(subj);
                         System.out.println("Add meg az oktató nevét:");
                         String teacher = scanner.nextLine();
                         Tutor tutor = null;
                         for (Tutor item : tutors) {
                             if (item.getName().equals(teacher) && item.tutorTeachingSubject(subject)) {
                                 tutor = item;
                                 break;
                             }
                         }
                         Mark mark = new Mark(MarkType.valueOf(grade), subject, tutor);
                         student.grading(mark);
                         break;
                     case 6:
                         System.out.println(classRecords.calculateClassAverage());
                         break;
                     case 7:
                         System.out.println("Add meg a keresendő tantárgyat:");
                         String subjectName = scanner.nextLine();
                         System.out.println(classRecords.calculateClassAverageBySubject(new Subject(subjectName)));
                         break;
                     case 8:
                         System.out.println(classRecords.listStudyResults());
                         break;
                     case 9:
                         System.out.println("Add meg a diák nevét:");
                         String name = scanner.nextLine();
                         Student resultStudent = classRecords.findStudentByName(name);
                         System.out.println(resultStudent.calculateAverage());
                         break;
                     case 10:
                         System.out.println("Add meg a diák nevét:");
                         String nameinp = scanner.nextLine();
                         Student resultStudentinp = classRecords.findStudentByName(nameinp);
                         System.out.println("Add meg a keresendő tantárgyat:");
                         String subjectNameInp = scanner.nextLine();
                         System.out.println(resultStudentinp.calculateSubjectAverage(new Subject(subjectNameInp)));
                         break;
                 }
            } while(inp != 11);

    }

    public static void main(String[] args) {
        SchoolRecordsController schoolRecordsController = new SchoolRecordsController();
        schoolRecordsController.initSchool();
        schoolRecordsController.initMenuItems();
        schoolRecordsController.showMenu();
    }

}
