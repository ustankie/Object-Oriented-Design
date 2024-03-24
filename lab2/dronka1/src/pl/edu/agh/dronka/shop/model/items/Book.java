package pl.edu.agh.dronka.shop.model.items;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Item;

public class Book extends Item {
    private final int pageNum;
    private boolean solidCover;

    public Book() {
        super();
        this.pageNum = 0;
    }

    public Book(String name, Category category, int price, int quantity, int pageNum, boolean solidCover) {
        super(name, category, price, quantity);
        this.pageNum = pageNum;
        this.solidCover = solidCover;
    }

    public int getPageNum() {
        return pageNum;
    }

    public boolean isSolidCover() {
        return solidCover;
    }

    public void setSolidCover(boolean solidCover) {
        this.solidCover = solidCover;
    }


}
