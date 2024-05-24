package pl.edu.agh.to.lab4.data;

public class Person extends Suspect {


    private final int age;

    public Person(String firstname, String lastname, int age) {
        super(firstname, lastname);
        this.age = age;
    }

    public int getAge() {
        return age;
    }


    @Override
    public boolean isSuspect(String name) {


        return (this.getAge() > 18 && this.getFirstname().equals(name));
    }
}
