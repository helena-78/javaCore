package model;

import java.util.ArrayList;
import java.util.List;

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
}
