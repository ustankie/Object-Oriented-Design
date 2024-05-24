package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static pl.edu.agh.internetshop.util.CustomAssertions.assertBigDecimalCompareValue;

public class OrderTest {

    private Order getOrderWithMockedProducts() {
        List<Product> products = new ArrayList<>();
        for(int i=0;i<10;i++){
            Product product=mock(Product.class);
            products.add(product);
        }
        return new Order(products);
    }

    @Test
    public void testGetProductThroughOrder() {
        // given
        List<Product> expectedProducts = new ArrayList<>();
        for(int i=0;i<10;i++){
            Product product=mock(Product.class);
            expectedProducts.add(product);
        }
        Order order = new Order(expectedProducts);
        // when
        List<Product> actualProducts = order.getProducts();

        // then
        assertSame(expectedProducts, actualProducts);
    }

    @Test
    public void testSetShipment() throws Exception {
        // given
        Order order = getOrderWithMockedProducts();
        Shipment expectedShipment = mock(Shipment.class);

        // when
        order.setShipment(expectedShipment);

        // then
        assertSame(expectedShipment, order.getShipment());
    }

    @Test
    public void testShipmentWithoutSetting() throws Exception {
        // given
        Order order = getOrderWithMockedProducts();

        // when

        // then
        assertNull(order.getShipment());
    }

    @Test
    public void testGetPrice() throws Exception {
        // given
        BigDecimal expectedProductPrice = BigDecimal.valueOf(150);
        List<Product> products=new ArrayList<>();

        for(int i=0;i<10;i++){
            Product product=mock(Product.class);
            given(product.getPrice()).willReturn(BigDecimal.valueOf(15));
            products.add(product);
        }
        Order order = new Order(products);

        // when
        BigDecimal actualProductPrice = order.getPrice();

        // then
        assertBigDecimalCompareValue(expectedProductPrice, actualProductPrice);
    }

    @Test
    public void testSetTaxValue() {
        //given
        Order order = getOrderWithMockedProducts();

        //when
        order.set_tax_value(BigDecimal.valueOf(1.23));

        //then
        assertBigDecimalCompareValue(order.get_tax_value(), BigDecimal.valueOf(1.23));

    }

//    @Test
//    public void testTaxValueWithoutSetting() {
//        //given
//        Order order = getOrderWithMockedProducts();
//
//        //when
//        System.out.println(order.get_tax_value());
//        //then
//        assertBigDecimalCompareValue(order.get_tax_value(), BigDecimal.valueOf(1.22));
//
//    }


    private Order getOrderWithCertainProductPrice(double productPriceValue) {
        List<Product> products = new ArrayList<>();
        for(int i=0;i<10;i++){
            Product product=mock(Product.class);
            given(product.getPrice()).willReturn(BigDecimal.valueOf(productPriceValue/10));
            products.add(product);
        }
        return new Order(products);
    }

    @Test
    public void testPriceWithTaxesWithoutRoundUp() {
        // given

        // when
        Order order = getOrderWithCertainProductPrice(2); // 2 PLN
        order.set_tax_value(BigDecimal.valueOf(1.22));

        // then
        assertBigDecimalCompareValue(order.getPriceWithTaxes(), BigDecimal.valueOf(2.44)); // 2.44 PLN
    }

    @Test
    public void testPriceWithTaxesWithoutRoundUpNewTaxPrice() {
        // given

        // when
        Order order = getOrderWithCertainProductPrice(2); // 2 PLN
        order.set_tax_value(BigDecimal.valueOf(1.23));

        // then
        assertBigDecimalCompareValue(order.getPriceWithTaxes(), BigDecimal.valueOf(2.46)); // 2.46 PLN


    }

    @Test
    public void testPriceWithTaxesWithRoundDownNewTaxPrice() {
        // given

        // when
        Order order = getOrderWithCertainProductPrice(0.01); // 0.01 PLN
        order.set_tax_value(BigDecimal.valueOf(1.23));

        // then
        assertBigDecimalCompareValue(order.getPriceWithTaxes(), BigDecimal.valueOf(0.01)); // 0.01 PLN
        // given

        // when
        Order order2 = getOrderWithCertainProductPrice(5.23); // 5.23 PLN
        order2.set_tax_value(BigDecimal.valueOf(1.23));

        // then
        assertBigDecimalCompareValue(order2.getPriceWithTaxes(), BigDecimal.valueOf(6.43)); //6.43 PLN

    }

