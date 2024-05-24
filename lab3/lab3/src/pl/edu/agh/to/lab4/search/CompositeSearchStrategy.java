package pl.edu.agh.to.lab4.search;

import pl.edu.agh.to.lab4.data.Suspect;

import java.util.List;

public class CompositeSearchStrategy implements SearchStrategy {
    List<SearchStrategy> searchStrategyList;

    public CompositeSearchStrategy(List<SearchStrategy> searchStrategyList) {
        this.searchStrategyList = searchStrategyList;
    }


    @Override
    public boolean filter(Suspect suspect) {
        return searchStrategyList
                .stream()
                .allMatch(searchStrategy -> searchStrategy.filter(suspect));
    }
}
