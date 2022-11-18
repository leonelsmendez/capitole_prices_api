package org.capitole.prices.api.unit.controller;

import org.capitole.prices.api.controller.PricesController;
import org.capitole.prices.api.dto.PriceResponseDTO;
import org.capitole.prices.api.entity.Price;
import org.capitole.prices.api.service.IPricesService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { PricesController.class })
public class PricesControllerUnitTest {
    @Autowired
    private PricesController target;

    @MockBean
    private IPricesService pricesService;

    @Before
    public void setUp() {
        Price price = new Price(1L, 1, LocalDateTime.now(), LocalDateTime.now(), 1, 1, 1, 10.0, "CURR");

        when(pricesService.getFinalPrice(any(), any(), any())).thenReturn(price);
    }

    @Test
    public void when_targetIsCalled_then_success() {

        Object result = target.getFinalPrice(LocalDateTime.now(), 1, 1);
        Assert.assertNotNull(result);
        Assert.assertTrue(result instanceof PriceResponseDTO);

    }


}
