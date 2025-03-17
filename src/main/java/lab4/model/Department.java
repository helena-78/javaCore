package lab4.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Department {
    private String name;
    private Human head;
    private List<Group> groups;

    public Department(String name, Human head) {
        this.name = name;
        this.head = head;
        this.groups = new ArrayList<>();
    }

    public void addGroup(Group group) {
        groups.add(group);
    }

    @Override
    public String toString() {
        return "Кафедра: " + name + ", Завідувач: " + head.getFullName();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Department that = (Department) obj;

        List<Group> sortedGroups1 = new ArrayList<>(groups);
        List<Group> sortedGroups2 = new ArrayList<>(that.groups);
        sortedGroups1.sort(Comparator.comparing(Group::getName));
        sortedGroups2.sort(Comparator.comparing(Group::getName));
        return Objects.equals(name, that.name) &&
                Objects.equals(head, that.head) &&
                Objects.equals(sortedGroups1, sortedGroups2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, head, groups);
    }

    public String getName() {
        return name;
    }
}
