package org.capitole.prices.api.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PriceResponseDTO {

    private PriceDTO price;

    @Override
    public String toString() {
        return "PriceResponseDTO{" +
                "price=" + price +
                '}';
    }
}
