package pl.edu.agh.internetshop;

import pl.edu.agh.internetshop.orderfilter.OrderHistoryFilter;

import java.util.ArrayList;
import java.util.List;

public class OrderHistory {
    private List<Order> orders;

    public OrderHistory(List<Order> orders){
        this.orders=orders;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public List<Order> filterOrders(OrderHistoryFilter orderFilter){
        return orders.stream().filter(orderFilter::filterOrders).toList();
    }


}
