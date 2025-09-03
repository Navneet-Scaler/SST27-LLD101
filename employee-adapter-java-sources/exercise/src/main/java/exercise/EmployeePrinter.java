package exercise;

import java.util.List;

public class EmployeePrinter {
    public static void print(List<Employee> employees) {
        employees.forEach(emp -> System.out.println(
            String.format("[%s] %s %s <%s>",
                emp.getId(), emp.getFirstName(), emp.getLastName(), emp.getEmail()
            )
        ));
    }
}
