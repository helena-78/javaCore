package lab4.controller;

import lab4.model.Group;
import lab4.model.Human;

public class GroupCreator {
    public static Group createGroup(String name, Human head) {
        return new Group(name, head);
    }
}
