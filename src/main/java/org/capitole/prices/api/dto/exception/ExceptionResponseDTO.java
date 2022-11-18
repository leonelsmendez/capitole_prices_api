package org.capitole.prices.api.dto.exception;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ExceptionResponseDTO {
    private int status;
    private String message;
    private String errorCode;
}
