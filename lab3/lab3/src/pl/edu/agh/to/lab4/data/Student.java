package pl.edu.agh.to.lab4.data;

public class Student extends Suspect {

    String index;
    int age;

    public Student(String firstname, String lastname, String index, int age) {
        super(firstname, lastname);
        this.index = index;
        this.age = age;
    }

    @Override
    public boolean isSuspect(String name) {
        return true;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student: index: " + index + ", Name: " + super.toString();
    }
}
