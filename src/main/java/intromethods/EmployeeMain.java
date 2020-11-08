package intromethods;

import java.time.LocalDate;

public class EmployeeMain {

    public static void main(String[] args) {
        Employee employee = new Employee("John Wick", LocalDate.of(2020,10,5),250000);
        System.out.println(employee);
        employee.raiseSalary(150000);
        System.out.println(employee);
        employee.setName("Johnie Wick");
        System.out.println(employee);
    }
}
