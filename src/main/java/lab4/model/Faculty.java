package lab4.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Faculty {
    private String name;
    private Human dean;
    private List<Department> departments;

    public Faculty(String name, Human dean) {
        this.name = name;
        this.dean = dean;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    @Override
    public String toString() {
        return "Факультет: " + name + ", Декан: " + dean.getFullName();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Faculty that = (Faculty) obj;

        List<Department> sortedDepart1 = new ArrayList<>(departments);
        List<Department> sortedDepart2 = new ArrayList<>(that.departments);
        sortedDepart1.sort(Comparator.comparing(Department::getName));
        sortedDepart2.sort(Comparator.comparing(Department::getName));
        return Objects.equals(name, that.name) &&
                Objects.equals(dean, that.dean) &&
                Objects.equals(sortedDepart1, sortedDepart2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dean, departments);
    }

    public String getName() {
        return name;
    }
}
