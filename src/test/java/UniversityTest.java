import static org.junit.jupiter.api.Assertions.*;

import com.google.gson.GsonBuilder;
import lab4.controller.*;
import lab4.json.JsonManager;
import lab4.model.*;
import org.junit.jupiter.api.Test;

public class UniversityTest {
    @Test
    public void test() {
        Human rector = new Human("Іван", "Іванович", "Іванов", Sex.MALE);
        University oldUniversity = new UniversityCreator().createUniversity("Київський університет", rector);

        Human dean = new Human("Маргарита", "Костянтиновна", "Костянтинова", Sex.FEMALE) ;
        Human dean1 = new Human("Маргарита", "Костянтиновна", "Костянтинова", Sex.FEMALE) ;
        Faculty faculty = FacultyCreator.createFaculty("Факультет Комп'ютерних Наук", dean);
        Faculty faculty1 = FacultyCreator.createFaculty("Факультет Гуманітарних Наук", dean1);
        oldUniversity.addFaculty(faculty);
        oldUniversity.addFaculty(faculty1);

        Human headOfDepartment = new Human("Андрій", "Андрійович", "Андрієв", Sex.MALE) ;
        Human headOfDepartment1 = new Human("Андрій", "Андрійович", "Андрієв", Sex.MALE) ;
        Human headOfDepartment2 = new Human("Андрій", "Андрійович", "Андрієв", Sex.MALE) ;
        Human headOfDepartment3 = new Human("Андрій", "Андрійович", "Андрієв", Sex.MALE) ;
        Department department = DepartmentCreator.createDepartment("Кафедра програмування", headOfDepartment);
        Department department1 = DepartmentCreator.createDepartment("Кафедра лінгвістики", headOfDepartment1);
        Department department2 = DepartmentCreator.createDepartment("Кафедра програмування і інженерії", headOfDepartment2);
        Department department3 = DepartmentCreator.createDepartment("Кафедра лінгвістики та філології", headOfDepartment3);
        faculty.addDepartment(department);
        faculty.addDepartment(department2);
        faculty1.addDepartment(department3);
        faculty1.addDepartment(department1);

        Human headOfGroup = new Human("Марія", "Яновна", "Шевченко", Sex.FEMALE) ;
        Human headOfGroup1 = new Human("Марія", "Яновна", "Шевченко", Sex.FEMALE) ;
        Human headOfGroup2 = new Human("Марія", "Яновна", "Шевченко", Sex.FEMALE) ;
        Human headOfGroup3 = new Human("Марія", "Яновна", "Шевченко", Sex.FEMALE) ;
        Human headOfGroup4 = new Human("Марія", "Яновна", "Шевченко", Sex.FEMALE) ;
        Human headOfGroup5 = new Human("Марія", "Яновна", "Шевченко", Sex.FEMALE) ;
        Human headOfGroup6 = new Human("Марія", "Яновна", "Шевченко", Sex.FEMALE) ;
        Human headOfGroup7 = new Human("Марія", "Яновна", "Шевченко", Sex.FEMALE) ;
        Group group = GroupCreator.createGroup("Група CS-23", headOfGroup);
        Group group1 = GroupCreator.createGroup("Група HS-24", headOfGroup1);
        Group group2 = GroupCreator.createGroup("Група CS-23", headOfGroup2);
        Group group3 = GroupCreator.createGroup("Група HS-24", headOfGroup3);
        Group group4 = GroupCreator.createGroup("Група CS-23", headOfGroup4);
        Group group5 = GroupCreator.createGroup("Група HS-24", headOfGroup5);
        Group group6 = GroupCreator.createGroup("Група CS-23", headOfGroup6);
        Group group7 = GroupCreator.createGroup("Група HS-24", headOfGroup7);
        department.addGroup(group);
        department.addGroup(group4);
        department1.addGroup(group1);
        department1.addGroup(group5);
        department2.addGroup(group2);
        department2.addGroup(group6);
        department3.addGroup(group3);
        department3.addGroup(group7);

        Student student = StudentCreator.createStudent("Ян", "Шевченко", "Вадимович", Sex.MALE);
        Student student1 = StudentCreator.createStudent("Ян", "Шевченко", "Вадимович", Sex.MALE);
        Student student2 = StudentCreator.createStudent("Ян", "Шевченко", "Вадимович", Sex.MALE);
        Student student3 = StudentCreator.createStudent("Ян", "Шевченко", "Вадимович", Sex.MALE);
        Student student4 = StudentCreator.createStudent("Ян", "Шевченко", "Вадимович", Sex.MALE);
        Student student5 = StudentCreator.createStudent("Ян", "Шевченко", "Вадимович", Sex.MALE);
        Student student6 = StudentCreator.createStudent("Ян", "Шевченко", "Вадимович", Sex.MALE);
        Student student7 = StudentCreator.createStudent("Ян", "Шевченко", "Вадимович", Sex.MALE);
        Student student8 = StudentCreator.createStudent("Ян", "Шевченко", "Вадимович", Sex.MALE);
        Student student9 = StudentCreator.createStudent("Ян", "Шевченко", "Вадимович", Sex.MALE);
        Student student10 = StudentCreator.createStudent("Ян", "Шевченко", "Вадимович", Sex.MALE);
        Student student11 = StudentCreator.createStudent("Ян", "Шевченко", "Вадимович", Sex.MALE);
        Student student12 = StudentCreator.createStudent("Ян", "Шевченко", "Вадимович", Sex.MALE);
        Student student13 = StudentCreator.createStudent("Ян", "Шевченко", "Вадимович", Sex.MALE);
        Student student14 = StudentCreator.createStudent("Ян", "Шевченко", "Вадимович", Sex.MALE);
        Student student15 = StudentCreator.createStudent("Ян", "Шевченко", "Вадимович", Sex.MALE);
        group.addStudent(student);
        group1.addStudent(student1);
        group2.addStudent(student2);
        group3.addStudent(student3);
        group4.addStudent(student4);
        group5.addStudent(student5);
        group6.addStudent(student6);
        group7.addStudent(student7);
        group.addStudent(student8);
        group1.addStudent(student9);
        group2.addStudent(student10);
        group3.addStudent(student11);
        group4.addStudent(student12);
        group5.addStudent(student13);
        group6.addStudent(student14);
        group7.addStudent(student15);

        JsonManager jsonManager = new JsonManager();
        jsonManager.writeToJson(oldUniversity, "oldUniversity.json");

        University newUniversity = jsonManager.readFromJson("oldUniversity.json");

        assertTrue(oldUniversity.equals(newUniversity));

    }
}
