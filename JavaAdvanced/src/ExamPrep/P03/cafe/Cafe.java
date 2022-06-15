package ExamPrep.P03.cafe;

import java.util.ArrayList;
import java.util.List;

public class Cafe {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        if (this.employees.size() < this.capacity) {
            employees.add(employee);
        }
    }


    public boolean removeEmployee(String employee) {
        for (Employee currentEmployee : employees) {
            if (currentEmployee.getName().equals(employee)) {
                employees.remove(currentEmployee);
                return true;
            }
        }
        return false;
    }

    public Employee getOldestEmployee() {
        int maxAge = 0;
        Employee maxAgeEmployee = null;
        for (Employee currentEmpl : employees) {
            if (currentEmpl.getAge() > maxAge) {
                maxAge = currentEmpl.getAge();
                maxAgeEmployee = currentEmpl;
            }
        }
        return maxAgeEmployee;
    }

    public Employee getEmployee(String name) {
        for (Employee employee : employees) {
            if (name.equals(employee.getName())) {
                return employee;
            }
        }
        return null;
    }

    public int getCount() {
        return employees.size();
    }

    public String report() {
        StringBuilder sb =  new StringBuilder();
        sb.append(String.format("Employees working at Cafe %s:%n",name));
        for (Employee employee : employees) {
            sb.append(employee.toString()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
