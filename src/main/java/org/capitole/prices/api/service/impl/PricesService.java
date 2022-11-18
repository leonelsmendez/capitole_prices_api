package org.capitole.prices.api.service.impl;

import org.capitole.prices.api.entity.Price;
import org.capitole.prices.api.exception.client.PriceNotFoundException;
import org.capitole.prices.api.repository.IPricesRepository;
import org.capitole.prices.api.service.IPricesService;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Service
public class PricesService implements IPricesService {

    private IPricesRepository pricesRepository;

    public PricesService(IPricesRepository pricesRepository) {
        this.pricesRepository = pricesRepository;
        Assert.notNull(pricesRepository, "The prices repository cannot be null.");
    }

    @Override
    public Price getFinalPrice(LocalDateTime startDate, Integer productId, Integer brandId) {
        List<Price> prices = pricesRepository.findByStartDateAndProductIdAndBrandId(startDate, productId, brandId);

        if (prices.isEmpty()) {
            throw new PriceNotFoundException("It was not possible to find a price.");
        }

        Price result = prices.stream().max(Comparator.comparing(Price::getPriority)).get();

        return result;
    }
}
