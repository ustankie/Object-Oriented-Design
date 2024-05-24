package pl.edu.agh.to.lab4.data;

import java.util.List;

public abstract class Suspect {
    protected String firstname;

    protected String lastname;

    public Suspect(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return lastname;
    }

    @Override
    public String toString() {
        return firstname + " " + lastname;
    }

    public abstract boolean isSuspect(String name);

    public abstract int getAge();
}
