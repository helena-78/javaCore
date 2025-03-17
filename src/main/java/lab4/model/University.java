package lab4.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class University {
    private String name;
    private Human rector;
    private List<Faculty> faculties;

    public University(String name, Human rector) {
        this.name = name;
        this.rector = rector;
        this.faculties = new ArrayList<>();
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    @Override
    public String toString() {
        return "Університет: " + name + ", Ректор: " + rector.getFullName();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        University that = (University) obj;

        List<Faculty> sortedFaculties1 = new ArrayList<>(faculties);
        List<Faculty> sortedFaculties2 = new ArrayList<>(that.faculties);
        sortedFaculties1.sort(Comparator.comparing(Faculty::getName));
        sortedFaculties2.sort(Comparator.comparing(Faculty::getName));

        return Objects.equals(name, that.name) &&
                Objects.equals(rector, that.rector) &&
                Objects.equals(sortedFaculties1, sortedFaculties2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, rector, faculties);
    }

    public String getName() {
        return name;
    }
}
