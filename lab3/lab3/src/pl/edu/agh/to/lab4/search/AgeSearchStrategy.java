package pl.edu.agh.to.lab4.search;

import pl.edu.agh.to.lab4.data.Suspect;

public class AgeSearchStrategy implements SearchStrategy {

    int minAge;
    int maxAge;

    public AgeSearchStrategy(int minAge, int maxAge) {
        this.minAge = minAge;
        this.maxAge = maxAge;
    }

    @Override
    public boolean filter(Suspect suspect) {
        return (suspect.getAge() >= minAge && suspect.getAge() <= maxAge);
    }
}
