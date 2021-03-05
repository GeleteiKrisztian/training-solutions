package week14d04;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTransformOperationsTest {

    private List<Employee> employeeList = List.of(new Employee("John Doe"), new Employee("Jack Doe"));

    @Test
    void transformTest() {
        List<Employee> employees = new EmployeeTransformOperations().transformToUppercased(employeeList);
        assertEquals("JOHN DOE", employees.get(0).getName());
        assertEquals("JACK DOE", employees.get(1).getName());

    }

    @Test
    void transFormNotModifyList() {
        assertEquals("John Doe", employeeList.get(0).getName());
    }

}