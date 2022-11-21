package org.capitole.prices.api.unit.service;

import org.capitole.prices.api.entity.Price;
import org.capitole.prices.api.exception.client.PriceNotFoundException;
import org.capitole.prices.api.repository.IPricesRepository;
import org.capitole.prices.api.service.IPricesService;
import org.capitole.prices.api.service.impl.PricesService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PricesServiceUnitTest {

    private IPricesService target;
    private IPricesRepository pricesRepository;
    private final LocalDateTime START_DATE = LocalDateTime.of(2020, 01, 01, 00, 00 ,00);
    private final Integer PRODUCT_ID = 1;
    private final Integer BRAND_ID = 1;

    @Before
    public void setUp() {
        this.pricesRepository = mock(IPricesRepository.class);
        this.target = new PricesService(pricesRepository);
    }

    @Test
    public void when_targetIsCalled_then_success() {
        Price price1 = new Price();
        Price price2 = new Price();

        price1.setPriority(0);
        price2.setPriority(1);

        List<Price> prices = new ArrayList<>();
        prices.add(price1);
        prices.add(price2);

        when(pricesRepository.findByStartDateAndProductIdAndBrandId(START_DATE, PRODUCT_ID, BRAND_ID)).thenReturn(prices);

        Price result = target.getFinalPrice(START_DATE, PRODUCT_ID, BRAND_ID);

        Assert.assertNotNull(result);
        Assert.assertEquals(result.getPriority(), Integer.valueOf(1));
    }

    @Test(expected = PriceNotFoundException.class)
    public void when_targetIsCalled_then_priceNotFoundException() {

        List<Price> prices = new ArrayList<>();

        when(pricesRepository.findByStartDateAndProductIdAndBrandId(START_DATE, PRODUCT_ID, BRAND_ID)).thenReturn(prices);

        target.getFinalPrice(START_DATE, PRODUCT_ID, BRAND_ID);
    }
}
