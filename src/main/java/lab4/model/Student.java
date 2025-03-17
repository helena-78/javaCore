package lab4.model;

import java.util.Objects;

public class Student extends Human {
    public Student(String firstName, String lastName, String middleName, Sex sex) {
        super(firstName, lastName, middleName, sex);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return Objects.equals(firstName, student.firstName) &&
                Objects.equals(lastName, student.lastName) &&
                Objects.equals(middleName, student.middleName) &&
                sex == student.sex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, middleName, sex);
    }
    @Override
    public String toString() {
        return "Студент: " + getFullName();
    }

    public String getName() {
        return firstName;
    }
}
