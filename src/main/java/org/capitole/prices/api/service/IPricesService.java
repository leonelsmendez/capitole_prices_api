package org.capitole.prices.api.service;

import org.capitole.prices.api.entity.Price;

import java.time.LocalDateTime;

public interface IPricesService {

    Price getFinalPrice(LocalDateTime startDate, Integer productId, Integer brandId);
}
