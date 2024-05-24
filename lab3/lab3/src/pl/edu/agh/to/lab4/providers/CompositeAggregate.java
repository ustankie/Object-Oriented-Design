package pl.edu.agh.to.lab4.providers;

import pl.edu.agh.to.lab4.data.Suspect;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CompositeAggregate implements SuspectAggregate {

    private final List<SuspectAggregate> dataProviders;

    public CompositeAggregate(List<SuspectAggregate> dataProviders) {
        this.dataProviders = dataProviders;

    }


    public List<Suspect> getSuspects() {
        List<Suspect> suspects = new ArrayList<>();

        for (SuspectAggregate data : dataProviders) {
            Iterator<Suspect> dataIterator = data.iterator();
            while (dataIterator.hasNext()) {

                suspects.add(dataIterator.next());
            }

        }

        return suspects;
    }

    @Override
    public Iterator<Suspect> iterator() {
        return getSuspects().iterator();
    }
}
