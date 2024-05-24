package pl.edu.agh.to.lab4.search;

import pl.edu.agh.to.lab4.data.Suspect;
import pl.edu.agh.to.lab4.providers.CompositeAggregate;
import pl.edu.agh.to.lab4.providers.PersonDataProvider;
import pl.edu.agh.to.lab4.providers.PrisonerDataProvider;

import java.util.ArrayList;
import java.util.List;

public class Finder {
    private final CompositeAggregate aggregate;

    private final List<Suspect> suspects = new ArrayList<>();
    private final CompositeSearchStrategy searchStrategy;

    public Finder(CompositeAggregate aggregate) {

        this.aggregate = aggregate;
        searchStrategy = new CompositeSearchStrategy(List.of());
    }

    public Finder(CompositeAggregate aggregate, CompositeSearchStrategy searchStrategy) {

        this.aggregate = aggregate;
        this.searchStrategy = searchStrategy;
    }


    public Finder(PersonDataProvider cracowCitizens, PrisonerDataProvider prisoners) {

        this(new CompositeAggregate(List.of(cracowCitizens, prisoners)));
    }


    public void displayAllSuspectsWithName(String name) {
        List<Suspect> suspects = aggregate.getSuspects();
        List<Suspect> allSuspected = new ArrayList<>();
        CompositeSearchStrategy searchStrategy1 = new CompositeSearchStrategy(List.of(new DefaultSearchStrategy(name)));

        for (Suspect suspect : suspects) {
            if (searchStrategy1.filter(suspect)) {
                allSuspected.add(suspect);
            }
            if (allSuspected.size() >= 10) {
                break;
            }
        }


        System.out.println("Znalazlem " + allSuspected.size() + " pasujacych podejrzanych!");

        for (Suspect suspect : allSuspected) {
            System.out.println(suspect);
        }
    }


    public void displayAllSuspectsWithName() {
        List<Suspect> suspects = aggregate.getSuspects();
        List<Suspect> allSuspected = new ArrayList<>();

        for (Suspect suspect : suspects) {
            if (searchStrategy.filter(suspect)) {
                allSuspected.add(suspect);
            }
            if (allSuspected.size() >= 10) {
                break;
            }
        }


        System.out.println("Znalazlem " + allSuspected.size() + " pasujacych podejrzanych!");

        for (Suspect suspect : allSuspected) {
            System.out.println(suspect);
        }
    }
}
