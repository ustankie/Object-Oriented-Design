package pl.edu.agh.to.lab4.search;

import pl.edu.agh.to.lab4.data.Suspect;

public class DefaultSearchStrategy implements SearchStrategy {

    String name;

    public DefaultSearchStrategy(String name) {
        this.name = name;
    }

    @Override
    public boolean filter(Suspect suspect) {
        return suspect.isSuspect(name);
    }
}
