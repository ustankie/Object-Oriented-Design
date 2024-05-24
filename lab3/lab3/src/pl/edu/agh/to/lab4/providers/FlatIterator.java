package pl.edu.agh.to.lab4.providers;

import pl.edu.agh.to.lab4.data.Prisoner;
import pl.edu.agh.to.lab4.data.Suspect;

import java.util.*;

public class FlatIterator implements Iterator<Suspect> {

    private final List<Suspect> prisoners = new ArrayList<>();
    private final Iterator<Suspect> listIterator;

    public FlatIterator(Map<String, List<Prisoner>> prisoners) {
        for (List<Prisoner> prisonerList : prisoners.values()) {
            this.prisoners.addAll(prisonerList);
        }
        listIterator = this.prisoners.iterator();
    }

    @Override
    public boolean hasNext() {
        return listIterator.hasNext();
    }


    @Override
    public Suspect next() {
        return listIterator.next();
    }


}
