package org.capitole.prices.api.dto.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class ExceptionResponseDTO {
    private int status;
    private String message;
    private String errorCode;
}
