package controller;

import model.University;
import model.Human;

public class UniversityCreator {
    public static University createUniversity(String name, Human rector) {
        return new University(name, rector);
    }
}
