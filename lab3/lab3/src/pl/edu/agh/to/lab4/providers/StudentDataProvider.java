package pl.edu.agh.to.lab4.providers;

import pl.edu.agh.to.lab4.data.Student;
import pl.edu.agh.to.lab4.data.Suspect;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentDataProvider implements SuspectAggregate {

    private final List<Student> students = new ArrayList<>();

    public StudentDataProvider() {
        students.add(new Student("Adam", "Michalik", "415783", 20));
        students.add(new Student("Marek", "Kowalczyk", "414783", 20));
        students.add(new Student("Mikołaj", "Szajowski", "415782", 20));
        students.add(new Student("Adam", "Kalisz", "415744", 20));
        students.add(new Student("Ewa", "Urbańska", "414383", 20));
        students.add(new Student("Konrad", "Michalski", "423783", 20));

    }

    @Override
    public Iterator<Suspect> iterator() {
        return null;
    }
}
