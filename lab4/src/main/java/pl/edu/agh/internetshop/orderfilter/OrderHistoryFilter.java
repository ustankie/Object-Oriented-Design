package pl.edu.agh.internetshop.orderfilter;

import pl.edu.agh.internetshop.Order;
import pl.edu.agh.internetshop.Product;

import java.math.BigDecimal;
import java.util.Objects;

public class OrderHistoryFilter {
    private final String name;
    private final String productName;
    private final BigDecimal price;
    private final CompareType priceCompareType;
    private final BigDecimal priceWithTaxes;
    private final CompareType priceWithTaxesCompareType;
    public OrderHistoryFilter() {
        this(null,null,null,null,null,null);

    }

    public OrderHistoryFilter(String name, String product, BigDecimal price, BigDecimal priceWithTaxes,CompareType priceCompareType, CompareType priceWithTaxesCompareType) {
        this.name = name;
        this.productName = product;
        this.price = price;
        this.priceWithTaxes=priceWithTaxes;
        this.priceCompareType=priceCompareType;
        this.priceWithTaxesCompareType=priceWithTaxesCompareType;
    }

    public boolean filterOrders(Order order) {
        return (getPrice() == null || comparePrices(order.getPrice(),getPrice(),priceCompareType))
                && (getPriceWithTaxes() == null || comparePrices(order.getPriceWithTaxes(),getPriceWithTaxes(),priceWithTaxesCompareType))
                && (getName() == null || order.getShipment().getSenderAddress().getName().equals(getName()))
                && (getProductName() == null || !order.getProducts().stream().filter(product -> product.getName().equals(getProductName())).toList().isEmpty());
    }

    public boolean comparePrices(BigDecimal price1, BigDecimal price2, CompareType type){
        return switch(type){
            case EQUAL-> price1.compareTo(price2)==0;
            case GEQ -> price1.compareTo(price2)>=0;
            case SEQ -> price1.compareTo(price2)<=0;
            case SMALLER-> price1.compareTo(price2)<0;
            case GREATER -> price1.compareTo(price2)>0;
        };

    }

    public String getName() {
        return name;
    }

    public String getProductName() {
        return productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getPriceWithTaxes() {
        return priceWithTaxes;
    }

    public CompareType getPriceCompareType() {
        return priceCompareType;
    }

    public CompareType getPriceWithTaxesCompareType() {
        return priceWithTaxesCompareType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderHistoryFilter that = (OrderHistoryFilter) o;
        return Objects.equals(getName(), that.getName()) && Objects.equals(getProductName(), that.getProductName()) && Objects.equals(getPrice(), that.getPrice()) && getPriceCompareType() == that.getPriceCompareType() && Objects.equals(getPriceWithTaxes(), that.getPriceWithTaxes()) && getPriceWithTaxesCompareType() == that.getPriceWithTaxesCompareType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getProductName(), getPrice(), getPriceCompareType(), getPriceWithTaxes(), getPriceWithTaxesCompareType());
    }
}
