package pl.edu.agh.dronka.shop.model.items;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Item;

import java.time.LocalDate;
import java.util.Date;

public class Food extends Item {
    private final LocalDate bestBefore;

    public Food(){
        super();
        bestBefore=LocalDate.now();
    }

    public Food(String name, Category category, int price, int quantity, LocalDate bestBefore){
        super(name,category, price, quantity);
        this.bestBefore=bestBefore;
    }

    public LocalDate getBestBefore() {
        return bestBefore;
    }
}
