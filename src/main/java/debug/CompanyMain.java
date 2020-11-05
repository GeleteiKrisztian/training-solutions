package debug;

import java.util.ArrayList;
import java.util.List;

public class CompanyMain {

    public static void main(String[] args) {
        Employee employee1 = new Employee("John Doe",1995);
        Employee employee2 = new Employee("Jack Doe",2000);
        Employee employee3 = new Employee("Jack Doo",2001);
        Employee[] employees = new Employee[3];
        employees[0] = employee1;
        employees[1] = employee2;
        employees[2] = employee3;

        //Nem használtam Arrays.asList() -et paraméter átadáskor,mert akkor nem tudom utána módosítani a listát az addEmployee metódussal
        List<Employee> employeeParam = new ArrayList<>();
        for (int i = 0; i < employees.length; i++) {
            employeeParam.add(employees[i]);
        }

        Company company = new Company(employeeParam);
        company.addEmployee(new Employee("John Wick",2002));
        Employee foundEmployee = company.findNameByString("John Wick");
        System.out.println(foundEmployee.getName() + " " + foundEmployee.getYearOfBirth());
        System.out.println(company.listEmployeeNames());

    }
}
