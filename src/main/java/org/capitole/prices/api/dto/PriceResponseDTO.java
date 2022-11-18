package org.capitole.prices.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PriceResponseDTO {

    private PriceDTO price;

    @Override
    public String toString() {
        return "PriceResponseDTO{" +
                "price=" + price +
                '}';
    }
}
