package week12d05;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeFilterTest {

    private List<Employee> employees = List.of(new Employee(25,3, "John Doe", List.of("Programming")), new Employee(27, 4, "Jack Doe", List.of("Semmi")), new Employee(26, 2, "Jane Doe", List.of("Programming")));

    @Test
    void testEmployeesResult() {
        assertEquals(1, new EmployeeFilter().countSeniorDevs(employees).size());
        assertEquals("John Doe", new EmployeeFilter().countSeniorDevs(employees).get(0).getName());
    }

}