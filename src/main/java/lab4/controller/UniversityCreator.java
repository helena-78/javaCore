package lab4.controller;

import lab4.model.Human;
import lab4.model.University;

public class UniversityCreator {
    public static University createUniversity(String name, Human rector) {
        return new University(name, rector);
    }
}
