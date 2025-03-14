package controller;

import model.*;

public class Run {
    public static void main(String[] args) {
        University university = createTypicalUniversity();
        System.out.println(university);
    }

    public static University createTypicalUniversity() {
        Human rector = new Human("Іван", "Іванович", "Іванов", Sex.MALE) {};
        University university = UniversityCreator.createUniversity("Дніпровський університет", rector);

        Human dean = new Human("Маргарита", "Костянтиновна", "Костянтинова", Sex.FEMALE) {};
        Faculty faculty = FacultyCreator.createFaculty("Факультет Комп'ютерних Наук", dean);
        university.addFaculty(faculty);

        Human headOfDepartment = new Human("Андрій", "Андрійович", "Андрієв", Sex.MALE) {};
        Department department = DepartmentCreator.createDepartment("Кафедра програмування", headOfDepartment);
        faculty.addDepartment(department);

        Human headOfGroup = new Human("Марія", "Яновна", "Шевченко", Sex.FEMALE) {};
        Group group = GroupCreator.createGroup("Група CS-23", headOfGroup);
        department.addGroup(group);

        Student student = StudentCreator.createStudent("Ян", "Шевченко", "Вадимович", Sex.MALE);
        group.addStudent(student);

        return university;
    }
}