    @Test
    public void testPriceWithTaxesWithRoundDown() {
        // given

        // when
        Order order = getOrderWithCertainProductPrice(0.01); // 0.01 PLN

        // then
        assertBigDecimalCompareValue(order.getPriceWithTaxes(), BigDecimal.valueOf(0.01)); // 0.01 PLN

    }


    @Test
    public void testPriceWithTaxesWithRoundUpNewTaxValue() {
        // given

        // when
        Order order = getOrderWithCertainProductPrice(0.03); // 0.03 PLN
        order.set_tax_value(BigDecimal.valueOf(1.23));

        // then
        assertBigDecimalCompareValue(order.getPriceWithTaxes(), BigDecimal.valueOf(0.04)); // 0.04 PLN

    }


    @Test
    public void testPriceWithTaxesWithRoundUp() {
        // given

        // when
        Order order = getOrderWithCertainProductPrice(0.03); // 0.03 PLN

        // then
        assertBigDecimalCompareValue(order.getPriceWithTaxes(), BigDecimal.valueOf(0.04)); // 0.04 PLN

    }

    @Test
    public void testSetShipmentMethod() {
        // given
        Order order = getOrderWithMockedProducts();
        ShipmentMethod surface = mock(SurfaceMailBus.class);

        // when
        order.setShipmentMethod(surface);

        // then
        assertSame(surface, order.getShipmentMethod());
    }

    @Test
    public void testSending() {
        // given
        Order order = getOrderWithMockedProducts();
        SurfaceMailBus surface = mock(SurfaceMailBus.class);
        Shipment shipment = mock(Shipment.class);
        given(shipment.isShipped()).willReturn(true);

        // when
        order.setShipmentMethod(surface);
        order.setShipment(shipment);
        order.send();

        // then
        assertTrue(order.isSent());
    }

    @Test
    public void testIsSentWithoutSending() {
        // given
        Order order = getOrderWithMockedProducts();
        Shipment shipment = mock(Shipment.class);
        given(shipment.isShipped()).willReturn(true);

        // when

        // then
        assertFalse(order.isSent());
    }

    @Test
    public void testWhetherIdExists() throws Exception {
        // given
        Order order = getOrderWithMockedProducts();

        // when

        // then
        assertNotNull(order.getId());
    }

    @Test
    public void testSetPaymentMethod() throws Exception {
        // given
        Order order = getOrderWithMockedProducts();
        PaymentMethod paymentMethod = mock(MoneyTransferPaymentTransaction.class);

        // when
        order.setPaymentMethod(paymentMethod);

        // then
        assertSame(paymentMethod, order.getPaymentMethod());
    }

    @Test
    public void testPaying() throws Exception {
        // given
        Order order = getOrderWithMockedProducts();
        PaymentMethod paymentMethod = mock(MoneyTransferPaymentTransaction.class);
        given(paymentMethod.commit(any(MoneyTransfer.class))).willReturn(true);
        MoneyTransfer moneyTransfer = mock(MoneyTransfer.class);
        given(moneyTransfer.isCommitted()).willReturn(true);

        // when
        order.setPaymentMethod(paymentMethod);
        order.pay(moneyTransfer);

        // then
        assertTrue(order.isPaid());
    }

    @Test
    public void testIsPaidWithoutPaying() {
        // given
        Order order = getOrderWithMockedProducts();

        // when

        // then
        assertFalse(order.isPaid());
    }

    @Test
    public void testProductDiscountsIllegalArgument(){
        //given
        List<Product> products = new ArrayList<>();
        for(int i=0;i<10;i++){
            Product product=mock(Product.class);
            given(product.getPrice()).willReturn(BigDecimal.valueOf(15));
            products.add(product);
        }
        //when
        Order order=new Order(products);

        //then
        assertThrows(IllegalArgumentException.class,()->order.setProductDiscount(products.get(0),BigDecimal.valueOf(2)));
        assertThrows(IllegalArgumentException.class,()->order.setProductDiscount(products.get(0),BigDecimal.valueOf(-0.1)));
    }

    @Test
    public void testProductDiscountsLegalArgument(){
        //given
        BigDecimal expectedPrice=BigDecimal.valueOf(14.28);
        List<Product> products = new ArrayList<>();
        for(int i=0;i<10;i++){
            Product product=mock(Product.class);
            given(product.getPrice()).willReturn(BigDecimal.valueOf(1.7));
            products.add(product);
        }
        //when
        Order order=new Order(products);

        order.setProductDiscount(products.get(0),BigDecimal.ZERO);
        order.setProductDiscount(products.get(1),BigDecimal.valueOf(0.4));

        //then
        assertBigDecimalCompareValue(order.getPrice(),expectedPrice);
    }

