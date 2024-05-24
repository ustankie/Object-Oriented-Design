package pl.edu.agh.internetshop;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;


public class Order {
    private static BigDecimal tax_value = BigDecimal.valueOf(1.22);
    private final UUID id;
    private final List<Product> products;
    private boolean paid;
    private Shipment shipment;
    private ShipmentMethod shipmentMethod;
    private PaymentMethod paymentMethod;
    private final BigDecimal defaultProductDiscount = BigDecimal.ONE;
    private BigDecimal orderDiscount = BigDecimal.ONE;
    private final HashMap<Product, BigDecimal> productDiscounts = new HashMap<>();

    public Order(List<Product> products) {
        this.products = products;
        for (Product product : products) {
            productDiscounts.put(product, defaultProductDiscount);
        }
        id = UUID.randomUUID();
        paid = false;
    }

    public BigDecimal getOrderDiscount() {
        return orderDiscount;
    }

    public void setOrderDiscount(BigDecimal orderDiscount) {
        if(orderDiscount.compareTo(BigDecimal.ONE)>0 || orderDiscount.compareTo(BigDecimal.ZERO)<0){
            throw new IllegalArgumentException("Discount must be between 0 and 1!");
        }
        this.orderDiscount = orderDiscount;
    }

    public void setProductDiscount(Product product, BigDecimal discount)throws IllegalArgumentException {
        if(discount.compareTo(BigDecimal.ONE)>0 || discount.compareTo(BigDecimal.ZERO)<0){
            throw new IllegalArgumentException("Discount must be between 0 and 1!");
        }
        productDiscounts.put(product, discount);
    }

    public UUID getId() {
        return id;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public boolean isSent() {
        return shipment != null && shipment.isShipped();
    }

    public boolean isPaid() {
        return paid;
    }

    public Shipment getShipment() {
        return shipment;
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }

    public BigDecimal getPrice() {
        return products.stream()
                .map(product -> product.getPrice().multiply(productDiscounts.get(product)))
                .reduce(BigDecimal.valueOf(0), BigDecimal::add)
                .multiply(orderDiscount);
    }

    public BigDecimal getPriceWithTaxes() {
        return getPrice().multiply(tax_value).setScale(Product.PRICE_PRECISION, RoundingMode.HALF_UP);
    }

    public List<Product> getProducts() {
        return products;
    }

    public ShipmentMethod getShipmentMethod() {
        return shipmentMethod;
    }

    public void setShipmentMethod(ShipmentMethod shipmentMethod) {
        this.shipmentMethod = shipmentMethod;
    }

    public void send() {
        boolean sentSuccesful = getShipmentMethod().send(shipment, shipment.getSenderAddress(), shipment.getRecipientAddress());
        shipment.setShipped(sentSuccesful);
    }

    public void pay(MoneyTransfer moneyTransfer) {
        moneyTransfer.setCommitted(getPaymentMethod().commit(moneyTransfer));
        paid = moneyTransfer.isCommitted();
    }

    public BigDecimal get_tax_value() {
        return tax_value;
    }

    public void set_tax_value(BigDecimal tax_value) {
        Order.tax_value = tax_value;
    }
}
