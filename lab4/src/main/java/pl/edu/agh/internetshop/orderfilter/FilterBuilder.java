package pl.edu.agh.internetshop.orderfilter;

import pl.edu.agh.internetshop.Product;

import java.math.BigDecimal;

public interface FilterBuilder {
    void setName(String name);
    void setProductName(String product);
    void setPrice(BigDecimal price, CompareType type);
    void setPriceWithTaxes(BigDecimal price, CompareType type);
}
