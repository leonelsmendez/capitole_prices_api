package org.capitole.prices.api.controller;

import org.capitole.prices.api.dto.PriceDTO;
import org.capitole.prices.api.dto.PriceResponseDTO;
import org.capitole.prices.api.entity.Price;
import org.capitole.prices.api.service.IPricesService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Objects;

@RestController
@RequestMapping("/prices")
public class PricesController {

    private final IPricesService pricesService;

    public PricesController(IPricesService pricesService) {
        this.pricesService = pricesService;
        Assert.notNull(this.pricesService, "The prices service cannot be null.");
    }

    @GetMapping("/final_price")
    public PriceResponseDTO getFinalPrice(
        @RequestParam(name = "startDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) final LocalDateTime startDate,
        @RequestParam(name = "productId", required = false) final Integer productId,
        @RequestParam(name = "brandId" , required = false) final Integer brandId
    ) {
        Assert.notNull(startDate, "The start date cannot be null.");
        Assert.isTrue(Objects.nonNull(productId) && productId > 0, "The product id has to be present and be greater than 0.");
        Assert.isTrue(Objects.nonNull(brandId) && brandId > 0, "The brand id has to be present and be greater than 0.");

        Price price = pricesService.getFinalPrice(startDate, productId, brandId);
        return buildResponse(price);
    }

    private PriceResponseDTO buildResponse(Price price) {
        PriceDTO priceDTO = new PriceDTO(
                price.getProductId(),
                price.getBrandId(),
                price.getPriceList(),
                price.getStartDate(),
                price.getEndDate(),
                price.getPrice()
        );
        return new PriceResponseDTO(priceDTO);
    }
}
