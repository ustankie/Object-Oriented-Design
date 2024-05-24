package pl.edu.agh.to.lab4.search;

import pl.edu.agh.to.lab4.data.Suspect;

public class NameSearchStrategy implements SearchStrategy {
    String firstName;
    String lastName;

    public NameSearchStrategy(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public boolean filter(Suspect suspect) {
        return (suspect.getFirstname().equals(firstName) || firstName == null)
                && (lastName == null || suspect.getSurname().equals(lastName));
    }
}
