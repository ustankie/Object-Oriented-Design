package pl.edu.agh.dronka.shop.model.util;

import java.util.LinkedHashMap;
import java.util.Map;

import pl.edu.agh.dronka.shop.model.*;
import pl.edu.agh.dronka.shop.model.items.Book;
import pl.edu.agh.dronka.shop.model.items.ElectronicItem;
import pl.edu.agh.dronka.shop.model.items.Food;
import pl.edu.agh.dronka.shop.model.items.Music;

public class PropertiesHelper {

    public static Map<String, Object> getPropertiesMap(Item item) {
        Map<String, Object> propertiesMap = new LinkedHashMap<>();

        propertiesMap.put("Nazwa", item.getName());
        propertiesMap.put("Cena", item.getPrice());
        propertiesMap.put("Kategoria", item.getCategory().getDisplayName());
        propertiesMap.put("Ilość", Integer.toString(item.getQuantity()));
        propertiesMap.put("Tanie bo polskie", item.isPolish());
        propertiesMap.put("Używany", item.isSecondhand());

        if (item.getCategory() == Category.BOOKS) {
            Book book = (Book) item;
            propertiesMap.put("Liczba stron", book.getPageNum());
            propertiesMap.put("Twarda oprawa", book.isSolidCover());
        }

        if (item.getCategory() == Category.ELECTRONICS) {
            ElectronicItem electronicItem = (ElectronicItem) item;
            propertiesMap.put("Mobilny", electronicItem.isMobile());
            propertiesMap.put("Gwarancja", electronicItem.isGuarantee());
        }

        if (item.getCategory() == Category.FOOD) {
            Food food = (Food) item;
            propertiesMap.put("Data ważności", food.getBestBefore());
        }

        if (item.getCategory() == Category.MUSIC) {
            Music music = (Music) item;
            propertiesMap.put("Gatunek", music.getMusicGenre().getDisplayName());
            propertiesMap.put("Wideo", music.isVideoAttached());
        }
        return propertiesMap;
    }
}
