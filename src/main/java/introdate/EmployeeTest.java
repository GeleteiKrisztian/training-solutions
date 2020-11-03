package introdate;

import java.util.Scanner;

public class EmployeeTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Add meg a felvenni kívánt dolgozó nevét: ");
        String name = scanner.nextLine();
        System.out.println("Add meg a születési dátumát: (év hónap nap sorrendben) ");
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        int day = scanner.nextInt();

        Employee employee = new Employee(year,month,day,name);
        System.out.println("A dolgozó neve: " + employee.getName());
        System.out.println("Születési ideje: " + employee.getDateOfBirth());
        System.out.println("A sikeres felvétel időpontja: " + employee.getBeginEmployment());
    }
}
