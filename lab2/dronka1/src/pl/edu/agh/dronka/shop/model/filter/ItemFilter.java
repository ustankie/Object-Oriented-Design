package pl.edu.agh.dronka.shop.model.filter;

import pl.edu.agh.dronka.shop.model.*;
import pl.edu.agh.dronka.shop.model.items.*;

public class ItemFilter {

    private Item itemSpec = null;

    public void setCategory(Category category) {
        itemSpec = switch (category) {
            case BOOKS -> new Book();
            case ELECTRONICS -> new ElectronicItem();
            case FOOD -> new Food();
            case MUSIC -> new Music();
            case SPORT -> new Sport();
        };
        itemSpec.setCategory(category);
    }

    public Item getItemSpec() {
        return itemSpec;
    }

    public boolean appliesTo(Item item) {
        if (itemSpec.getName() != null
                && !itemSpec.getName().equals(item.getName())) {
            return false;
        }
        if (itemSpec.getCategory() != null
                && !itemSpec.getCategory().equals(item.getCategory())) {
            return false;
        }

        // applies filter only if the flag (secondHand) is true)
        if (itemSpec.isSecondhand() && !item.isSecondhand()) {
            return false;
        }

        // applies filter only if the flag (polish) is true)
        if (itemSpec.isPolish() && !item.isPolish()) {
            return false;
        }

        switch (item.getCategory()) {
            case BOOKS -> {
                if (((Book) itemSpec).isSolidCover() && !((Book) item).isSolidCover()) {
                    return false;
                }
            }
            case ELECTRONICS -> {
                if (((ElectronicItem) itemSpec).isGuarantee() && !((ElectronicItem) item).isGuarantee()) {
                    return false;
                }
                if (((ElectronicItem) itemSpec).isMobile() && !((ElectronicItem) item).isMobile()) {
                    return false;
                }
            }
            case MUSIC -> {
                if (((Music) itemSpec).isVideoAttached() && !((Music) item).isVideoAttached()) {
                    return false;
                }
            }
        }

        return true;
    }

}