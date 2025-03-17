package lab4.controller;

import lab4.model.Faculty;
import lab4.model.Human;

public class FacultyCreator {
    public static Faculty createFaculty(String name, Human dean) {
        return new Faculty(name, dean);
    }
}
