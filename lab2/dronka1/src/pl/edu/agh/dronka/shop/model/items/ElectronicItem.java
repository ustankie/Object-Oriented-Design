package pl.edu.agh.dronka.shop.model.items;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Item;

public class ElectronicItem extends Item {
    private boolean mobile;
    private boolean guarantee;

    public ElectronicItem(String name, Category category, int price, int quantity, boolean mobile, boolean guarantee){
        super(name,category, price, quantity);

        this.mobile=mobile;
        this.guarantee=guarantee;
    }

    public ElectronicItem(){
        super();
    }

    public boolean isMobile(){
        return mobile;
    }

    public boolean isGuarantee(){
        return guarantee;
    }

    public void setMobile(boolean mobile) {
        this.mobile = mobile;
    }

    public void setGuarantee(boolean guarantee) {
        this.guarantee = guarantee;
    }
}
