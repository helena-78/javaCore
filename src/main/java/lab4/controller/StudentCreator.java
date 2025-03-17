package lab4.controller;

import lab4.model.Sex;
import lab4.model.Student;

public class StudentCreator {
    public static Student createStudent(String firstName, String lastName, String middleName, Sex sex) {
        return new Student(firstName, lastName, middleName, sex);
    }
}
