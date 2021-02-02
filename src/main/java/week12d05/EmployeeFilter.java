package week12d05;

import java.util.ArrayList;
import java.util.List;

public class EmployeeFilter {

    public List<Employee> countSeniorDevs(List<Employee> employees) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getSkillLevel() >= 3 && employee.getSkills().contains("Programming")) {
                result.add(employee);
            }
        }
        return result;
    }

}
