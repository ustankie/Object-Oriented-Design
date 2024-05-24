package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.edu.agh.internetshop.orderfilter.CompareType;
import pl.edu.agh.internetshop.orderfilter.OrderHistoryFilter;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class OrderHistoryTest {

    @Test
    public void testGetOrders(){
        //given
        List<Order> expectedOrders=new ArrayList<>();

        //when
        for(int i=0;i<10;i++){
            Order order=mock(Order.class);
            expectedOrders.add(order);
        }
        OrderHistory orderHistory=new OrderHistory(expectedOrders);

        //then
        Assertions.assertEquals(expectedOrders,orderHistory.getOrders());
    }

    @Test
    public void testFilterOrders(){
        //given
        OrderHistoryFilter historyFilter=mock(OrderHistoryFilter.class);
        Order order1=mock(Order.class);
        Order order2=mock(Order.class);
        Order order3=mock(Order.class);

        given(historyFilter.filterOrders(order1)).willReturn(true);
        given(historyFilter.filterOrders(order2)).willReturn(true);
        given(historyFilter.filterOrders(order3)).willReturn(false);

        //when
        OrderHistory orderHistory=new OrderHistory(List.of(order1,order2,order3));

        //then
        Assertions.assertEquals(orderHistory.filterOrders(historyFilter),List.of(order1,order2));

    }

}
