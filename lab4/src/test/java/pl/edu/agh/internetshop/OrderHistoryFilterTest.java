package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.edu.agh.internetshop.orderfilter.CompareType;
import pl.edu.agh.internetshop.orderfilter.OrderHistoryFilter;

import java.math.BigDecimal;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OrderHistoryFilterTest {

    @Test
    public void testComparePricesEQ(){
        //given
        BigDecimal price1=BigDecimal.valueOf(2.34);
        BigDecimal price2=BigDecimal.valueOf(2.34);
        BigDecimal price3=BigDecimal.valueOf(2.33);
        CompareType type=CompareType.EQUAL;
        //when
        OrderHistoryFilter orderHistoryFilter=new OrderHistoryFilter();
        //then
        Assertions.assertTrue(orderHistoryFilter.comparePrices(price1,price2,type));
        Assertions.assertFalse(orderHistoryFilter.comparePrices(price1,price3,type));
    }

    @Test
    public void testComparePricesGEQ(){
        //given
        BigDecimal price1=BigDecimal.valueOf(2.34);
        BigDecimal price2=BigDecimal.valueOf(2.34);
        BigDecimal price3=BigDecimal.valueOf(2.33);
        CompareType type=CompareType.GEQ;
        //when
        OrderHistoryFilter orderHistoryFilter=new OrderHistoryFilter();
        //then
        Assertions.assertTrue(orderHistoryFilter.comparePrices(price1,price2,type));
        Assertions.assertTrue(orderHistoryFilter.comparePrices(price1,price3,type));
        Assertions.assertFalse(orderHistoryFilter.comparePrices(price3,price1,type));
    }

    @Test
    public void testComparePricesSEQ(){
        //given
        BigDecimal price1=BigDecimal.valueOf(2.34);
        BigDecimal price2=BigDecimal.valueOf(2.34);
        BigDecimal price3=BigDecimal.valueOf(2.33);
        CompareType type=CompareType.SEQ;
        //when
        OrderHistoryFilter orderHistoryFilter=new OrderHistoryFilter();
        //then
        Assertions.assertTrue(orderHistoryFilter.comparePrices(price1,price2,type));
        Assertions.assertTrue(orderHistoryFilter.comparePrices(price3,price1,type));
        Assertions.assertFalse(orderHistoryFilter.comparePrices(price1,price3,type));
    }
    @Test
    public void testComparePricesGreater(){
        //given
        BigDecimal price1=BigDecimal.valueOf(2.34);
        BigDecimal price2=BigDecimal.valueOf(2.34);
        BigDecimal price3=BigDecimal.valueOf(2.33);
        CompareType type=CompareType.GREATER;
        //when
        OrderHistoryFilter orderHistoryFilter=new OrderHistoryFilter();
        //then
        Assertions.assertFalse(orderHistoryFilter.comparePrices(price1,price2,type));
        Assertions.assertFalse(orderHistoryFilter.comparePrices(price3,price1,type));
        Assertions.assertTrue(orderHistoryFilter.comparePrices(price1,price3,type));
    }

    @Test
    public void testComparePricesSmaller(){
        //given
        BigDecimal price1=BigDecimal.valueOf(2.34);
        BigDecimal price2=BigDecimal.valueOf(2.34);
        BigDecimal price3=BigDecimal.valueOf(2.33);
        CompareType type=CompareType.SMALLER;
        //when
        OrderHistoryFilter orderHistoryFilter=new OrderHistoryFilter();
        //then
        Assertions.assertFalse(orderHistoryFilter.comparePrices(price1,price2,type));
        Assertions.assertTrue(orderHistoryFilter.comparePrices(price3,price1,type));
        Assertions.assertFalse(orderHistoryFilter.comparePrices(price1,price3,type));
    }

    @Test
    public void testFilterOrdersTrue(){
        //given
        Order order=mock(Order.class);
        Address address=mock(Address.class);
        Shipment shipment=mock(Shipment.class);
        String productName="Jabłko";
        Product product1=mock(Product.class);
        Product product2=mock(Product.class);
        Product product3=mock(Product.class);
        String name="Kowalski";
        BigDecimal price=BigDecimal.valueOf(20.34);
        BigDecimal priceWithTaces=BigDecimal.valueOf(25.54);
        CompareType type=CompareType.EQUAL;

        given(address.getName()).willReturn(name);
        given(shipment.getSenderAddress()).willReturn(address);
        given(product1.getName()).willReturn(productName);
        given(product2.getName()).willReturn("lorem ipsum");
        given(product3.getName()).willReturn("sth");

        given(order.getPrice()).willReturn(price);
        given(order.getPriceWithTaxes()).willReturn(priceWithTaces);
        given(order.getShipment()).willReturn(shipment);
        given(order.getProducts()).willReturn(List.of(product1,product2,product3));

        //when
        OrderHistoryFilter orderHistoryFilter=new OrderHistoryFilter(name,productName,price,priceWithTaces,type,type);

        //then
        Assertions.assertTrue(orderHistoryFilter.filterOrders(order));
    }

    @Test
    public void testFilterOrdersFalse(){
        //given
        Order order=mock(Order.class);
        Address address=mock(Address.class);
        Shipment shipment=mock(Shipment.class);
        String productName="Jabłko";
        Product product1=mock(Product.class);
        Product product2=mock(Product.class);
        Product product3=mock(Product.class);
        String name="Kowalski";
        BigDecimal price=BigDecimal.valueOf(20.34);
        BigDecimal priceWithTaxes=BigDecimal.valueOf(23.54);
        BigDecimal priceWithTaxes2=BigDecimal.valueOf(21.54);
        CompareType type1=CompareType.GEQ;
        CompareType type2=CompareType.GREATER;

        given(address.getName()).willReturn(name);
        given(shipment.getSenderAddress()).willReturn(address);
        given(product1.getName()).willReturn("Jabłko");

        given(order.getPrice()).willReturn(price);
        given(order.getPriceWithTaxes()).willReturn(priceWithTaxes2);
        given(order.getShipment()).willReturn(shipment);
        given(order.getProducts()).willReturn(List.of(product1,product2,product3));
        //when
        OrderHistoryFilter orderHistoryFilter=new OrderHistoryFilter(name,productName,price,priceWithTaxes,type1,type2);

        //then
        Assertions.assertFalse(orderHistoryFilter.filterOrders(order));
    }

    @Test
    public void testFilterOrdersTrueWithNullValues(){
        //given
        Order order=mock(Order.class);
        Address address=mock(Address.class);
        Shipment shipment=mock(Shipment.class);
        String productName="Jabłko";
        Product product1=mock(Product.class);
        Product product2=mock(Product.class);
        Product product3=mock(Product.class);
        String name="Kowalski";
        BigDecimal price=BigDecimal.valueOf(20.34);
        BigDecimal priceWithTaces=BigDecimal.valueOf(25.54);
        CompareType type=CompareType.EQUAL;

        given(address.getName()).willReturn(name);
        given(shipment.getSenderAddress()).willReturn(address);

        given(order.getPrice()).willReturn(price);
        given(order.getPriceWithTaxes()).willReturn(priceWithTaces);
        given(order.getShipment()).willReturn(shipment);
        given(order.getProducts()).willReturn(List.of(product1,product2,product3));

        //when
        OrderHistoryFilter orderHistoryFilter=new OrderHistoryFilter(name,null,null,null,null,null);

        //then
        Assertions.assertTrue(orderHistoryFilter.filterOrders(order));
    }

    @Test
    public void testFilterOrdersFalseWithNullValues(){
        //given
        Order order=mock(Order.class);
        Address address=mock(Address.class);
        Shipment shipment=mock(Shipment.class);
        String productName="Jabłko";
        Product product1=mock(Product.class);
        Product product2=mock(Product.class);
        Product product3=mock(Product.class);
        String name="Kowalski";
        BigDecimal price=BigDecimal.valueOf(20.34);
        BigDecimal priceWithTaxes=BigDecimal.valueOf(23.54);
        BigDecimal priceWithTaxes2=BigDecimal.valueOf(21.54);
        CompareType type1=CompareType.GEQ;
        CompareType type2=CompareType.GREATER;

        given(address.getName()).willReturn(name);
        given(shipment.getSenderAddress()).willReturn(address);

        given(product1.getName()).willReturn("Jabłko");

        given(order.getPrice()).willReturn(price);
        given(order.getPriceWithTaxes()).willReturn(priceWithTaxes2);
        given(order.getShipment()).willReturn(shipment);
        given(order.getProducts()).willReturn(List.of(product1,product2,product3));
        //when
        OrderHistoryFilter orderHistoryFilter=new OrderHistoryFilter(null,productName,price,priceWithTaxes,type1,type2);

        //then
        Assertions.assertFalse(orderHistoryFilter.filterOrders(order));
    }
}
