package org.capitole.prices.api.unit.dto;

import org.capitole.prices.api.dto.PriceDTO;
import org.capitole.prices.api.dto.PriceResponseDTO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

public class PriceResponseDTOUnitTest {

    private PriceResponseDTO target1, target2, target3;

    private PriceDTO priceDTO;
    private final Integer PRODUCT_ID = 1;
    private final Integer BRAND_ID = 1;
    private final Integer PRICE_LIST = 1;
    private final LocalDateTime START_DATE = LocalDateTime.of(2020, 01, 01, 00, 00 ,00);
    private final LocalDateTime END_DATE = LocalDateTime.of(2020, 01, 01, 00, 00 ,00);
    private final double PRICE = 10.0;

    @Before
    public void setUp() {
        this.priceDTO = new PriceDTO(PRODUCT_ID, BRAND_ID, PRICE_LIST, START_DATE, END_DATE, PRICE);
        this.target1 = new PriceResponseDTO();
        this.target2 = new PriceResponseDTO(priceDTO);
    }

    @Test
    public void noArgs_and_allArgs_constructors_test() {
        Assert.assertNotNull(target1);
        Assert.assertNotNull(target2);
    }

    @Test
    public void getters_and_setters_test() {
        target1.setPrice(priceDTO);

        Assert.assertEquals(target1.getPrice(), priceDTO);
    }

    @Test
    public void builder_test() {
        target3 = PriceResponseDTO.builder()
                .price(priceDTO)
                .build();

        Assert.assertEquals(target3.getPrice(), priceDTO);
    }
}
