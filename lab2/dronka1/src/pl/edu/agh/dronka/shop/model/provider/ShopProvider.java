package pl.edu.agh.dronka.shop.model.provider;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import pl.edu.agh.dronka.shop.model.*;
import pl.edu.agh.dronka.shop.model.items.*;

public class ShopProvider {

    public static Shop getExampleShop() {
        Shop shop = new Shop();

        shop.addUser(getExampleUser());

        Index itemsIndex = new Index();

        for (Item item : getExampleItems()) {
            itemsIndex.addItem(item);
        }

        registerExampleCategories(itemsIndex);
        shop.setItemsIndex(itemsIndex);

        return shop;
    }

    public static User getExampleUser() {
        return new User("Jan", "Rejnor");
    }

    public static List<Item> getExampleItems() {
        List<Item> items = new ArrayList<>();

        CSVReader booksReader = new CSVReader("resources/books.csv");
        items.addAll(readItems(booksReader, Category.BOOKS));

        CSVReader electronicsReader = new CSVReader("resources/electronics.csv");
        items.addAll(readItems(electronicsReader, Category.ELECTRONICS));

        CSVReader foodReader = new CSVReader("resources/food.csv");
        items.addAll(readItems(foodReader, Category.FOOD));

        CSVReader musicReader = new CSVReader("resources/music.csv");
        items.addAll(readItems(musicReader, Category.MUSIC));

        CSVReader sportReader = new CSVReader("resources/sport.csv");
        items.addAll(readItems(sportReader, Category.SPORT));

        return items;
    }

    public static void registerExampleCategories(Index index) {
        for (Category category : Category.values()) {
            index.registerCategory(category);
        }
    }

    private static List<Item> readItems(CSVReader reader, Category category) {
        List<Item> items = new ArrayList<>();

        try {
            reader.parse();
            List<String[]> data = reader.getData();

            for (String[] dataLine : data) {

                String name = reader.getValue(dataLine, "Nazwa");
                int price = Integer.parseInt(reader.getValue(dataLine, "Cena"));
                int quantity = Integer.parseInt(reader.getValue(dataLine,
                        "Ilość"));

                boolean isPolish = Boolean.parseBoolean(reader.getValue(
                        dataLine, "Tanie bo polskie"));
                boolean isSecondhand = Boolean.parseBoolean(reader.getValue(
                        dataLine, "Używany"));
                Item item = switch (category) {
                    case BOOKS -> {
                        boolean hardCover = Boolean.parseBoolean(reader.getValue(
                                dataLine, "Twarda oprawa"));
                        int pageNum = Integer.parseInt(reader.getValue(dataLine,
                                "Liczba stron"));
                        yield new Book(name, category, price, quantity, pageNum, hardCover);
                    }
                    case ELECTRONICS -> {
                        boolean mobile = Boolean.parseBoolean(reader.getValue(
                                dataLine, "Mobilny"));
                        boolean guarantee = Boolean.parseBoolean(reader.getValue(
                                dataLine, "Gwarancja"));
                        yield new ElectronicItem(name, category, price, quantity, mobile, guarantee);
                    }
                    case FOOD -> {
                        int year= Integer.parseInt(reader.getValue(dataLine, "Rok"));
                        int month = Integer.parseInt(reader.getValue(dataLine, "Miesiąc"));
                        int day= Integer.parseInt(reader.getValue(dataLine, "Dzień"));
                        LocalDate date = LocalDate.of(year,month,day);
                        yield new Food(name, category, price, quantity, date);
                    }
                    case MUSIC ->{
                        MusicGenre musicGenre = MusicGenre.valueOf(reader.getValue(dataLine, "Gatunek"));
                        boolean videoAttached = Boolean.parseBoolean(reader.getValue(
                                dataLine, "Wideo"));
                        yield new Music(name, category, price, quantity, musicGenre, videoAttached);
                    }
                    case SPORT-> new Sport(name,category,price,quantity);
                };
                item.setPolish(isPolish);
                item.setSecondhand(isSecondhand);

                items.add(item);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return items;
    }

}
