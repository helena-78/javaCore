package controller;

import model.Faculty;
import model.Human;

public class FacultyCreator {
    public static Faculty createFaculty(String name, Human dean) {
        return new Faculty(name, dean);
    }
}
