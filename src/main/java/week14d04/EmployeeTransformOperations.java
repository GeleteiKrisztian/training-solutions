package week14d04;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeTransformOperations {

        public List<Employee> transformToUppercased(List<Employee> employees) {
            List<Employee> employeesResult = employees.stream().map(employee -> new Employee(employee.getName().toUpperCase())).collect(Collectors.toList());
            return employeesResult;
        }
    }

