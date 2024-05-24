package pl.edu.agh.internetshop.orderfilter;

import pl.edu.agh.internetshop.Product;

import java.math.BigDecimal;

public class OrderHistoryFilterBuilder implements FilterBuilder{
    private String name;
    private String productName;
    private BigDecimal price;
    private CompareType priceCompareType;
    private BigDecimal priceWithTaxes;
    private CompareType priceWithTaxesCompareType;

    @Override
    public void setName(String name) {
        this.name=name;
    }

    @Override
    public void setProductName(String product) {
        this.productName=product;
    }

    @Override
    public void setPrice(BigDecimal price, CompareType type) {
        this.price=price;
        this.priceCompareType=type;
    }

    @Override
    public void setPriceWithTaxes(BigDecimal price, CompareType type) {
        this.priceWithTaxes=price;
        this.priceWithTaxesCompareType=type;
    }

    public OrderHistoryFilter getResult(){
        return new OrderHistoryFilter(name,productName,price,priceWithTaxes,priceCompareType,priceWithTaxesCompareType);
    }


}
