package debug;

import java.util.ArrayList;
import java.util.List;

public class Company {

    private List<Employee> employeeList = new ArrayList<>();

    public Company(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public Employee findNameByString(String name) {
        for (int i = 0; i < employeeList.size(); i++) {

            boolean contains = employeeList.get(i).getName().equals(name);
            if( contains == true) {
                return employeeList.get(i);
            }
        }
        return new Employee(null,0);
    }

    public List<String> listEmployeeNames() {
        List<String> retList = new ArrayList<>();
        for (int i = 0; i < employeeList.size(); i++) {
            retList.add(employeeList.get(i).getName());
        }
        return retList;
    }
}