    @Test
    public void testOrderDiscountsIllegalArgument(){
        //given
        List<Product> products = new ArrayList<>();
        for(int i=0;i<10;i++){
            Product product=mock(Product.class);
            given(product.getPrice()).willReturn(BigDecimal.valueOf(15));
            products.add(product);
        }
        //when
        Order order=new Order(products);

        //then
        assertThrows(IllegalArgumentException.class,()->order.setOrderDiscount(BigDecimal.valueOf(2)));
        assertThrows(IllegalArgumentException.class,()->order.setOrderDiscount(BigDecimal.valueOf(-0.1)));
    }

    @Test
    public void testOrderDiscountsLegalArgument(){
        //given
        BigDecimal expectedPrice=BigDecimal.valueOf(6.8);
        List<Product> products = new ArrayList<>();
        for(int i=0;i<10;i++){
            Product product=mock(Product.class);
            given(product.getPrice()).willReturn(BigDecimal.valueOf(1.7));
            products.add(product);
        }
        //when
        Order order=new Order(products);
        order.setOrderDiscount(BigDecimal.valueOf(0.4));

        //then
        assertBigDecimalCompareValue(order.getPrice(),expectedPrice);
    }

    @Test
    public void testOrderAndProductDiscounts(){
        //given
        BigDecimal expectedPrice=BigDecimal.valueOf(5.712);
        List<Product> products = new ArrayList<>();
        for(int i=0;i<10;i++){
            Product product=mock(Product.class);
            given(product.getPrice()).willReturn(BigDecimal.valueOf(1.7));
            products.add(product);
        }
        //when
        Order order=new Order(products);

        order.setOrderDiscount(BigDecimal.valueOf(0.4));
        order.setProductDiscount(products.get(0),BigDecimal.ZERO);
        order.setProductDiscount(products.get(1),BigDecimal.valueOf(0.4));

        //then
        assertBigDecimalCompareValue(order.getPrice(),expectedPrice);
    }

    @Test
    public void testOrderWithDiscountsAndTaxesWithoutRound(){
        //given
        BigDecimal expectedPrice=BigDecimal.valueOf(51.66);
        List<Product> products = new ArrayList<>();
        for(int i=0;i<10;i++){
            Product product=mock(Product.class);
            given(product.getPrice()).willReturn(BigDecimal.valueOf(10));
            products.add(product);
        }
        //when
        Order order=new Order(products);

        order.setOrderDiscount(BigDecimal.valueOf(0.5));
        order.setProductDiscount(products.get(0),BigDecimal.ZERO);
        order.setProductDiscount(products.get(1),BigDecimal.valueOf(0.4));
        order.set_tax_value(BigDecimal.valueOf(1.23));

        //then
        assertBigDecimalCompareValue(order.getPriceWithTaxes(),expectedPrice);
    }

    @Test
    public void testOrderWithDiscountsAndTaxesWithRoundUp(){
        //given
        BigDecimal expectedPrice=BigDecimal.valueOf(7.03);
        List<Product> products = new ArrayList<>();
        for(int i=0;i<10;i++){
            Product product=mock(Product.class);
            given(product.getPrice()).willReturn(BigDecimal.valueOf(1.7));
            products.add(product);
        }
        //when
        Order order=new Order(products);
        order.set_tax_value(BigDecimal.valueOf(1.23));

        order.setOrderDiscount(BigDecimal.valueOf(0.4));
        order.setProductDiscount(products.get(0),BigDecimal.ZERO);
        order.setProductDiscount(products.get(1),BigDecimal.valueOf(0.4));

        //then
        assertBigDecimalCompareValue(order.getPriceWithTaxes(),expectedPrice);
    }

    @Test
    public void testOrderWithDiscountsAndTaxesWithRoundDown(){
        //given
        BigDecimal expectedPrice=BigDecimal.valueOf(8.78);
        List<Product> products = new ArrayList<>();
        for(int i=0;i<10;i++){
            Product product=mock(Product.class);
            given(product.getPrice()).willReturn(BigDecimal.valueOf(1.7));
            products.add(product);
        }
        //when
        Order order=new Order(products);
        order.set_tax_value(BigDecimal.valueOf(1.23));

        order.setOrderDiscount(BigDecimal.valueOf(0.5));
        order.setProductDiscount(products.get(0),BigDecimal.ZERO);
        order.setProductDiscount(products.get(1),BigDecimal.valueOf(0.4));

        //then
        assertBigDecimalCompareValue(order.getPriceWithTaxes(),expectedPrice);
    }


}
