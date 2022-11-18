package org.capitole.prices.api.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.capitole.prices.api.controller.PricesController;
import org.capitole.prices.api.dto.PriceResponseDTO;
import org.capitole.prices.api.exception.client.PriceNotFoundException;
import org.capitole.prices.api.repository.IPricesRepository;
import org.capitole.prices.api.service.impl.PricesService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.util.NestedServletException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SuppressWarnings("SpellCheckingInspection")
@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = { PricesController.class, PricesService.class, IPricesRepository.class })
@EnableJpaRepositories(basePackages = {"org.capitole.prices.api"})
@EntityScan("org.capitole.prices.api.entity")
public class PricesControllerIntegrationTest {
    @Autowired
    private PricesController target;
    private MockMvc mockMvc;
    private static final Integer BRAND_ID = 1;
    private static final Integer PRODUCT_ID = 35455;
    private static final ObjectMapper mapper = new ObjectMapper().findAndRegisterModules();

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.target).build();
    }

    @Test
    public void when_getFinalPrice_then_success() throws Exception {

        PriceResponseDTO priceResponseDTO1;
        PriceResponseDTO priceResponseDTO2;
        PriceResponseDTO priceResponseDTO3;
        PriceResponseDTO priceResponseDTO4;
        PriceResponseDTO priceResponseDTO5;

        priceResponseDTO1 = mapper.readValue(
            this.mockMvc.perform(get("/prices/final_price")
                .param("startDate", "2020-06-14T10:00:00Z")
                .param("productId", String.valueOf(PRODUCT_ID))
                .param("brandId", String.valueOf(BRAND_ID)))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsByteArray(),
            PriceResponseDTO.class);

        priceResponseDTO2 = mapper.readValue(
            this.mockMvc.perform(get("/prices/final_price")
                .param("startDate", "2020-06-14T16:00:00Z")
                .param("productId", String.valueOf(PRODUCT_ID))
                .param("brandId", String.valueOf(BRAND_ID)))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsByteArray(),
            PriceResponseDTO.class);

        priceResponseDTO3 = mapper.readValue(
            this.mockMvc.perform(get("/prices/final_price")
                .param("startDate", "2020-06-14T21:00:00Z")
                .param("productId", String.valueOf(PRODUCT_ID))
                .param("brandId", String.valueOf(BRAND_ID)))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsByteArray(),
            PriceResponseDTO.class);

        priceResponseDTO4 = mapper.readValue(
            this.mockMvc.perform(get("/prices/final_price")
                .param("startDate", "2020-06-15T10:00:00Z")
                .param("productId", String.valueOf(PRODUCT_ID))
                .param("brandId", String.valueOf(BRAND_ID)))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsByteArray(),
            PriceResponseDTO.class);

        priceResponseDTO5 = mapper.readValue(
            this.mockMvc.perform(get("/prices/final_price")
                .param("startDate", "2020-06-16T21:00:00Z")
                .param("productId", String.valueOf(PRODUCT_ID))
                .param("brandId", String.valueOf(BRAND_ID)))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsByteArray(),
            PriceResponseDTO.class);

        Assert.assertNotNull(priceResponseDTO1);
        Assert.assertNotNull(priceResponseDTO2);
        Assert.assertNotNull(priceResponseDTO3);
        Assert.assertNotNull(priceResponseDTO4);
        Assert.assertNotNull(priceResponseDTO5);

        System.out.println(priceResponseDTO1);
        System.out.println(priceResponseDTO2);
        System.out.println(priceResponseDTO3);
        System.out.println(priceResponseDTO4);
        System.out.println(priceResponseDTO5);
    }

    @Test(expected = PriceNotFoundException.class)
    public void when_getFinalPrice_then_priceNotFoundException() throws Exception {

        final Integer nonExistentProductId = 9999;

        try {
            this.mockMvc.perform(get("/prices/final_price")
                .param("startDate", "2020-06-14T10:00:00Z")
                .param("productId", String.valueOf(nonExistentProductId))
                .param("brandId", String.valueOf(BRAND_ID)));
        } catch (NestedServletException nestedServletException) {
            PriceNotFoundException priceNotFoundException = (PriceNotFoundException) nestedServletException.getCause();
            throw priceNotFoundException;
        }
    }
}
