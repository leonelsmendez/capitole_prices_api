package org.capitole.prices.api.unit.dto;

import org.capitole.prices.api.dto.PriceDTO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

public class PriceDTOUnitTest {

    private PriceDTO target1, target2, target3;

    private final Integer PRODUCT_ID = 1;
    private final Integer BRAND_ID = 1;
    private final Integer PRICE_LIST = 1;
    private final LocalDateTime START_DATE = LocalDateTime.of(2020, 01, 01, 00, 00 ,00);
    private final LocalDateTime END_DATE = LocalDateTime.of(2020, 01, 01, 00, 00 ,00);
    private final double PRICE = 10.0;

    @Before
    public void setUp() {
        target1 = new PriceDTO();
        target2 = new PriceDTO(PRODUCT_ID, BRAND_ID, PRICE_LIST, START_DATE, END_DATE, PRICE);
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
        target1.setPrice(PRICE);

        Assert.assertEquals(target1.getProductId(), PRODUCT_ID);
        Assert.assertEquals(target1.getBrandId(), BRAND_ID);
        Assert.assertEquals(target1.getPriceList(), PRICE_LIST);
        Assert.assertEquals(target1.getStartDate(), START_DATE);
        Assert.assertEquals(target1.getEndDate(), END_DATE);
    }

    @Test
    public void builder_test() {
        target3 = PriceDTO
            .builder()
            .productId(PRODUCT_ID)
            .brandId(BRAND_ID)
            .priceList(PRICE_LIST)
            .startDate(START_DATE)
            .endDate(END_DATE)
            .price(PRICE)
            .build();

        Assert.assertEquals(target3.getProductId(), PRODUCT_ID);
        Assert.assertEquals(target3.getBrandId(), BRAND_ID);
        Assert.assertEquals(target3.getPriceList(), PRICE_LIST);
        Assert.assertEquals(target3.getStartDate(), START_DATE);
        Assert.assertEquals(target3.getEndDate(), END_DATE);

    }
}
