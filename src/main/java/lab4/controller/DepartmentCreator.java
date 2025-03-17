package lab4.controller;

import lab4.model.Department;
import lab4.model.Human;

public class DepartmentCreator {
    public static Department createDepartment(String name, Human head) {
        return new Department(name, head);
    }
}
