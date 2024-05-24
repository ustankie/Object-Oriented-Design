package pl.edu.agh.to.lab4.providers;

import pl.edu.agh.to.lab4.data.Person;
import pl.edu.agh.to.lab4.data.Suspect;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class PersonDataProvider implements SuspectAggregate {

    private final List<Person> cracovCitizens = new ArrayList<Person>();

    public PersonDataProvider() {
        cracovCitizens.add(new Person("Jan", "Kowalski", 30));
        cracovCitizens.add(new Person("Janusz", "Krakowski", 30));
        cracovCitizens.add(new Person("Janusz", "Mlodociany", 10));
        cracovCitizens.add(new Person("Kasia", "Kosinska", 19));
        cracovCitizens.add(new Person("Piotr", "Zgredek", 29));
        cracovCitizens.add(new Person("Tomek", "Gimbus", 14));
        cracovCitizens.add(new Person("Janusz", "Gimbus", 15));
        cracovCitizens.add(new Person("Alicja", "Zaczarowana", 22));
        cracovCitizens.add(new Person("Janusz", "Programista", 77));
        cracovCitizens.add(new Person("Pawel", "Pawlowicz", 32));
        cracovCitizens.add(new Person("Krzysztof", "Mendel", 30));
    }

    public PersonDataProvider(List<Person> people) {
        cracovCitizens = people;
    }

    public List<Person> getAllCracovCitizens() {
        return cracovCitizens;
    }

    @Override
    public Iterator<Suspect> iterator() {
        return ((List<Suspect>) (List<?>) cracovCitizens).iterator();
    }
}
