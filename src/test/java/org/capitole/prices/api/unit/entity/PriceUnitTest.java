package org.capitole.prices.api.unit.entity;

import org.capitole.prices.api.entity.Price;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

public class PriceUnitTest {

    private Price target1, target2, target3;

    private final Integer PRODUCT_ID = 1;
    private final Integer BRAND_ID = 1;
    private final Integer PRICE_LIST = 1;

    private final Integer PRIORITY = 1;
    private final LocalDateTime START_DATE = LocalDateTime.of(2020, 01, 01, 00, 00 ,00);
    private final LocalDateTime END_DATE = LocalDateTime.of(2020, 01, 01, 00, 00 ,00);
    private final double PRICE = 10.0;

    private final String CURR = "EUR";

    @Before
    public void setUp() {
        target1 = new Price();
        target2 = new Price(1L, PRODUCT_ID, BRAND_ID, PRICE_LIST, START_DATE, END_DATE, PRIORITY, PRICE, CURR);
    }

    @Test
    public void noArgs_and_allArgs_constructors_test() {
        Assert.assertNotNull(target1);
        Assert.assertNotNull(target2);
    }

    @Test
    public void getters_and_setters_test() {
        target1.setProductId(PRODUCT_ID);
        target1.setBrandId(BRAND_ID);
        target1.setPriceList(PRICE_LIST);
        target1.setStartDate(START_DATE);
        target1.setEndDate(END_DATE);
        target1.setPriority(PRIORITY);
        target1.setPrice(PRICE);
        target1.setCurr(CURR);

        Assert.assertEquals(target1.getProductId(), PRODUCT_ID);
        Assert.assertEquals(target1.getBrandId(), BRAND_ID);
        Assert.assertEquals(target1.getPriceList(), PRICE_LIST);
        Assert.assertEquals(target1.getStartDate(), START_DATE);
        Assert.assertEquals(target1.getEndDate(), END_DATE);
        Assert.assertEquals(target1.getPriority(), PRIORITY);
        Assert.assertEquals(target1.getCurr(), CURR);
    }

    @Test
    public void builder_test() {
        target3 = Price
                .builder()
                .productId(PRODUCT_ID)
                .brandId(BRAND_ID)
                .priceList(PRICE_LIST)
                .startDate(START_DATE)
                .endDate(END_DATE)
                .priority(PRIORITY)
                .price(PRICE)
                .curr(CURR)
                .build();

        Assert.assertEquals(target3.getProductId(), PRODUCT_ID);
        Assert.assertEquals(target3.getBrandId(), BRAND_ID);
        Assert.assertEquals(target3.getPriceList(), PRICE_LIST);
        Assert.assertEquals(target3.getStartDate(), START_DATE);
        Assert.assertEquals(target3.getEndDate(), END_DATE);
        Assert.assertEquals(target3.getPriority(), PRIORITY);
        Assert.assertEquals(target3.getCurr(), CURR);
    }
}
