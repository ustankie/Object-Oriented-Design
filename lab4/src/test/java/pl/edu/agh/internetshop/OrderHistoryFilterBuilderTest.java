package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.edu.agh.internetshop.orderfilter.CompareType;
import pl.edu.agh.internetshop.orderfilter.OrderHistoryFilter;
import pl.edu.agh.internetshop.orderfilter.OrderHistoryFilterBuilder;

import java.math.BigDecimal;

import static org.mockito.Mockito.mock;

public class OrderHistoryFilterBuilderTest {

    @Test
    public void testSetName(){
        //given
        OrderHistoryFilter expectedFilter=new OrderHistoryFilter("Kowalski",null,null,
                null,null,null);
        //when
        OrderHistoryFilterBuilder builder=new OrderHistoryFilterBuilder();

        builder.setName("Kowalski");

        //then
        Assertions.assertEquals(builder.getResult(),expectedFilter);
    }

    @Test
    public void testSetPrice(){
        //given
        OrderHistoryFilter expectedFilter=new OrderHistoryFilter(null,null,BigDecimal.valueOf(1.43),
                null, CompareType.EQUAL,null);
        //when
        OrderHistoryFilterBuilder builder=new OrderHistoryFilterBuilder();

        builder.setPrice(BigDecimal.valueOf(1.43), CompareType.EQUAL );

        //then
        Assertions.assertEquals(builder.getResult(),expectedFilter);
    }

    @Test
    public void testSetPriceWithTaxes(){
        //given
        OrderHistoryFilter expectedFilter=new OrderHistoryFilter(null,null,null,BigDecimal.valueOf(1.43),
                 null,CompareType.GEQ);
        //when
        OrderHistoryFilterBuilder builder=new OrderHistoryFilterBuilder();

        builder.setPriceWithTaxes(BigDecimal.valueOf(1.43), CompareType.GEQ );

        //then
        Assertions.assertEquals(builder.getResult(),expectedFilter);
    }

    @Test
    public void testSetProductName(){
        //given
        String product="Jabłko";
        OrderHistoryFilter expectedFilter=new OrderHistoryFilter(null,product,
                null,null,null,null);
        //when
        OrderHistoryFilterBuilder builder=new OrderHistoryFilterBuilder();

        builder.setProductName(product);

        //then
        Assertions.assertEquals(builder.getResult(),expectedFilter);
    }
}
