package pl.edu.agh.to.lab4.search;

import pl.edu.agh.to.lab4.data.Suspect;

public interface SearchStrategy {

    boolean filter(Suspect suspect);

}
