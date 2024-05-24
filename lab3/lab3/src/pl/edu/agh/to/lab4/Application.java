package pl.edu.agh.to.lab4;

import pl.edu.agh.to.lab4.providers.CompositeAggregate;
import pl.edu.agh.to.lab4.providers.PersonDataProvider;
import pl.edu.agh.to.lab4.providers.PrisonerDataProvider;
import pl.edu.agh.to.lab4.search.AgeSearchStrategy;
import pl.edu.agh.to.lab4.search.CompositeSearchStrategy;
import pl.edu.agh.to.lab4.search.Finder;
import pl.edu.agh.to.lab4.search.NameSearchStrategy;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        Finder suspects = new Finder(new CompositeAggregate(List.of(new PersonDataProvider(), new PrisonerDataProvider())));
        suspects.displayAllSuspectsWithName("Janusz");
        System.out.println();

        Finder suspects2 = new Finder(new CompositeAggregate(List.of(new PersonDataProvider(), new PrisonerDataProvider())),
                new CompositeSearchStrategy(List.of(new NameSearchStrategy("Jan",null),new AgeSearchStrategy(18,30))));
        suspects2.displayAllSuspectsWithName();

        System.out.println();
        Finder suspects3 = new Finder(new CompositeAggregate(List.of(new PersonDataProvider(), new PrisonerDataProvider())),
                new CompositeSearchStrategy(List.of(new NameSearchStrategy(null,"Gimbus"),
                                                        new AgeSearchStrategy(Integer.MIN_VALUE,30))));
        suspects3.displayAllSuspectsWithName();
    }
}
