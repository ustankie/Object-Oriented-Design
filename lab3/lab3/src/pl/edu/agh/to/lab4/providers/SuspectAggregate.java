package pl.edu.agh.to.lab4.providers;

import pl.edu.agh.to.lab4.data.Suspect;

import java.util.Iterator;

public interface SuspectAggregate {
    Iterator<Suspect> iterator();
}
