package pl.edu.agh.to.lab4.data;

import java.util.Calendar;

public class Prisoner extends Suspect {
    private final int judgementYear;

    private final int senteceDuration;

    private final String pesel;


    public Prisoner(String firstname, String lastname, String pesel, int judgementYear, int sentenceDuration) {
        super(firstname, lastname);
        this.pesel = pesel;
        this.judgementYear = judgementYear;
        this.senteceDuration = sentenceDuration;
    }


    public String getPesel() {
        return pesel;
    }

    public boolean isInJail() {
        return judgementYear + senteceDuration >= getCurrentYear();
    }

    public int getCurrentYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    @Override
    public String toString() {
        return super.getFirstname() + " " + getSurname();
    }

    @Override
    public boolean isSuspect(String name) {


        return (!this.isInJail() && this.getFirstname().equals(name));
    }

    @Override
    public int getAge() {
        int birthYear = Integer.parseInt(pesel.substring(0, 2));
        int birthMonth = Integer.parseInt(pesel.substring(2, 4));

        birthYear += 1900;

        if (birthMonth > 20) {
            birthYear += 100;
        }

        return getCurrentYear() - birthYear;

    }

}
