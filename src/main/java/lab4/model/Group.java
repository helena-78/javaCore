package lab4.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Group {
    private String name;
    private Human head;
    private List<Student> students;

    public Group(String name, Human head) {
        this.name = name;
        this.head = head;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public String toString() {
        return "Група: " + name + ", Староста: " + head.getFullName();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Group that = (Group) obj;

        List<Student> sortedStudents1 = new ArrayList<>(students);
        List<Student> sortedStudents2 = new ArrayList<>(that.students);
        sortedStudents1.sort(Comparator.comparing(Student::getName));
        sortedStudents2.sort(Comparator.comparing(Student::getName));
        return Objects.equals(name, that.name) &&
                Objects.equals(head, that.head) &&
                Objects.equals(students, that.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, head, students);
    }

    public String getName() {
        return name;
    }
}
